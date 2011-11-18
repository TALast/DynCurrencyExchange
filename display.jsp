<%-- 
    Document   : display
    Created on : Nov 10, 2011, 11:17:25 PM
    Author     : Tolis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" /> 
        <title>Result</title>
    </head>
    <body>
        <div class="content">
            <ul>
                <li><p><%=request.getParameter("amount1")%> <%=request.getParameter("inputCur")%> <strong>equals</strong> <%=request.getAttribute("result")%> <%=request.getParameter("outputCur")%></p>
                <li><p>1 <%=request.getParameter("inputCur")%> <strong>equals</strong> <%=request.getAttribute("valOf1")%> <%=request.getParameter("outputCur")%></p>
                <li><p>1 <%=request.getParameter("outputCur")%> <strong>equals</strong> <%=request.getAttribute("valFrom1")%> <%=request.getParameter("inputCur")%></p>
            </ul>
            <form>
                <label>&nbsp; </label>
                <input type="button" class="button" value="Back" onClick="parent.location='index.html'">
            </form>
        </div>
        <label class="copy">Apostolis Nastos</label>
    </body>
</html>
