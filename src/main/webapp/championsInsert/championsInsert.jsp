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
        <form action="/championsInsertList" method="post">
            <div class="form-group">insertar nuevo champ
                <br/>
                <br/>
                id: <input type="text" class="form-control" id="id" name="id">
                <br/>
                nombre: <input type="text" class="form-control" id="champion_name" name="name">
                <br/>
                titulo: <input type="text" class="form-control" id="title" name="title">
                <br/>
                lore: <input type="text" class="form-control" id="lore" name="lore">
                <br/>
                tags: <input type="text" class="form-control" id="tags" name="tags">
            </div>
            <input type="submit" value="insertar campeon"/>
        </form>
        <br/>
        <a href="/index.jsp">inicio</a>
        
    </body>
</html>