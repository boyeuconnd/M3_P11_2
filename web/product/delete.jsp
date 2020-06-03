<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2020
  Time: 21:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
    <style>
        button{
            width: 70%;
            margin: 5px auto;
        }
        td{
            width: 100px;
            padding: 5px 5px;
        }
        a{
            text-decoration: none;
        }
        .messenger{
            color: green;
        }
        table,h1{
            margin: 10px auto;
            text-align: center;
            padding: 10px 20px;
        }
    </style>
</head>
<body>
    <h1>Delete Product</h1>
    <form method="post">
        <table style="border: 1px solid black">
            <tr>
                <th style="border-bottom: 1px solid black" colspan="2">Are you sure to delete!</th>
            </tr>
            <tr>
                <td style="text-align: center"><button  type="submit">Yes</button></td>
                <td style="text-align: center"><button><a href="/product">No</a></button></td>
            </tr>
        </table>
    </form>
</body>
</html>
