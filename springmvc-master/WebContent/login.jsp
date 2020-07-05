<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"></bean>
<title>Insert title here</title>

<style>
	  	body {
            background: url('city.png') no-repeat;
            background-size: 100% auto;
        }
        * {
            margin: 0;
            padding: 0;
        }
        
        html {
            height: 100%;
        }
        
        body {
            height: 100%;
            font-family: JetBrains Mono Medium;
            display: flex;
            align-items: center;
            justify-content: center;
            /* background-color: #0e92b3; */
           
        }
        
        .form-wrapper {
            width: 300px;
            background-color: rgba(41, 45, 62, .8);
            color: #fff;
            border-radius: 2px;
            padding: 50px;
        }
        
        .form-wrapper .header {
            text-align: center;
            font-size: 35px;
            text-transform: uppercase;
            line-height: 100px;
        }
        
        .form-wrapper .input-wrapper input {
            background-color: rgb(41, 45, 62);
            border: 0;
            width: 100%;
            text-align: center;
            font-size: 15px;
            color: #fff;
            outline: none;
        }
        
        .form-wrapper .input-wrapper input::placeholder {
            text-transform: uppercase;
        }
        
        .form-wrapper .input-wrapper .border-wrapper {
            background-image: linear-gradient(to right, #e8198b, #0eb4dd);
            width: 100%;
            height: 50px;
            margin-bottom: 20px;
            border-radius: 30px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .form-wrapper .input-wrapper .border-wrapper .border-item {
            height: calc(100% - 4px);
            width: calc(100% - 4px);
            border-radius: 30px;
        }
        
        .form-wrapper .action {
            display: flex;
            justify-content: center;
        }
        
        .form-wrapper .action .btn {
            width: 60%;
            text-transform: uppercase;
            border: 2px solid #0e92b3;
            text-align: center;
            line-height: 50px;
            border-radius: 30px;
            cursor: pointer;
        }
        
        .form-wrapper .action .btn:hover {
            background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
        }
        
        .form-wrapper .icon-wrapper {
            text-align: center;
            width: 60%;
            margin: 0 auto;
            margin-top: 20px;
            border-top: 1px dashed rgb(146, 146, 146);
            padding: 20px;
        }
        
        .form-wrapper .icon-wrapper i {
            font-size: 20px;
            color: rgb(187, 187, 187);
            cursor: pointer;
            border: 1px solid #fff;
            padding: 5px;
            border-radius: 20px;
        }
        
        .form-wrapper .icon-wrapper i:hover {
            background-color: #0e92b3;
        }
    </style>
</head>
<body>
	<div class="form-wrapper">
        <div class="header">
            login
        </div>

	<form action="login.do">
	<div class="input-wrapper">
		<!--账号：<input type="text" name="userName"/><br/>-->
		<div class="border-wrapper">
                <input type="text" name="userName" placeholder="username" class="border-item" autocomplete="off" >
            </div>
             <div class="border-wrapper">
		<!-- 密码：<input type="password" name="userPw"/><br/> -->
		 <input type="password"  placeholder="password" class="border-item" autocomplete="off" name="userPw">
		
		</div>
	 </div>	 
	 <div class="action">
            <input class="btn" type="submit" value="登陆"/>
    </div>	
	</form>

</body>

</html>

