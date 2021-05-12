<%-- 
    Document   : movimentação
    Created on : 11 de mai. de 2021, 21:44:34
    Author     : RodrigoLopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movimentacao"%>
<%@page import="java.util.ArrayList"%>

<%
    ArrayList<Movimentacao> lista = (ArrayList<Movimentacao>) request.getAttribute("movimentacoes");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto T2S</title>
        <link rel="icon" href="imagens/TruckYellow.png">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1 align="center">Projeto T2S</h1>
        <div align="center">
            <a href="novaMovimentacao.html" class="Botao1">Nova Movimentação</a>
            <a href="report_mov" class="Botao2">Relatório</a>
            <a href="main_cont" class="Botao1">Container</a>
        </div>
        <table align="center" id="tabela">
            <thead>
                <tr>
                    <th>Container</th>
                    <th>Movimentação</th>
                    <th>Data e Hora do Início</th>
                    <th>Data e Hora do Final</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < lista.size(); i++) {
                %>
                <tr>
                    <td><%=lista.get(i).getContainer()%></td>
                    <td><%=lista.get(i).getMovimentacao()%></td>
                    <td><%=lista.get(i).getData_inicio()%></td>
                    <td><%=lista.get(i).getData_final()%></td>
                    <td><a href="select_mov?id_mov=<%=lista.get(i).getId_mov()%>"
                           class="Botao1">Editar</a> <a
                           href="javascript: confirmar(<%=lista.get(i).getId_mov()%>)"
                           class="Botao2">Excluir</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
        <script src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#tabela').DataTable({
                    "language": {
                        "lengthMenu": "Mostrando _MENU_ registros por página",
                        "zeroRecords": "Nada encontrado",
                        "info": "Mostrando página _PAGE_ de _PAGES_",
                        "infoEmpty": "Nenhum registro encontrado",
                        "infoFiltered": "(filtrando de  _MAX_ registros no total)"
                    }
                });
            });
        </script>
        <script src="scripts/confirmador_mov.js"></script>
    </body>
</html>