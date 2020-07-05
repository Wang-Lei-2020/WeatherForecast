<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>登陆结果</h2>
<h1>${message }</h1>

<script type="text/javascript">
        var websocket = null;
 
        //判断当前浏览器是否支持WebSocket
        if ('WebSocket' in window) {
            //建立连接，这里的/websocket ，是Servlet中注解中的那个值
            //替换成自己的项目名
            websocket = new WebSocket("ws://localhost:8080/springmvc01/websocket");
        } else {
            alert('当前浏览器 Not support websocket');
        }
        //连接发生错误的回调方法
        websocket.onerror = function () {
            console.log("WebSocket连接发生错误");
        };
        //连接成功建立的回调方法
        websocket.onopen = function () {
            console.log("WebSocket连接成功");
        };
        //接收到消息的回调方法
        websocket.onmessage = function (event) {
            //可以在此处添加提示框和页面刷新
            alert("有新的信息: 第" + event.data + "条");
            console.log(event.data + "\n");
        };
        //连接关闭的回调方法
        websocket.onclose = function () {
            console.log("WebSocket连接关闭");
        };
        //监听窗口关闭事件，当窗口关闭时，主动去关闭WebSocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            closeWebSocket();
        };
 
        //关闭WebSocket连接
        function closeWebSocket() {
            websocket.close();
        }
    </script>
</body>
</html>