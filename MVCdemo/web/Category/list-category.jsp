<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link type="text/css" rel="stylesheet" href="css/headercss.css">
        <link type="text/css" rel="stylesheet" href="css/addstyle.css">
    </head>
    <body>   
        <%@ include file = "/header/header.jsp" %>
        <section id="container">
            <div id="content">
                <div class="table_title">Quản lý Thể loại</div>
                <table class="tableBodyScroll">
                    <thead>
                        <tr>
                            <th>Tên Loại Vật Tư</th>
                            <th>Cập Nhật</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tempCategory" items="${CATEGORY_LIST}">
                            <!-- set up a link for each category -->
                            <c:url var="tempLink" value="CategoryControllerServlet">
                                <c:param name="command" value="LOAD" />
                                <c:param name="categoryId" value="${tempCategory.id}" />
                            </c:url>

                            <c:url var="deleteLink" value="CategoryControllerServlet">
                                <c:param name="command" value="DELETE" />
                                <c:param name="categoryId" value="${tempCategory.id}" />
                            </c:url>
                            <tr>
                                <td> ${tempCategory.name} </td>
                                <td> 
                                    <a href="${tempLink}">Update</a> 
                                    | 
                                    <a href="${deleteLink}"
                                       onclick="if (!(confirm('Bạn có muốn xóa thể loại này không?')))
                                                   return false">
                                        Delete</a>	
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
                <div class="right"> 
                    <a class="button" href="CategoryControllerServlet?command=NEW">Thêm loại vật tư</a>
                </div>
            </div>
        </section>
        <%@include file="/footer/footer.jsp" %>
    </body>
</html>








