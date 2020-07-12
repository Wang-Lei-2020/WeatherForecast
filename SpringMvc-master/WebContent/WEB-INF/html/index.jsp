<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th=http://www.thymeleaf.org>

<head>
<meta charset="utf-8" />
<title>主页</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/template-web.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<script type="text/javascript" src="js/article.js"></script>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="renderer" content="ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="js/echarts.min.js" ></script>

<style>
background:url(back.png) no-repeat center center;
	#charts{width:800px;height:600px;margin:0 auto;}
			*{margin: 0;padding: 0;color:#333333;}
			h3,h4,h5,h6{font-weight: normal;}
			.clear{clear:both;}
			body{font-family:"微软雅黑";}
			a{text-decoration: none;color: #333;}
			#charts{width:800px;height:600px;margin:0 auto;}
			.market_map_title{font-size:32px;text-align:left;padding-left:50px;}
.divlinebox{
  clear:both;
  margin-top:50px;
  margin-left:50px;
  padding-top:15px;
  padding-left:15px;
  width:450px;
  height:30px;
  color:#666;
  background-color: #E6EAE4;
  font: 400 12px/150% Tahoma, Helvetica, Arial, sans-serif; 
}
.divlinebox span{
  float:left;
  margin-right:5px;
}
.spanInput{
  float:left;
  border: 1px solid #a1a1a1; 
}
.txtInputboxSVR{
  height:14px;
  height:13px\9;
  BORDER:1px solid #ccc; 
  padding:0px 2px 1px 2px;
  padding-top:2px\9;
  padding-bottom:0px\9;
  text-align:center;
  FONT-SIZE:12px; 
  font-family:tahoma,arial,Verdana,Geneva,Arial,Helvetica,sans-serif;
  COLOR: #666666; 
}
/* IE9+ Chrome Firefox */
@media all and (min-width:0) {
  .txtInputboxSVR{
    padding-top:1px\9;
    padding-bottom:1px\9;
  }
}
/* Chrome 360极速 */
@media screen and (-webkit-min-device-pixel-ratio:0) {
  .txtInputboxSVR{
    height:13px;
    padding-top:0px;
    padding-bottom:2px;
  }
}
.w120{width:60px;}
 
.spanBtnSelect{
  float:left;
  width:24px;
  height:20px;
  background:url(btn-select.png) no-repeat 0 -2px;
  cursor:pointer;
}
.spanBtnSelect:hover{
  background:url(btn-select.png) no-repeat 0 -27px;
}
 
.txtInputbox {
  height:14px;
  BORDER:1px solid #ccc; 
  padding:0px 2px 1px 2px;
  text-align:center;
  FONT-SIZE:12px; 
  font-family:tahoma,arial,Verdana,Geneva,Arial,Helvetica,sans-serif;
  COLOR: #666666; 
}
 
.dnslist{
  float:left;
  position:absolute;
  overflow-y:scroll;
  overflow-x:hidden;
  width:150px;
  height:200px;
  BORDER:1px solid #a1a1a1; 
  background:#fffbf0;
  z-index:999;
  margin-top:19px;
  margin-left:82px;
}
 
.dnslist span.optionContent{
  width:100%;
  height:20px;
  BORDER-BOTTOM:1px solid #ccc; 
  padding:2px 3px 2px 3px;
  text-align:left;
  FONT-SIZE:12px; 
  font-family:tahoma,arial,Verdana,Geneva,Arial,Helvetica,sans-serif;
  COLOR: #666666; 
  cursor:pointer;
  overflow:hidden;
}
.dnslist span.optionContent:hover{
  background:#e7fafa;
  color:#0065b3;
}
.dnslist span.optionTop{
  width:100%;
  height:20px;
  BORDER-BOTTOM:1px solid #ccc; 
  padding:2px 3px 2px 3px;
  text-align:left;
  font-family:tahoma,arial,Verdana,Geneva,Arial,Helvetica,sans-serif;
  COLOR: #666666; 
  font-weight:bold;
  FONT-SIZE:13px; 
  font-style:oblique;
  background:#aaffff;
}
  .option-card {
            width: 100%;
            display: block;
        }

        .option-card>ul {
            display: block;
            width: 100%;
            height: 50px;
            list-style: none;
            border-bottom: solid 1px #a0a0a0;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .option-card>ul>li {
            display: inline-block;
            margin: 0;
        }

        .option-card>ul>li>a {
            display: block;
            text-decoration: none;
            color: #000;
            text-align: center;
            width: 100px;
            border: solid 1px #a0a0a0;
            border-bottom: none;
            margin: 0;
            line-height: 50px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            background-color: bisque;
        }

        .active-card {
            background-color: #fff !important;
        }

        .sub-page {
            display: none;
        }

        .show-page {
            display: block !important;
        }
.form-control {
	margin: 15px;
}

.input-group {
	width: 50%;
	margin-top: 15px;
}

.nav-pills {
	width: 150px;
	text-align: center;
	margin-left: 15px;
	margin-top: 50px;
}

.tab-content {
	margin-left: 20px;
	margin-top: 35px;
	width: 80%;
}

.navbar {
	width: 80%;
	margin: auto;
}
</style>
</head>
<body style="margin: 0; background:url(img/back.png);">
    <div class="option-card">
        <ul>
            <li>
                <a href="#" class="active-card card" onclick="clickCard(this,'page1')">用户管理</a>
            </li>
            <li>
                <a href="#" class="card" onclick="clickCard(this,'page2')">预测查询</a>
            </li>
        </ul>
        <div id="page1" class="sub-page show-page">
        
            <h1></h1>
            <div id="myTabContent" class="tab-content pull-right pull-left">
		<div class="tab-pane fade in active" id="home">
			<div id="user_content"></div>
		</div>
		<div class="tab-pane fade" id="article">
			<div id="article_content"></div>
		</div>
	</div>
	
	<!-- /.modal -->
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="deleteUser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">提示</h4>
				</div>
				<div class="modal-body">
					<h4 class="modal-title">要删除这个用户？</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						onclick="deleteUser()">提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="addUser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myUser">添加用户</h4>
				</div>
				<div class="modal-body">
					<div class="input-group" style="display: none;">
						<span class="input_tip">*id</span> <input id="id"
							class="form-control" placeholder="请输入用户名" />
					</div>
					<div class="input-group">
						<span class="input_tip">*用户名</span> <input id="username"
							class="form-control" placeholder="请输入用户名" />
					</div>
					<div class="input-group">
						<span class="input_tip">*密码</span> <input id="password"
							class="form-control" style="-webkit-text-security: disc"
							placeholder="请输入密码" />
					</div>
					<div class="input-group">
						<span class="input_tip" style="margin-top: 20px;">*部门</span> <input
							id="phone" type="tel" class="form-control" placeholder="请输入部门" />
					</div>
					<div class="input-group">
						<span class="input_tip">角色</span> <input id="email" type="email"
							class="form-control" placeholder="请输入角色" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						onclick="addorEditUser()">提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		
	<script>
		$(function() {
			$('#myTab li:eq(0) a').tab('show');
		});

		getUser();
	</script>
	<script id="user_list" type="text/html">
			<table class="table table-bordered">
				<caption>

				</caption>
				<thead>
					<tr>
						<th>序号</th>
						<th>用户名</th>
						<th>部门</th>
						<th>角色</th>
						<th>修改时间</th>
						<th><button class="btn btn-primary pull-right" data-toggle="modal" onclick="showAddDialog()">添加用户</button></th>
					</tr>
				</thead>
				<tbody>

					{{each $data}}
					<tr>
						<td>{{$index}}</td>
						<td>{{$value.username}}</td>
						<td>{{$value.phone}}</td>
						<td>{{$value.email}}</td>
						<td>{{$value.editTime}}</td>
						<td>
							<button type="button" class="btn btn-default" onclick="showEditDialog({{$value.userId}})">编辑</button>
							<button type="button" class="btn btn-default" onclick="showDeleteDialog({{$value.userId}})">删除</button>

						</td>
					</tr>
					{{/each}}

				</tbody>
			</table>

		</script>
		
	</div>
        </div>
        <div id="page2" class="sub-page">
            
<form action="login2.do">
   <div class="input-wrapper">
		<!--账号：<input type="text" name="userName"/><br/>-->
		<div class="border-wrapper">
                <input type="text" id= "flag" name="userName" placeholder="username" class="border-item" autocomplete="off" type="text" style="display:none" >
            </div>
             <div class="border-wrapper">
		<!-- 密码：<input type="password" name="userPw"/><br/> -->
		 <input type="password"  id="city" placeholder="password" class="border-item" autocomplete="off" name="userPw" type="text" style="display:none">
		
		</div>
	 <label style="float:left;" for="meeting">日期：</label><input style="float:left;" id="meeting" type="date" >	 	
	<div class="action">
            <input class="btn" type="submit" onclick = set() value="查看">
    </div>
	 </div>	 
   </form>
<h1  id = "mes" style="display:none">${message1 }</h1>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;float:right;"></div>
<body>
		<h3 class="market_map_title">全国地图</h3>
		<div id="charts"style="float:left;"></div>
</body>
	<script src="js/echarts-all.js"></script>

<h2 id = "store"></h2>
<h2 id = "stor"></h2>
	
<script type="text/javascript">
var x1
var x2
var arr
var x3 = document.getElementById("mes").innerText;
arr=x3.split(',');
alert(x3);
// 基于准备好的dom，初始化echarts实例
window.onload = function(){
	a();
	b();
}
function a(){
	var mycharts1 = echarts.init(document.getElementById('charts'))
	option1 = {
    dataRange: {
    	show:false,
        x: 'left',
        y: 'bottom',
        splitList: [
            {start: 5, end: 5, color: 'orange'},//当值为5时，区域背景
            {start: 10, end: 10, color: '#ff6300'},//当值为10时，区域背景
            {start: 15, end: 15, color: '#ccc'},//当值为15时，区域背景
        ],
    },
    series : [
        {
            name: '市场分布',
            type: 'map',
            mapType: 'china',
            //hoverable: false,
            roam: false,
            itemStyle:{
	                normal:{label:{show:true}},
	                emphasis:{label:{show:false}}
	            },
            data:[],
        }
    ],
    animation:false
   
};
var ini_data=[];//初始化省份数组
var provArr = ['北京', '云南', '辽宁', '黑龙江', '湖南', '安徽','山东','新疆','西藏','青海','甘肃','四川','宁夏','贵州','重庆','陕西','内蒙古','吉林','山西','河北','天津','河南','湖北','广西','广东','澳门','香港','江西','福建','台湾','浙江','江苏'];//获取的省份，有可能是从后台获取
//正则省份，将省与市的字眼去掉，框架不识别
for(var i=0;i<provArr.length;i++){
	var str = provArr[i];
	var re = /省|市/g;  //全局匹配
	var str2 ={name:str.replace(re,''),value: 5};//拼接对象数组
	ini_data.push(str2);
}
option1.series[0].data=ini_data;//将拼接好的数组赋给参数集合
mycharts1.setOption(option1);//跟新图表
//鼠标滑过事件
var testStr=','+provArr.join(",")+","; 
mycharts1.on('hover', function (param){
	if(testStr.indexOf(","+param.name+",")!=-1){
		return false;
	}else{
		param.value=15;
		mycharts.setOption(option1);
	}
});

//点击事件
mycharts1.on('click', function (params) {//点击事件
	select_province(params.name);
});
//初始化省颜色
function ini_province(){
	var ini_len=option1.series[0].data.length;
	for(var i=0;i<ini_len;i++){
		//初始化颜色
		option1.series[0].data[i].value=5;
		mycharts1.setOption(option1);
	}
	
}
//选中省颜色
function select_province(province_name){
	document.getElementById('flag').value=province_name;
	var len=option1.series[0].data.length;
	for(var i=0;i<len;i++){
		if(option1.series[0].data[i].name==province_name){//如果匹配正确
			//先归零
			ini_province();
			//改变颜色
			option1.series[0].data[i].value=10;
			mycharts1.setOption(option1);
		}
	}
}
}
function b(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
option = {
title: {
    text: '后七天温度预测'
},
tooltip: {
    trigger: 'axis'
},
legend: {
    data: ['最高温度', '最低温度']
},
grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
},
toolbox: {
    feature: {
        saveAsImage: {}
    }
},
xAxis: {
    type: 'category',
    boundaryGap: false,
    data: [arr[0],arr[1], arr[2], arr[3],arr[4], arr[5], arr[6]]
},
yAxis: {
    type: 'value'
},
series: [
    {
        name: '最高温度',
        type: 'line',
        stack: '总量',
        data: [Number(arr[7]), Number(arr[9]), Number(arr[11]),
        	Number(arr[13]), Number(arr[15]), Number(arr[17]), Number(arr[19])]
    },
    {
        name: '最低温度',
        type: 'line',
        
        data: [Number(arr[8]), Number(arr[10]), Number(arr[12]), 
        	Number(arr[14]), Number(arr[16]), Number(arr[18]), Number(arr[20])]
    }
]
};


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

}
function set(){
	x2 = document.getElementById("meeting").value; 
	alert("x2="+x2);
	document.getElementById('city').value = x2;
}
function showdnslist_onclick(){
  if(document.getElementById("divDnsList").style.display == "none"){
    document.getElementById("divDnsList").style.display = "";
  }
  else{
    document.getElementById("divDnsList").style.display = "none";
  }
}
function selectDns(id){
	x1 = document.getElementById(id).innerText; 
	alert("x1="+x1); 
	
	document.getElementById('flag').value = x1;
  document.getElementById("txtInputDnsName").value = document.getElementById(id).innerHTML;
  document.getElementById("divDnsList").style.display = "none";
}

</script>
        </div>
    </div>
</body>
<script type="text/javascript">
    function clickCard(e, id) {
        var arr = document.getElementsByClassName("card");
        for (var i = 0; i < arr.length; i++) {
            arr[i].classList.remove("active-card");
        }
        e.classList.add("active-card");

        var arr = document.getElementsByClassName("sub-page");
        for (var i = 0; i < arr.length; i++) {
            arr[i].classList.remove("show-page");
        }
        document.getElementById(id).classList.add("show-page");
    }
</script>


	<script id="article_list" type="text/html">

			<table class="table table-bordered">
				<caption>

				</caption>
				<thead>
					<tr>
						<th>序号</th>
						<th>标题</th>
						<th>链接</th>
						<th>阅读数</th>
						<th>评论数</th>
						<th>收藏数</th>
						<th>创建时间</th>
						<th>创建者</th>
						<th><button class="btn btn-primary pull-right" data-toggle="modal" onclick="showAddArticleDialog()">添加</button></th>
					</tr>
				</thead>
				<tbody>

					{{each $data}}
					<tr>
						<td>{{$index}}</td>
						<td>{{$value.title}}</td>
						<td>{{$value.link}}</td>
						<td>{{$value.readCount}}</td>
						<td>{{$value.commitCount}}</td>
						<td>{{$value.favoriteCount}}</td>
						<td>{{$value.createTime}}</td>
						<td>{{$value.username}}</td>
						<td>
							<button type="button" class="btn btn-default" onclick="showEditArticleDialog({{$value.articleId}})">编辑</button>
							<button type="button" class="btn btn-default" onclick="showDeleteArttcleDialog({{$value.articleId}})">删除</button>

						</td>
					</tr>
					{{/each}}

				</tbody>
			</table>

		</script>
</html>