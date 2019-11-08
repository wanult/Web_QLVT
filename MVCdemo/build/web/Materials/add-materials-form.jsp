<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Thêm Vật Tư</title>
        <link type="text/css" rel="stylesheet" href="css/headercss.css">
        <link type="text/css" rel="stylesheet" href="css/addstyle.css">
        <link type="text/css" rel="stylesheet" href="css/add-form.css">
    </head>
    <body>
        <%@ include file = "/header/header.jsp" %>
        <div id="container">
            <div id="content">
            <div class="table_title">Thêm Vật Tư</div>
            <form action="MaterialsControllerServlet" method="GET">
                <input type="hidden" name="command" value="ADD" />
                <div class="add-form">
                    <div>
                        <label>Tên Vật Tư:</label>
                        <input type="text" name="name" />
                    </div>
                    <div>
                        <label>Giá:</label>
                        <input type="text" name="price" />
                    </div>
                    <div>
                        <label>Thể loại:</label>
                        <select name ="categoryName">
                            <c:forEach var="row" items="${category_List}">  
                                <option    value='<c:out value="${row.id}" />'>${row.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <input type="submit" value="Save" class="button" />
                    </div>
                </div>
            </form>
            <div class="left">
                <a href="./MaterialsControllerServlet"><div class="button">Quay lại danh sách</div></a>
            </div>
            </div>
        </div>
        <%@include file="/footer/footer.jsp" %>
    </body>
</html>











