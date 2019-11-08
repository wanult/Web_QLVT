<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cập Nhật Vật Tư</title>
        <link type="text/css" rel="stylesheet" href="css/headercss.css">
        <link type="text/css" rel="stylesheet" href="css/addstyle.css">
        <link type="text/css" rel="stylesheet" href="css/add-form.css">
    </head>
    <body>
        <%@ include file = "/header/header.jsp" %>
        <div id="container">
            <div id="content">
            <div class="table_title">Cập Nhật Vật Tư</div>
            <form action="MaterialsControllerServlet" method="GET">
                <input type="hidden" name="command" value="UPDATE" /> 
                <input type="hidden" name="materialsId" value="${the_Materials.id}" />
                <div class="add-form">
                    <div>
                        <label>Tên:</label>
                        <input type="text" name="name"
                               value="${the_Materials.name}" />      
                    </div>
                    <div>
                        <label>Giá:</label>
                        <input type="text" name="price"
                               value="${the_Materials.price}" />
                    </div>               
                    <div>
                        <label>Thể Loại:</label>
                        <select name ="categoryName">
                            <option value="${the_Materials.category.id}" selected>${the_Materials.category.name}</option>
                            <c:forEach var="row" items="${category_List}">  
                                <c:if test="${row.id != the_Materials.category.id}"> 
                                    <option    value='<c:out value="${row.id}" />'>${row.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="left">
                        <input type="submit" value="Save" class="button" />
                    </div>
                </div>
            </form>
            <div class="left">
                <a href="MaterialsControllerServlet"><div class="button">Quay lại danh sách</div></a>
            </div>
            </div>
        </div>
        <%@include file="/footer/footer.jsp" %>
    </body>
</html>











