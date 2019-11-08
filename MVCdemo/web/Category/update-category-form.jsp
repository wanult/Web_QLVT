
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Cập Nhật Thể Loại</title>

        <%
            //Thẻ <tbody> dùng để xác định những dòng nào thuộc "phần thân" của bảng.
            //Thẻ <tbody> phải được đặt bên trong phần tử <table> và đặt bên ngoài phần tử <tr>
            //Thẻ HTML <td> được sử dụng để xác định một dữ liệu ô hoặc dữ liệu bảng trong một bảng.
            //Thẻ HTML <tr> được sử dụng để xác định một hàng trong bảng.
            //Thẻ HTML <table> được sử dụng để định nghĩa một bảng. 
            //Thẻ table chứa các thẻ khác để định nghĩa cấu trúc của một bảng.
            //Thẻ HTML <select> được sử dụng trong một form để định nghĩa một danh sách lựa chọn.
            //<c:if>	Thi hành đoạn code khi thỏa mãn điều kiện
            //<c:out>	Gửi output cho JspWriter hiện hành
            //<c:param>	Xác định 1 tham số URL cho <c:import> hay <c:url>
            //<c:url>	Tạo 1 URL
        %>

    </head>

    <body>
        <%@ include file = "/header/header.jsp" %>

        <div id="container">
            <div id="content">
                <div class="table_title">Cập Nhật Thể Loại</div>
                <form  action="CategoryControllerServlet" method="GET">
                    <input type="hidden" name="command" value="UPDATE" /> 
                    <input type="hidden" name="categoryId" value="${the_Category.id}" />
                    <div class="add-form">
                        <div>
                            <label for="name">Tên:</label>
                            <input type="text" name="name"/>
                        </div>
                        <div class="right">
                            <input type="submit" value="Save" class="button right" />         
                        </div>
                    </div>

                </form>
                <div class="left">
                    <a href="CategoryControllerServlet"><div class="button">Quay lại danh sách</div></a>
                </div>
            </div>
        </div>
        <%@include file="/footer/footer.jsp" %>
    </body>
    <link type="text/css" rel="stylesheet" href="css/headercss.css">
    <link type="text/css" rel="stylesheet" href="css/addstyle.css">
    <link type="text/css" rel="stylesheet" href="css/add-form.css">
</html>











