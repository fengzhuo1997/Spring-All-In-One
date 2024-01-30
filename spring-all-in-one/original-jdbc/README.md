# 原始的JDBC

## 问题1

要求：
1. 使用Java的JDBC实现 单表的crud。
2. 除了MySql Driver以外，不使用其他jar。
3. 实现分页效果 `http://localhost:8080/api/quote?page=1&size=2`


## 知识点

**读取resource路径下文件**

1. InputStream is = this.getClass().getResourceAsStream(fileName);  //拿不到资源
2. InputStream is = this.getClass().getResourceAsStream("/" + fileName); // 拿到资源
3. InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName); //拿到资源