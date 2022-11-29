<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Listado campeones</title>
    </head>
    <body>
        <h1>Listado campeones</h1>
        <form action="/championsList" method="post">
            <a href="../index.jsp">Menu principal</a>
            <br/><br/>
            <input type="submit" value="mostrar listado de campeones"/>
        </form>

        <table>
            <tr>
                <td>id</td>
                <td>champion_name</td>
                <td>title</td>
                <!-- <td>lore</td>-->
                <td>tags</td>
            </tr>
            <c:forEach items="${champions}" var="c">
                <tr>
                    <td>${c.getId()}</td>
                    <td>${c.getChampion_name()}</td>
                    <td>${c.getTitle()}</td>
                    <!--<td>${c.getLore()}</td>-->
                    <td>${c.getTags()}</td>
                    <td>
                        <a href="/eliminarItem?id=${c.id}">Eliminar</a>
                        <!-- <a href="/eliminarItem?id=${item.id}">Eliminar</a> -->
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>