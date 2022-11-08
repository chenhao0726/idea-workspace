jdbc: java database connectivity( java链接数据库的接口和类)
How?
1. 导入驱动包mysql-connector-java-5.1.47.jar
2.  贾:加 加载驱动 Class.forName("com.mysql.jdbc.Driver")
	琏 :连   获取数据库的链接Connection conn = DriverManager.getConnection(url,username,password)
	欲 :       预执行对象Statement st = conn.createStatement()
	执 :       执行sql   st.execute(sql);
	事 :	     提交事务 st.close() conn.close();
	
Junit4 测试
	