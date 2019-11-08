<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link type="text/css" rel="stylesheet" href="css/headercss.css">
        <link type="text/css" rel="stylesheet" href="css/addstyle.css">
    </head>
    <body>
        <%@ include file = "/header/header.jsp" %>
        <div id="container">
            <div id="content">   
                <div class="table_title">Quản lý Nhà sản xuất</div>
                <table class="tableBodyScroll">
                    <thead>
                        <tr>
                            <th>Tên nhà sản xuất</th>
                            <th>Ngày TL</th>
                            <th>Cập Nhật</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tempProducer" items="${PRODUCER_LIST}">
                            <!-- set up a link for each student -->
                            <c:url var="tempLink" value="ProducerServletController">
                                <c:param name="command" value="LOAD" />
                                <c:param name="producerId" value="${tempProducer.id}" />
                            </c:url>
                            <c:url var="deleteLink" value="ProducerServletController">
                                <c:param name="command" value="DELETE" />
                                <c:param name="producerId" value="${tempProducer.id}" />
                            </c:url>
                            <tr>
                                <td> ${tempProducer.name} </td>
                                <td> ${tempProducer.dobString} </td>
                                <td> 
                                    <a href="${tempLink}">Update</a> 
                                    | 
                                    <a href="${deleteLink}"
                                       onclick="if (!(confirm('Bạn có muốn xóa nhà sản xuất này không?')))
                                                   return false">
                                        Delete</a>	
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="right">
                    <a  class="button" href="ProducerServletController?command=NEW">Thêm Nhà Sản Xuất</a>
                </div>
            </div>
        </div>
        <%@include file="/footer/footer.jsp" %>
    </body>
</html>








