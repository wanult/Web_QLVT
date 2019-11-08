<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
//khai báo một JavaBean để sử dụng trong một JSP
//Bean này trở thành một biến scripting mà có thể truy cập được
%>
<jsp:useBean id="user"  scope="session" class="com.tuki.core.User"/> 

<%if (user.getName() == null) {
        String msg = "Bạn Phải Đăng Nhập";
        request.setAttribute("msg", msg);
        String redirectURL = "../login.jsp";
        response.sendRedirect(redirectURL);
    }%>  
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<div id="wrapper">
    <div id="header">
        <div class="header-left">
            <div>QUẢN LÝ VẬT TƯ</div>
        </div>
        <div class="header-right">
            <div class="menu_item"> 
                <div class="icon"><i class="fas fa-user-tie"></i></div><%=user.getName()%>
            </div>
            <div class="menu_item">
                <a href="MaterialsStoreControllerServlet">HOME</a>
            </div>
            <div class="menu_item">
                <div>QUẢN LÝ</div> 
                <div class="sub_menu">
                    <a href="CategoryControllerServlet"> <div class="sub_menu_item">Quản Lý Thể Loại</div></a>
                    <a href="ProducerServletController"><div class="sub_menu_item">Quản Lý NSX</div> </a>
                    <a href="MaterialsControllerServlet"><div class="sub_menu_item">Quản Lý Vật Tư</div></a>
                </div>
            </div>    
            <div class="menu_item">
                <div>BÁO CÁO</div>
                <div class="sub_menu">
                    <a href="MaterialsStoreControllerServlet?command=TOP_CATEGORY_REVENUE"><div class="sub_menu_item">Top Thể Loại</div></a>
                    <a href="MaterialsStoreControllerServlet?command=TOP_PRODUCER_REVENUE"><div class="sub_menu_item">Top NSX</div></a>
                </div>
            </div>
            <a href="UserServletController?command=LOGOUT">
                <div class="menu_item">ĐĂNG XUẤT</div>
            </a>
        </div>
    </div>