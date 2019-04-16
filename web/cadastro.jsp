<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="br.com.satc.ClienteDao, br.com.satc.ClienteController" %>
<%@ page import="br.com.satc.objetos.Cliente" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.satc.ConnectionFactory" %>
<html>
  <head>
    <title>Cadastro de dados</title>
  </head>
  <body>


  <form name="formulario" method="post" action="cadastrar.jsp">

    Nome: <input type="text" name="nome_cliente" size="50" maxlength="50">
    <br><br>

    RG: <input type="text" name="rg_cliente" size="10" maxlength="10">
    <br><br>

    CPF: <input type="text" name="cpf_cliente" size="20" maxlength="20">
    <br><br>

    <input type="submit" value="Cadastrar">
  </form>

  </body>
</html>