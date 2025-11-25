<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f7fa;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .error-container {
            background: white;
            padding: 30px;
            width: 90%;
            max-width: 500px;
            text-align: center;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1 {
            color: #e74c3c;
            margin-top: 0;
            font-size: 28px;
        }
        .error-message {
            color: #2c3e50;
            font-size: 18px;
            margin: 20px 0;
            padding: 15px;
            background-color: #fdf2f2;
            border-left: 4px solid #e74c3c;
            text-align: left;
        }
        .btn-volver {
            margin-top: 20px;
        }
        .btn-volver button {
            background: #3498db;
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            transition: background 0.3s;
        }
        .btn-volver button:hover {
            background: #2980b9;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1>Error</h1>

    <c:choose>
        <c:when test="${not empty error}">
            <div class="error-message">
                <strong>Detalles:</strong><br>
                <c:out value="${error}" />
            </div>
        </c:when>
        <c:otherwise>
            <div class="error-message">
                Ha ocurrido un error inesperado. Por favor, inténtelo de nuevo más tarde.
            </div>
        </c:otherwise>
    </c:choose>

    <div class="btn-volver">
        <button type="button" onclick="window.history.back()">Volver</button>
    </div>
</div>
</body>
</html>