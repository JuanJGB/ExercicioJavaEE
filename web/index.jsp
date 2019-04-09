<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Gerenciamento de Clientes</title>
</head>
<body>

<a href="cadastro.jsp">Cadastrar Cliente</a>

<a href="index.jsp">Listar Clientes</a>


<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Lista de Clientes</h2></caption>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>RG</th>
            <th>CPF</th>

        </tr>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td><c:out value="${book.id}" /></td>
                <td><c:out value="${book.title}" /></td>
                <td><c:out value="${book.author}" /></td>
                <td><c:out value="${book.price}" /></td>
                <td>
                    <a href="/editar.jspt?id=<c:out value='${book.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
