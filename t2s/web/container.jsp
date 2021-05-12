<%-- 
    Document   : container
    Created on : 11 de mai. de 2021, 21:44:34
    Author     : RodrigoLopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Container"%>
<%@page import="java.util.ArrayList"%>

<%
    ArrayList<Container> lista = (ArrayList<Container>) request.getAttribute("containeres");
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
            <a href="novoContainer.html" class="Botao1">Novo Container</a>
            <a href="report_cont" class="Botao2">Relatório</a>
            <a href="main_mov" class="Botao1">Movimentação</a>
        </div>
        <table align="center" id="tabela">
            <thead>
                <tr>
                    <th>Container</th>
                    <th>Cliente</th>
                    <th>Tipo</th>
                    <th>Status</th>
                    <th>Categoria</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < lista.size(); i++) {
                %>
                <tr>
                    <td><%=lista.get(i).getNum_container()%></td>
                    <td><%=lista.get(i).getCliente()%></td>
                    <td><%=lista.get(i).getTipo()%></td>
                    <td><%=lista.get(i).getStatus()%></td>
                    <td><%=lista.get(i).getCategoria()%></td>
                    <td><a href="select_cont?id_cont=<%=lista.get(i).getId_cont()%>"
                           class="Botao1">Editar</a> <a
                           href="javascript: confirmar(<%=lista.get(i).getId_cont()%>)"
                           class="Botao2">Excluir</a
                    </td>
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
        <script src="scripts/confirmador_cont.js"></script>
    </body>
</html>