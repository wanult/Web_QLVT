<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Báo cáo Thể loại</title>
        <link type="text/css" rel="stylesheet" href="css/headercss.css">
        <link type="text/css" rel="stylesheet" href="css/addstyle.css">
    </head>
    <body>
        <%@ include file = "/header/header.jsp" %>
        <div id="container">
            <div id="content">
                <!-- put new button: Add BookStore -->
                <div class="table_title">Doanh Thu Thể Loại</div>
                <table class="tableBodyScroll">
                    <thead>
                        <tr>
                            <th>Tên Thể Loại</th>
                            <th>Doanh Thu</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tempCategory" items="${category_List}">
                            <tr>
                                <td> ${tempCategory.name} </td>
                                <td> ${tempCategory.revenue}</td>
                            </tr>
                        </c:forEach>
                    </tbody>   
                </table>
            </div>
        </div>
        <%@include file="/footer/footer.jsp" %>
    </body>
</html>
