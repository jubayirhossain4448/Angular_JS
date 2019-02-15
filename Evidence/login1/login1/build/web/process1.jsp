<%-- 
    Document   : process1
    Created on : Dec 23, 2018, 5:12:39 PM
    Author     : l2pc214e
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${empty param.user or empty param.pass}">
            <c:redirect url="home.jsp">
                <c:param name="errM" value="User name or password is empty"></c:param>
            </c:redirect>
        </c:if>
        <c:if test="${not empty param.user and not empty param.pass}">
            <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="" user="" password=""></sql:setDataSource>
            
            <sql:query var="squary" dataSource="${ds}">
                select count (*) as aa from login where username="${param.user}" and password="${param.pass}"
            </sql:query>
            
            <c:forEach var="r" items="${squary.rows}">
                <c:choose>
                    <c:when>
                        <c:set></c:set>
                        <c:redirect></c:redirect>
                    </c:when>
                    <c:otherwise>
                        <c:redirect url="home.jsp">
                            <c:param name="errM" value="User name or password is empty"></c:param>
                        </c:redirect>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>   
    </body>
</html>
