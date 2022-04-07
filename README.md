# SpringMVC
#SpringMVC执行原理
1. DispatcherServlet表示前置控制器，是整个SpringMVC的控制中心。用户发出请求，DispatcherServlet接收请求并且拦截请求。

   -  我们假设请求的url为：http://localhost:8080/SpringMVC/hello
   -  如上url拆成三部分：
   -  http://localhost:8080是服务器域名
   -  SpringMVC是部署在服务器上的站点
   -  hello表示控制器
   -  通过分析，如上url表示为：请求位于服务器localhost:8080上的SpringMVC站点的hello控制器

2. HandlerMapping为处理器映射。DispatcherServlet调用HandlerMapping,HandlerMapping根据请求url查找对应的Handler

3. HandlerExecution表示具体的Handler，如上url被查找控制器为：hello

4. HandlerExecution将解析后的信息传递给DispatcherServlet

5. HandlerAdapter表示处理器适配器，其按照特定的规则去执行Handler

6. Handler让具体的Controller执行

7. Controller将具体的执行信息返回给HandlerAdapter,如ModelAndView

8. HandlerAdapter将视图逻辑名或模型传递给DispatcherServlet 

9. DispatcherServlet调用视图解析器（ViewResolver）来解析HandlerAdapter传递的逻辑视图名。

   ```xml
   <!--视图解析器：DispatcherServlet给它的ModelAndView
       1: 获取了ModelAndView的数据
       2：解析了ModelAndView的视图名字
       3：拼接视图名字，找到对应的视图
       4：将数据渲染到这个视图上
       -->
       <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
           <!--前缀-->
           <property name="prefix" value="/WEB-INF/jsp/"/>
           <!--后缀-->
           <property name="suffix" value=".jsp"/>
       </bean>
   ```

   

10. 视图解析器将解析的逻辑视图名传给DispatcherServlet

11. DispatcherServlet根据视图解析器解析的视图结果，调用具体的视图

12. 最终视图呈现给用户

    

总结：也就是用户从前端浏览器输入一个url地址，DispatcherServlet接收所有的请求，接受完交给映射器去找对应的Handler,找到Handler之后返回给DispatcherServlet, 
把找到的Handler给适配器HandlerAdapter去匹配对应的Controller,找到Controller之把里面封装的对象，需要跳转的视图名字，以及调用的业务也就是ModelAndView返回给适配器HandlerAdapter,
再由HandlerAdapter交给DispatcherServlet。DispatcherServlet将得到的封装的对象，要跳转视图的名字，以及调用的业务交给视图解析器来处理。
视图解析器做的事情主要有获取ModelAndView的数据，并解析ModelAndView的视图名字，拼接视图的名字。
把拼接好的跳转视图名交给DispatcherServlet，最后DispatcherServlet来调用具体的jsp视图，将页面呈现给用户。
