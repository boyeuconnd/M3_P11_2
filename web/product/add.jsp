<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2020
  Time: 16:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product to list</title>
    <style>
        .messenger{
            color:green;
            font-size: 15px;
        }
        div{
            text-align: center;
            width: 100%;
        }
        table{
            margin: 10px auto;
        }
    </style>
</head>
<body>
    <div>
        <h1>Add Product</h1>
        <p>
            <c:if test='${requestScope["messenger"] != null}'>
                <span class="messenger">${requestScope["messenger"]}</span>
            </c:if>
        </p>
        <form method="post">
            <fieldset>
                <legend>Product information</legend>
                <table>
                    <tr>
                        <td>ID: </td>
                        <td><input type="number" name="id" id="id"></td>
                    </tr>
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="name" id="name"></td>
                    </tr>
                    <tr>
                        <td>Color: </td>
                        <td><input type="text" name="color" id="color"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="ADD product">
                            <a href="/product">
                                <button type="button" value="Return to List" >Return to List</button>
                            </a>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>


    </div>

</body>
</html>
