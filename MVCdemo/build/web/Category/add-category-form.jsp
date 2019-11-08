

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Thêm loại vật tư</title>
        <link type="text/css" rel="stylesheet" href="css/headercss.css">
        <link type="text/css" rel="stylesheet" href="css/addstyle.css">
        <link type="text/css" rel="stylesheet" href="css/add-form.css">
    </head>

    <body>
        <%@ include file = "/header/header.jsp" %>
        <div id="container">
            <div id="content">
            <div class="table_title">Thêm loại vật tư</div>
            <form action="CategoryControllerServlet" method="GET">
                <input type="hidden" name="command" value="ADD" />
                <div class="add-form">
                    <div>
                        <label for="name">Tên loại vật tư:</label>
                        <input type="text" name="name" />
                    </div>
                    <div class="right">
                        <input class="button" type="submit" value="SAVE"/>
                    </div> 
                </div>
            </form>
            <div class="left">
                <a href="CategoryControllerServlet"> <div class="button">Quay lại danh sách</div></a>
            </div>
            </div>
        </div>
       <%@include file="/footer/footer.jsp" %>
    </body>

</html>











