<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cập Nhất Nhà Sản Xuất</title>
        <link type="text/css" rel="stylesheet" href="css/headercss.css">
        <link type="text/css" rel="stylesheet" href="css/addstyle.css">
        <link type="text/css" rel="stylesheet" href="css/add-form.css">
    </head>
    <body>
        <%@ include file = "/header/header.jsp" %>
        <div id="container">
            <div id="content">
            <div class="table_title">Cập Nhất Nhà Sản Xuất</div>
            <form action="ProducerServletController" method="GET">
                <input type="hidden" name="command" value="UPDATE" />
                <input type="hidden" name="producerId" value="${the_Producer.id}" />
                <div class="add-form">
                    <div>
                        <label>Tên:</label>
                        <input type="text" name="name" value="${the_Producer.name}" />
                    </div>
                    <div>
                        <label>NTL:</label>
                        <input type="text" name="dob" value="${the_Producer.dobString}" />
                    </div>
                    <div class="right">
                        <input type="submit" value="Save" class="button" />
                    </div>
                </div>
                </tbody>
                </table>
            </form>
            <div style="clear: both;"></div>
            <div class="left">
                <a class="button left" href="ProducerServletController">Quay lại danh sách</a>
            </div>
            </div>
        </div>
        <%@include file="/footer/footer.jsp" %>
    </body>

</html>











