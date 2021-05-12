/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.RequestDispatcher;

import model.DAO;
import model.Container;
import model.Movimentacao;

/**
 *
 * @author elisa
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/main_cont", "/insert_cont", "/select_cont", "/update_cont", "/delete_cont",
		"/report_cont", "/main_mov", "/insert_mov", "/select_mov", "/update_mov", "/delete_mov", "/report_mov"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The container. */
	Container container = new Container();
	
	/** The moviment. */
	Movimentacao moviment = new Movimentacao();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
        @SuppressWarnings({"override", "ConvertToStringSwitch"})
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main_cont")) {
			containeres(request, response);
		} else if (action.equals("/insert_cont")) {
			adicionarContainer(request, response);
		} else if (action.equals("/select_cont")) {
			listarContainer(request, response);
		} else if (action.equals("/update_cont")) {
			editarContainer(request, response);
		} else if (action.equals("/delete_cont")) {
			removerContainer(request, response);
		} else if (action.equals("/report_cont")) {
			gerarRelatorioCont(request, response);
		} else if (action.equals("/main_mov")) {
			movimentacoes(request, response);
		} else if (action.equals("/insert_mov")) {
			adicionarMovimentacao(request, response);
		} else if (action.equals("/select_mov")) {
			listarMovimentacao(request, response);
		} else if (action.equals("/update_mov")) {
			editarMovimentacao(request, response);
		} else if (action.equals("/delete_mov")) {
			removerMovimentacao(request, response);
		} else if (action.equals("/report_mov")) {
			gerarRelatorioMov(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Containeres.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void containeres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Container> lista = dao.listarContaineres();
		request.setAttribute("containeres", lista);
		RequestDispatcher rd = request.getRequestDispatcher("container.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar container.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		container.setNum_container(request.getParameter("num_container"));
		container.setCliente(request.getParameter("cliente"));
		container.setTipo(request.getParameter("tipo"));
		container.setStatus(request.getParameter("status"));
		container.setCategoria(request.getParameter("categoria"));
		dao.inserirContainer(container);
		response.sendRedirect("main_cont");
	}

	/**
	 * Listar container.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		container.setId_cont(Integer.parseInt(request.getParameter("id_cont")));
		dao.selecionarContainer(container);
		request.setAttribute("num_container", container.getNum_container());
		request.setAttribute("cliente", container.getCliente());
		request.setAttribute("tipo", container.getTipo());
		request.setAttribute("status", container.getStatus());
		request.setAttribute("categoria", container.getCategoria());
		RequestDispatcher rd = request.getRequestDispatcher("editarContainer.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar container.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		container.setNum_container(request.getParameter("num_container"));
		container.setCliente(request.getParameter("cliente"));
		container.setTipo(request.getParameter("tipo"));
		container.setStatus(request.getParameter("status"));
		container.setCategoria(request.getParameter("categoria"));
		dao.alterarContainer(container);
		response.sendRedirect("main_cont");
	}

	/**
	 * Remover container.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerContainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		container.setId_cont(Integer.parseInt(request.getParameter("id_cont")));
		dao.deletarContainer(container);
		response.sendRedirect("main_cont");
	}

	/**
	 * Gerar relatorio cont.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
        @SuppressWarnings("UseSpecificCatch")
	protected void gerarRelatorioCont(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "container.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Containeres:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(5);
			PdfPCell col1 = new PdfPCell(new Paragraph("Container"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Tipo"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Status"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Categoria"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			ArrayList<Container> lista = dao.listarContaineres();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNum_container());
				tabela.addCell(lista.get(i).getCliente());
				tabela.addCell(lista.get(i).getTipo());
				tabela.addCell(lista.get(i).getStatus());
				tabela.addCell(lista.get(i).getCategoria());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}

	/**
	 * Movimentacoes.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void movimentacoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Movimentacao> lista = dao.listarMovimentacoes();
		request.setAttribute("movimentacoes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("movimentacao.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar movimentacao.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarMovimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		moviment.setContainer(request.getParameter("container"));
		moviment.setMovimentacao(request.getParameter("movimentacao"));
		moviment.setData_inicio(request.getParameter("data_inicio"));
		moviment.setData_final(request.getParameter("data_final"));
		dao.inserirMovimentacao(moviment);
		response.sendRedirect("main_mov");
	}


	/**
	 * Listar movimentacao.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarMovimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		moviment.setId_mov(Integer.parseInt(request.getParameter("id_mov")));
		dao.selecionarMovimentacao(moviment);
		request.setAttribute("container", moviment.getContainer());
		request.setAttribute("movimentacao", moviment.getMovimentacao());
		request.setAttribute("data_inicio", moviment.getData_inicio());
		request.setAttribute("data_final", moviment.getData_final());
		RequestDispatcher rd = request.getRequestDispatcher("editarMovimentacao.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar movimentacao.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarMovimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		moviment.setContainer(request.getParameter("container"));
		moviment.setMovimentacao(request.getParameter("movimentacao"));
		moviment.setData_inicio(request.getParameter("data_inicio"));
		moviment.setData_final(request.getParameter("data_final"));
		dao.alterarMovimentacao(moviment);
		response.sendRedirect("main_mov");
	}

	/**
	 * Remover movimentacao.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerMovimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		moviment.setId_mov(Integer.parseInt(request.getParameter("id_mov")));
		dao.deletarMovimentacao(moviment);
		response.sendRedirect("main_mov");
	}

	/**
	 * Gerar relatorio mov.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
        @SuppressWarnings("UseSpecificCatch")
	protected void gerarRelatorioMov(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "movimentacao.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Movimentações:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Container"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Movimentação"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Data e Hora do Início"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data e Hora do Final"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			ArrayList<Movimentacao> lista = dao.listarMovimentacoes();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getContainer());
				tabela.addCell(lista.get(i).getMovimentacao());
				tabela.addCell(lista.get(i).getData_inicio());
				tabela.addCell(lista.get(i).getData_final());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}