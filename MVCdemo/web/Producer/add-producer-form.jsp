<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Thêm Nhà Sản xuất</title>
        <link type="text/css" rel="stylesheet" href="css/headercss.css">
        <link type="text/css" rel="stylesheet" href="css/addstyle.css">
        <link type="text/css" rel="stylesheet" href="css/add-form.css">
    </head>
    <body>
        <%@ include file = "/header/header.jsp" %>
        <div id="container"> 
            <div id="content">
            <div class="table_title">Thêm Nhà Sản xuất</div>
            <form action="ProducerServletController" method="get">
                <input type="hidden" name="command" value="ADD" />
                <div class="add-form">
                    <div>
                        <label>Tên nhà sản xuất:</label>
                        <input type="text" name="nameProducer">
                    </div>
                    <div>
                        <label>Ngày thành lập:</label>
                        <input type="text" name="dobString">
                    </div>
                    <div class="right">
                        <input type="submit" value="Thêm NSX" class="button" />
                    </div>
                </div>
            </form>
            <div class="left">
                <a href=ProducerServletController><div class="button">Quay lại danh sách</div></a>
            </div>
            </div>
        </div>
        <%@include file="/footer/footer.jsp" %>
    </body>
</html>