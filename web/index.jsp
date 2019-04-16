<%@ page import="br.com.satc.ClienteDao" %>
<%@ page import="br.com.satc.objetos.Cliente" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.satc.ConnectionFactory" %>
<%@ page import="java.sql.SQLException" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Gerenciamento de Clientes</title>
</head>
<body>

<a href="cadastro.jsp">Cadastrar Cliente</a>

<a href="index.jsp">Listar Clientes</a>
<a  href="edicao.jsp">Editar</a>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Clientes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>RG</th>
                <th>CPF</th>

            </tr>

                <tr>
                    <td><c:out value=""/></td>
                    <td><c:out value=""/></td>
                    <td><c:out value="<"/></td>
                    <td><c:out value=""/></td>
                    <td>

                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a >Delete</a>
                    </td>
                </tr>

            <%
       %>
    </table>
</div>
</body>
</html>
