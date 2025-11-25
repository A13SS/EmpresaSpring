<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Menú de Opciones</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f7fa;
        }
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 25px;
        }
        table {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            background: white;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        td {
            padding: 16px 20px;
            border: 1px solid black;
        }

        a {
            text-decoration: none;
            color: #2c3e50;
            font-weight: bold;
            display: block;
        }
        a:hover {
            color: #3498db;
        }
    </style>
</head>
<body>
<h1>MENU DE OPCIONES DE LA EMPRESA</h1>
<table border="1">
    <tr>
        <td><a href="front?opcion=listar"> Listar todo los empleados</a></td>
    </tr>
    <tr>
        <td><a href="front?opcion=buscarPorDni"> Buscar el salario de un empleado por su DNI</a></td>
    </tr>
    <tr>
        <td><a href="front?opcion=buscarEmpleado">Buscar empleado para editarlo</a></td>
    </tr>
</table>
</body>
</html>
