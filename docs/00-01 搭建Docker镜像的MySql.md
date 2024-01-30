# 00-01 搭建Docker镜像的MySql


```shell
docker pull mysql:8.3.0
docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:8.3.0
```

#### 创建数据库

```sql
CREATE TABLE words (
    id INT AUTO_INCREMENT PRIMARY KEY,
    word VARCHAR(50) NOT NULL,
    chinese VARCHAR(50) NOT NULL
);

INSERT INTO words (word, chinese)
VALUES
    ('technology', '技术'),
    ('architecture', '架构'),
    ('parameter', '参数'),
    ('synchronize', '同步'),
    ('coupling', '耦合'),
    ('compile', '编译'),
    ('variable', '变量');
```

