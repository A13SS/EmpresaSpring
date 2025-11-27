<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Busca empleados por DNI</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f7fa; }
        h1 { color: #2c3e50; text-align: center; }
        h3 { color: #2c3e50; text-align: center; }
        p{color: #3498db; text-align: center;}
        #error{
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>BUSCAR EMPLEADO POR DNI</h1>
    <form action="front" method="post">
        <label for="dni" id="esDni">DNI del empleado:</label>
        <input type="text" id="dni" name="dni" required>
        <input type="hidden" name="opcion" value="buscarSalario">
        <input type="submit" value="Buscar Salario">
    </form>

    <hr>

    <c:if test="${not empty nombre}">
        <h3>Empleado:</h3>
        <p><strong>Nombre:</strong> <c:out value="${nombre}" /></p>
        <p><strong>DNI:</strong> <c:out value="${dni}" /></p>
        <p><strong>Salario:</strong> <c:out value="${sueldo_calculado}" /> $</p>
    </c:if>

    <c:if test="${not empty error}">
        <p id="error"><c:out value="${error}" /></p>
    </c:if>

    <br>

    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/'">Volver al menú Principal</button>

</div>
</body>
</html>