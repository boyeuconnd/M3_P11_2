<%@ page import="MVC.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2020
  Time: 20:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <style>
        .messenger{
            color: green;
            font-size: 18px;
        }
    </style>
</head>
<body>
<h1>Edit product</h1>
<p>
    <c:if test='${requestScope["messenger"] != null}'>
    <span class="messenger">${requestScope["messenger"]}</span>
</c:if>
</p>
<%
    Product product = (Product) request.getAttribute("product");
%>
<form method="post" >
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="button" name="id" value="${requestScope["product"].getId()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Color: </td>
                <td><input type="text" name="color" id="color" value="${requestScope["product"].getColor()}"></td>
            </tr>
            <tr>
                <td>ImgUrl: </td>
                <td><input type="text" name="imgurl" id="imgurl" value="${requestScope["product"].getImgUrl()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product">
                    <a href="/product">
                        <button type="button" value="Return to List" >Return to List</button>
                    </a>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
