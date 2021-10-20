<%@page import="com.emergentes.modelo.GestorLibros"%>
<%@page import="com.emergentes.modelo.Libros"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    if (session.getAttribute("agenda")==null) {
            GestorLibros libaux = new GestorLibros();
            session.setAttribute("agenda", libaux);
        }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL - LIBROS</title>
    </head>
    <body>
        <h1>LISTA DE LOS LIBROS</h1>
        <a href="Controller?op=nuevo">Registrar Nuevo Libro</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>TITULO</th>
                <th>AUTOR</th>
                <th>RESUMEN</th>
                <th>MEDIO</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.agenda.getLista()}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>
                    <td>${item.resumen}</td>
                    <td>${item.medio}</td>
                    <td><a href="Controller?op=modificar&id=${item.id}">Modificar</a></td>
                    <td><a href="Controller?op=eliminar&id=${item.id}">Eliminar</a></td>  
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
