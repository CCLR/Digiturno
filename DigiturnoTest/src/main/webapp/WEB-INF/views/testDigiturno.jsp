<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>TestDigiturno</h1>
        
        <c:forEach var="mensaje" items="${mensajes}">
            ${mensaje.titulo}:<hr>${mensaje.mensaje}
            
       </c:forEach>
    </body>
</html>
