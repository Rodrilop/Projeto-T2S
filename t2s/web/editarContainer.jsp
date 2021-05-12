<%-- 
    Document   : editarContainer
    Created on : 11 de mai. de 2021, 21:44:34
    Author     : RodrigoLopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto T2S</title>
        <link rel="icon" href="imagens/TruckYellow.png">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1 align="center">Editar Container</h1>
        <form name="frmContainer" action="update_cont">
            <table align="center">
                <tr>
                    <td>
                        <label align="center" class="label">Container</label>
                        <input type="text" name="num_container" class="Caixa1"
                               value="<%out.print(request.getAttribute("num_container"));%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label align="center" class="label">Cliente</label>
                        <input type="text" name="cliente" class="Caixa1"
                               value="<%out.print(request.getAttribute("cliente"));%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label align="center" class="label">Tipo</label>
                        <select name="tipo" class="Caixa1">
                            <option value="<%out.print(request.getAttribute("tipo"));%>"><%out.print(request.getAttribute("tipo"));%></option>
                            <option value="20">20</option>
                            <option value="40">40</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label align="center" class="label">Status</label>
                        <select name="status" class="Caixa1">
                            <option value="<%out.print(request.getAttribute("status"));%>"><%out.print(request.getAttribute("status"));%></option>
                            <option value="Cheio">Cheio</option>
                            <option value="Vazio">Vazio</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label align="center" class="label">Categoria</label>
                        <select name="categoria" class="Caixa1">
                            <option value="<%out.print(request.getAttribute("categoria"));%>"><%out.print(request.getAttribute("categoria"));%></option>
                            <option value="Importação">Importação</option>
                            <option value="Exportação">Exportação</option>
                        </select>
                    </td>
                </tr>
            </table>
            <div align="center">
                <input type="button" value="Salvar" class="Botao1" onclick="validar()">
            </div>
        </form>
        <script src="scripts/validador_cont.js"></script>
    </body>
</html>