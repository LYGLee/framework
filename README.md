# 搭建web项目
1.*在main目录下，添加webapp目录*  
2.*在webapp目录下，添加WEB-INF目录*  
3.*在WEB-INF目录下，添加web.xml文件*

#关于maven
1.maven “三坐标” （groupId,artifactId,version）必须提供  
2.某些依赖只需参与编译 scope设置为provided  
3.某些依赖只是运行时需要，无需参与编译，scope设置为runtime  
4.对于maven目录结构而言，classpath指的是java与resources这两个根目录
当运行单元测试时，遵循"就近原则"，优先从test/java、test/resources加载类或读取文件

# 编写视图层
推荐将JSP放到WEB-INF内部，而并非外部，因为用户无法通过浏览器地址栏直接请求放在内部的jsp,必须通过Servlet程序转发(forward) 或者重定向（redirect）


#关于工具类
使用final修饰，为使类不可再被继承修改,私有化构造器防止被实例化

#关于单元测试
JUnit在调用每个@Test方法前，都会调用@Before方法

#构造器，构造代码块，静态代码块的执行顺序
1、无继承关系的初始化顺序：
静态成员变量（静态代码块，且只执行一次）---> 普通成员变量（普通代码块）---> 构造器
2、有继承关系的初始化顺序：
父类静态成员变量（静态代码块，且只执行一次）---> 
子类静态成员变量（静态代码块，且只执行一次）--->
父类普通成员变量（普通代码块）---> 父类构造器 --->
子类普通成员变量（普通代码块）---> 子类构造器

# 关于注解
jdk1.5版本内置了三种标准的注解:  
@Override，表示当前的方法定义将覆盖超类中的方法。  
@Deprecated，使用了注解为它的元素编译器将发出警告，因为注解@Deprecated是不赞成使用的代码，被弃用的代码。  
@SuppressWarnings,关闭不当编辑器警告信息。 
 
Java还提供了4中注解，专门负责新注解的创建:  
1.@Target 表示该注解可以用于什么地方，可能的ElementType参数有：  

|    参数名称    |     含义      |
|:--------------:|:-------------:|
|CONSTRUCTOR     |   构造器的声明| 
|FIELD           |   域声明（包括enum实例）|
|LOCAL_VARIABLE  |   局部变量声明|
|METHOD          |   方法声明|
|PACKAGE         |   包声明|
|PARAMETER       |   参数声明|
|TYPE            |   类、接口（包括注解类型）或enum声明|  
2.@Retention
表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：

|    参数名称    |     含义      |
|:--------------:|:-------------:|
|SOURCE     |   注解将被编译器丢弃| 
|CLASS           |   注解在class文件中可用，但会被VM丢弃|
|RUNTIME  |   VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息|
3.@Document 将注解包含在Javadoc中  
4.@Inherited 允许子类继承父类中的注解


#自定义框架
1、定义框架配置项  
2、创建ConfigHelper助手类加载配置项  
3、开发一个类加载器加载基础包名下的所有类，使用ClassUtil实现  
4、定义注解，并实现Bean容器  
5、通过注解及反射实现依赖注入功能  
6、加载Controller类中定义的请求与执行方法的映射关系  
7、初始化框架（以上定义的一些类的初始化的统一封装）  
8、请求转发，定义DispatchServlet，调用7中初始化的类，  
获取ServletContext注册servlet（如处理jsp的和处理静态资源的），  
从HttpServletRequest中获取参数，URL，通过反射执行对于的Controller方法返回View对象跳转JSP页面或者Json对象。

