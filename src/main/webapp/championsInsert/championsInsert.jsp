<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>formulario nuevos campeones</title>
    </head>
    <body class="container">

        <table>
            <div>Nombre champ</div><input type="text" id="champion_name" name="champion_name"/>
            <br/>
            <div>title</div><input type="text" id="title" name="title"/>
            <br/>
            <div>lore</div><input type="text" id="lore" name="lore"/>
            <br/>
            <div>tags</div><input type="text" id="tags" name="tags"/>
            <br/>
            <input type="submit" value="enviar"/>
        </table>
        
        <a href="/index.jsp">inicio</a>
        
    </body>
</html>