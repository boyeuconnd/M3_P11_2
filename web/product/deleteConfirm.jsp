<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2020
  Time: 22:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteProducted</title>
    <style>
        .messenger{
            color: green;
        }
        a{
            text-decoration: none;
        }
        div,h1{
            width: 100%;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Product Deleted</h1>
    <div>
        <p>
            <c:if test="${requestScope['messenger'] != null}">
                <span class="messenger">${requestScope["messenger"]}</span>
            </c:if>
        </p>
        <button><a href="/product">Trở Lại</a></button>
    </div>

</body>
</html>
