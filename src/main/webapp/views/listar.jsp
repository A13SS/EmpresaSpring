<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lista de Empleados</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f7fa; }
        h1 { color: #2c3e50; text-align: center; }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            background: white;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #e0e0e0;
        }
        th {
            background-color: #3498db;
            color: white;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Lista de Empleados</h1>

    <table>
        <thead>
        <tr>
            <th>Nombre</th>
            <th>DNI</th>
            <th>Sexo</th>
            <th>Categoría</th>
            <th>Años</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${lista}">
            <tr>
                <td><c:out value="${ emp.nombre}"></c:out></td>
                <td><c:out value="${ emp.dni}"></c:out></td>
                <td><c:out value="${ emp.sexo}"></c:out></td>
                <td><c:out value="${ emp.categoria}"></c:out></td>
                <td><c:out value="${ emp.anyos}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/index.jsp'">Volver al menú Principal</button>
</div>
</body>
</html>