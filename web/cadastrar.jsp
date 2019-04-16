<%@ page import="br.com.satc.ClienteDao" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.satc.ConnectionFactory" %>
<%@ page import="br.com.satc.objetos.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: juan.159417
  Date: 16/04/2019
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String nome, rg, cpf;
    Connection con = new ConnectionFactory().geConnection();
    System.out.println("Conectou!");
    ClienteDao clienteDao = new ClienteDao();
    nome = request.getParameter("nome_cliente");
    rg = request.getParameter("rg_cliente");
    cpf = request.getParameter("cpf_cliente");

    Cliente cliente = new Cliente(nome, rg, cpf);
    cliente.setNome(nome);
    cliente.setRg(rg);
    cliente.setCpf(cpf);
    clienteDao.cadastrar(cliente);

    response.sendRedirect("index.jsp");

%>

</body>
</html>
