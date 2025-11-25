<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Editar Empleado</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f7fa; }
        h1 { color: #2c3e50; text-align: center; }
        .form-container {
            background: white;
            padding: 25px;
            max-width: 500px;
            margin: 0 auto;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            border-radius: 6px;
        }
        label { display: block; margin: 12px 0 5px; font-weight: bold; color: #34495e; }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background: #3498db;
            color: white;
            padding: 12px;
            border: none;
            width: 100%;
            cursor: pointer;
            font-size: 16px;
            border-radius: 4px;
        }
        input[type="submit"]:hover {
            background: #3498db;
        }
        .btn-volver {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
        .btn-volver button {
            background: #7f8c8d;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
        }
        .error { color: #e74c3c; margin-bottom: 15px; }
    </style>
</head>
<body>
<h1>EDITAR EMPLEADO</h1>

<div class="form-container">
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <form action="front" method="post">
        <input type="hidden" name="opcion" value="editar">
        <input type="hidden" name="dni" value="${empleado.dni}">

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${empleado.nombre}" required>

        <label for="sexo">Sexo (M/F):</label>
        <input type="text" id="sexo" name="sexo" value="${empleado.sexo}" maxlength="1" required>

        <label for="categoria">Categoría (1-10):</label>
        <input type="number" id="categoria" name="categoria" value="${empleado.categoria}" min="1" max="10" required>

        <label for="anyos">Años trabajados:</label>
        <input type="number" id="anyos" name="anyos" value="${empleado.anyos}" min="0" required>

        <input type="submit" value="Actualizar Empleado">
    </form>

    <div class="btn-volver">
        <button type="button" onclick="window.history.back()">Volver</button>
    </div>
</div>
</body>
</html>