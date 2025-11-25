<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Busca empleados por cualquiera de sus elementos</title>

    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f7fa; }
        h1 { color: #2c3e50; text-align: center; }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background: white;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 10px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        form {
            background: white;
            padding: 20px;
            max-width: 500px;
            margin: 0 auto 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        label { display: block; margin: 10px 0 5px; }
        select, input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background: #3498db;
            color: white;
            padding: 10px;
            border: none;
            width: 100%;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>BUSCAR EMPLEADO POR CUALQUIERA DE SUS ELEMENTOS</h1>
<form action="front" method="post">
    <input type="hidden" name="opcion" value="buscarEmpleado">
    <label for="campo">Campo de búsqueda:</label>
    <select name="campo" id="campo" required>
        <option value="">-- Seleccionar --</option>
        <option value="dni">DNI</option>
        <option value="nombre">Nombre</option>
        <option value="sexo">Sexo</option>
        <option value="categoria">Categoría</option>
        <option value="anyos">Años trabajados</option>
    </select><br><br>

    <label for="valor">Valor:</label>
    <input type="text" name="valor" id="valor" required><br><br>

    <input type="submit" value="Buscar">
</form>
<c:if test="${not empty resultados}">
    <h2>Resultados de la búsqueda:</h2>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>DNI</th>
            <th>Sexo</th>
            <th>Categoría</th>
            <th>Años</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="emp" items="${resultados}">
            <tr>
                <td><c:out value="${emp.nombre}" /></td>
                <td><c:out value="${emp.dni}" /></td>
                <td><c:out value="${emp.sexo}" /></td>
                <td><c:out value="${emp.categoria}" /></td>
                <td><c:out value="${emp.anyos}" /></td>
                <td>
                    <a href="front?opcion=editar&dni=<c:out value="${emp.dni}" />">Editar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${not empty error}">
    <p style="color: red;"><c:out value="${error}" /></p>
</c:if>

<br>

<button type="button" onclick="window.location.href='${pageContext.request.contextPath}/index.jsp'">Volver al menú Principal</button>

</body>
</html>
