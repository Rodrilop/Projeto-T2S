<%-- 
    Document   : editarMovimentação
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
        <h1 align="center">Editar Movimentação</h1>
        <form name="frmMovimentacao" action="update_mov">
            <table align="center">
                <tr>
                    <td>
                        <label align="center" class="label">Container</label>
                        <input type="text" name="container" class="Caixa2" readonly
                               value="<%out.print(request.getAttribute("container"));%>">
                    </td>
                </tr>			
                <td>
                    <label align="center" class="label">Movimentação</label>
                    <select name="movimentacao" class="Caixa1">
                        <option value="<%out.print(request.getAttribute("movimentacao"));%>"><%out.print(request.getAttribute("movimentacao"));%></option>
                        <option value="Embarque">Embarque</option>
                        <option value="Descarga">Descarga</option>
                        <option value="Gate In">Gate In</option>
                        <option value="Gate out">Gate out</option>
                        <option value="Posicionamento Pilha">Posicionamento Pilha</option>
                        <option value="Pesagem">Pesagem</option>
                        <option value="Scanner">Scanner</option>
                    </select>
                </td>
                </tr>
                <tr>
                    <td>
                        <label align="center" class="label">Data e Hora do Início</label>
                        <input type="text" name="data_inicio" class="Caixa1"
                               value="<%out.print(request.getAttribute("data_inicio"));%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label align="center" class="label">Data e Hora do Final</label>
                        <input type="text" name="data_final" class="Caixa1"
                               value="<%out.print(request.getAttribute("data_final"));%>">
                    </td>
                </tr>
            </table>
            <div align="center">
                <input type="button" value="Salvar" class="Botao1" onclick="validar()">
            </div>
        </form>
        <script src="scripts/validador_mov.js"></script>
    </body>
</html>