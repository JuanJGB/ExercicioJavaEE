<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edição de dados</title>
</head>
<body>

<form name="formulario" method="post" action="editar.jsp">

    Nome: <input type="text" name="nome_cliente" size="50" maxlength="50">
    <br><br>

    RG: <input type="text" name="rg_cliente" size="10" maxlength="10">
    <br><br>

    CPF: <input type="text" name="cpf_cliente" size="20" maxlength="20">
    <br><br>

    <input type="submit" value="Salvar">
</form>

</body>
</html>
