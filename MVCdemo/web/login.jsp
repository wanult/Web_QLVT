<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" 
              integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    </head>
    <body>
        <div class="background">
            <div class="main">
                <form action="UserServletController" method="post">
                    <div class="imgcontainer">
                        <i class="far fa-user-circle"></i>
                    </div>

                    <div class="container">
                        <label for="uname"><b>Username</b></label>
                        <input type="text" placeholder="Enter Username" name="email" required autocomplete="off">

                        <label for="pass"><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" name="password" required>
                        <%String msg = (String) request.getAttribute("msg");
                            if (msg != null) {
                                out.print("<div class='Error_message'>"+msg+"</div>");
                            }%>
                        <button type="submit">Login</button>
                        <label>
                            <input type="checkbox" checked="checked" name="remember"> Remember me
                        </label>
                    </div>

                    <div class="container" style="background-color:#f1f1f1">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
