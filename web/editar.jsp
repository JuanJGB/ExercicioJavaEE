<%@ page import="br.com.satc.objetos.Cliente" %>
<%@ page import="br.com.satc.ConnectionFactory" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.satc.ClienteDao" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edição de dados</title>
</head>
<body>
<%
    String nome, rg, cpf;
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
    response.sendRedirect("index.jsp");
    clienteDao.updateCliente(cliente);

%>

</body>
</html>
