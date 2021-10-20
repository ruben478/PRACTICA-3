<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL - LIBROS</title>
    </head>
    <body>
        <h1>
            <c:if test="${requestScope.op=='nuevo'}" var="res" scope="request">
                REGISTRO DE 
            </c:if>
            <c:if test="${requestScope.op=='modificar'}" var="res" scope="request">
                MODIFICAR
            </c:if>
                LIBRO
        </h1>
        <jsp:useBean id="miLibro" scope="request" class="com.emergentes.modelo.Libros"/>
            <form action="Controller"  method="post">
                <input type="hidden" name="id" value="<jsp:getProperty name="miLibro" property="id"/>">
                <table>
                    <tr>
                        <td>TITULO: </td>
                        <td><input type="text" name="titulo" value="<jsp:getProperty name="miLibro" property="titulo"/>"></td>
                    </tr>
                    <tr>
                        <td>AUTOR: </td>
                        <td><input type="text" name="autor" value="<jsp:getProperty name="miLibro" property="autor"/>"></td>
                    </tr>
                    <tr>
                        <td>RESUMEN: </td>
                        <td><input type="textarea" name="resumen" value="<jsp:getProperty name="miLibro" property="resumen"/>"></td>
                    </tr>
                    <tr>
                        <td>MEDIO:</td>
                        <td><input type="radio" name="medio" value="Fisico" <c:if test="${miLibro.medio=='Fisico'}" var="res" scope="request">checked</c:if>/>Fisico</td>
                        <td><input type="radio" name="medio" value="Magnetico" <c:if test="${miLibro.medio=='Magnetico'}" var="res" scope="request">checked</c:if>/>Magnetico</td>
                    </tr>   
                    <tr>
                        <td>
                            <input type="hidden" name="opg" value="${requestScope.op}"/>
                            <input type="hidden" name="op" value="grabar"/>
                        </td>
                        <td>
                            <input type="submit" value="Enviar"/>
                        </td>  
                    </tr>    
                        
                </table>
            </form>
    </body>
</html>
