# springmvc
springmvc的简单登陆Demo
spring MVC 步骤：
	1. 把所需jar拷贝到工程目录下WEB-INF/lib
	2. 配置WEB.xml，配置前端控制器
	org.springframework.web.servlet.DispatcherServlet
	  <servlet>
	  		<servlet-name>springmvc</servlet-name>
	  		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	  </servlet>
	  <servlet-mapping>
	  	<servlet-name>springmvc</servlet-name>
	  	<url-pattern>*.do</url-pattern>
	  </servlet-mapping>
	3.  创建spring mvc控制核心配置：springmvc-servlet.xml
		前端控制器（servlet的名称）的名称+“-servlet.xml”
		
		配置控制器
		<bean id="login" name="/login.do" class="com.beifeng.controller.LoginController"></bean>
		
		配置试图解析器
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<!-- 前缀 -->
			<property name="prefix" value="/jsp/"></property>
			<!-- 后缀 -->
			<property name="suffix" value=".jsp"></property>
		</bean>
	4.编写控制器类 LoginController 必须继承AbstractController 重写handleRequestInternal
	
	 返回数据和试图	ModelAndView mav = new ModelAndView("index");	
	
	5. 编写JSP页面 显示数据
  
  SpringMVC核心类与接口
  
  DispatcherServlet
   前端控制器（也称总控制器），把请求给转发到具体的控制类 
HandlerMapping
	映射处理器，负责映射中央处理器转发给controller时的映射策略，一共三种：
	1.BeanNameUrlHandlerMapping：按着controller的name来映射寻找 
	2.SimpleUrlHandlerMapping ：按着简单url来映射寻找 
	3. ControllerClassNameHandlerMapping：控制类的类名控制器，访问时类名首字母需要小写 
Controller
	具体处理请求的控制器 
ModelAndView
	服务层返回的数据和视图层的封装类 
ViewResolver
	视图解析器，解析具体的视图 
Interceptors
	拦截器，负责拦截我们定义的请求然后做处理工作 

  
  
