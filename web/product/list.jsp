<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductList</title>
    <style>
        table{
            margin: 10px auto;
        }
        h1{
            text-align: center;
        }
        th,td{
            padding: 10px 20px;
        }
    </style>

</head>
<body>
<h1>ProductList</h1>
<%
    List myList = (List)request.getAttribute("productList");
%>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Color</th>
        <th>IMG</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="<%=myList%>" var="product">
        <tr>
            <td><c:out value="${product.getId()}"/> </td>
            <td><c:out value="${product.getName()}"/></td>
            <td><c:out value="${product.getColor()}"/></td>
            <td><img src="<c:out value="${product.getImgUrl()}"/>" alt="product<c:out value="${product.getId()}"/>"></td>
            <td><a href="product?action=edit&id=<c:out value="${product.getId()}"/>">Edit</a></td>
            <td><a href="product?action=delete&id=<c:out value="${product.getId()}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    <tr >
        <td style="text-align: center" colspan="6"><a href="/product?action=add"><button>Thêm Sản Phẩm</button></a></td>
    </tr>
</table>
</body>
</html>
