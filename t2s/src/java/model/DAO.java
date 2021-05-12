/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RodrigoLopes
 */
public class DAO {
    
         /** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.1:3306/t2sdb?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "admin";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
        @SuppressWarnings("UseSpecificCatch")
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir container.
	 *
	 * @param container the container
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public void inserirContainer(Container container) {
		String create = "insert into container (num_container,cliente,tipo,status,categoria) values (?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, container.getNum_container());
			pst.setString(2, container.getCliente());
			pst.setString(3, container.getTipo());
			pst.setString(4, container.getStatus());
			pst.setString(5, container.getCategoria());
			pst.execute();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar containeres.
	 *
	 * @return the array list
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public ArrayList<Container> listarContaineres() {
		ArrayList<Container> container = new ArrayList<>();
		String read = "select * from container order by id_cont";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id_cont = rs.getInt(1);
				String num_container = rs.getString(2);
				String cliente = rs.getString(3);
				String tipo = rs.getString(4);
				String status = rs.getString(5);
				String categoria = rs.getString(6);
				container.add(new Container(id_cont, num_container, cliente, tipo, status, categoria));
			}
			con.close();
			return container;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar container.
	 *
	 * @param container the container
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public void selecionarContainer(Container container) {
		String read2 = "select * from container where id_cont = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, container.getId_cont());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				container.setId_cont(rs.getInt(1));
				container.setNum_container(rs.getString(2));
				container.setCliente(rs.getString(3));
				container.setTipo(rs.getString(4));
				container.setStatus(rs.getString(5));
				container.setCategoria(rs.getString(6));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar container.
	 *
	 * @param container the container
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public void alterarContainer(Container container) {
		String update = "update container set num_container = ?,cliente = ?,tipo = ?,status = ?,categoria = ? where id_cont = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, container.getNum_container());
			pst.setString(2, container.getCliente());
			pst.setString(3, container.getTipo());
			pst.setString(4, container.getStatus());
			pst.setString(5, container.getCategoria());
			pst.setInt(6, container.getId_cont());
			pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar container.
	 *
	 * @param container the container
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public void deletarContainer(Container container) {
		String delete = "delete from container where id_cont = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, container.getId_cont());
			pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * Inserir movimentacao.
	 *
	 * @param moviment the moviment
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public void inserirMovimentacao(Movimentacao moviment) {
		String create = "insert into movimentacao (container,movimentacao,data_inicio,data_final) values (?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, moviment.getContainer());
			pst.setString(2, moviment.getMovimentacao());
			pst.setString(3, moviment.getData_inicio());
			pst.setString(4, moviment.getData_final());
			pst.execute();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar movimentacoes.
	 *
	 * @return the array list
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public ArrayList<Movimentacao> listarMovimentacoes() {
		ArrayList<Movimentacao> moviment = new ArrayList<>();
		String read = "select * from movimentacao order by id_mov";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id_mov = rs.getInt(1);
				String container = rs.getString(2);
				String movimentacao = rs.getString(3);
				String data_inicio = rs.getString(4);
				String data_final = rs.getString(5);
				moviment.add(new Movimentacao(id_mov, container, movimentacao, data_inicio, data_final));
			}
			con.close();
			return moviment;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar movimentacao.
	 *
	 * @param moviment the moviment
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public void selecionarMovimentacao(Movimentacao moviment) {
		String read2 = "select * from movimentacao where id_mov = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, moviment.getId_mov());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				moviment.setId_mov(rs.getInt(1));
				moviment.setContainer(rs.getString(2));
				moviment.setMovimentacao(rs.getString(3));
				moviment.setData_inicio(rs.getString(4));
				moviment.setData_final(rs.getString(5));
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar movimentacao.
	 *
	 * @param moviment the moviment
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public void alterarMovimentacao(Movimentacao moviment) {
		String create = "update movimentacao set container = ?,movimentacao = ?,data_inicio = ?,data_final = ? where id_mov = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, moviment.getContainer());
			pst.setString(2, moviment.getMovimentacao());
			pst.setString(3, moviment.getData_inicio());
			pst.setString(4, moviment.getData_final());
			pst.setInt(5, moviment.getId_mov());
			pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar movimentacao.
	 *
	 * @param moviment the moviment
	 */
        @SuppressWarnings("ConvertToTryWithResources")
	public void deletarMovimentacao(Movimentacao moviment) {
		String delete = "delete from movimentacao where id_mov = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, moviment.getId_mov());
			pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}