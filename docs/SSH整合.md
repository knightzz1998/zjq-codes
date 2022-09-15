# Spring4 + SpringMVC + Hiberate4 整合



## 参考文章







## 项目搭建



### 创建WebApp项目





<img src="https://haloos.oss-cn-beijing.aliyuncs.com/typero/image-20220915153319464.png" alt="image-20220915153319464" style="zoom: 33%;" />



Archetype 是 Maven的模板, 选择 `org.apache.maven.archetypes:maven-archetype-webapp`



创建好的 maven 项目是下面这样

![image-20220915153453109](https://haloos.oss-cn-beijing.aliyuncs.com/typero/image-20220915153453109.png)



### 添加相关依赖 



Spring 和 Hibernate 的版本 : 

- spring.version : 4.3.9.RELEASE
- hibernate.version : 4.3.11.Final



特别注意 : Spring5 和 Hibernate5 很多地方和4是不一样的, 这里要注意的



依赖版本 : 



| 依赖名                     | 版本             | 适用范围 | 备注                                            |
| -------------------------- | ---------------- | -------- | ----------------------------------------------- |
| junit                      | 4.13.2           | test     |                                                 |
| spring-test                | 4.3.9.RELEASE    | -        |                                                 |
| **hibernate-core**         | 4.3.11.Final     | -        | Hibernate核心依赖                               |
| **spring-context**         |                  |          |                                                 |
| **spring-context-support** |                  |          |                                                 |
| spring-core                |                  |          |                                                 |
| spring-tx                  |                  |          |                                                 |
| spring-beans               |                  |          |                                                 |
| spring-aop                 |                  |          |                                                 |
| **spring-orm**             |                  |          | SpringORM框架依赖                               |
| **mysql-connector-java**   | 8.0.13           |          | 根据自己的版本来, 如果是MySQL5, 就使用5.x版本的 |
| druid                      | 1.2.13-SNSAPSHOT |          | 阿里巴巴数据库连接池依赖                        |
|                            |                  |          |                                                 |
|                            |                  |          |                                                 |





xml配置  : 



```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.knightzz</groupId>
    <artifactId>mini-spring-hibernate</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <spring.version>4.3.9.RELEASE</spring.version>
        <!--Hibernate版本号-->
        <hibernate.version>4.3.11.Final</hibernate.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>4.3.9.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>${hibernate.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- 根据自己的数据库版本设置-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.13</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.13-SNSAPSHOT</version>
        </dependency>

    </dependencies>
</project>
```







### 添加相关配置



<img src="https://haloos.oss-cn-beijing.aliyuncs.com/typero/image-20220915154330401.png" alt="image-20220915154330401" style="zoom:50%;" />



整合Spring+Hibernate : 注意和 SpringMVC是和这俩没关系的, 为了防止把自己搞混, 先配置这两个

- db.properties : 数据库连接以及数据库
- applicationContext.xml : Spring相关的



#### db.properties



```properties
################### JDBC Configuration ##########################
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssh_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
jdbc.username=root
jdbc.password=123456
################### Hibernate Configuration ##########################
#Hibernate方言配置
hibernate.dialect=org.hibernate.dialect.MySQLDialect
#是否显示SQL语句
hibernate.show_sql=true
#是否自动更新表格
hibernate.hbm2ddl.auto=update
#Hibernate缓存统计策略配置
hibernate.generate_statistics=false
#是否使用格式化SQL语句
hibernate.format_sql=false
#在格式化的SQL语句的基础之上加强可读性
hibernate.use_sql_comments=false
################### 以下是Hibernate的c3p0配置 ##########################
#最大连接数
hibernate.c3p0.max_size=20
#最小连接数
hibernate.c3p0.min_size=5
#获得连接的超时时间,如果超过这个时间,会抛出异常，单位毫秒
hibernate.c3p0.timeout=120
#最大的PreparedStatement的数量
hibernate.c3p0.max_statements=100
#每隔120秒检查连接池里的空闲连接 ，单位是秒
hibernate.c3p0.idle_test_period=120
#当连接池里面的连接用完的时候，C3P0一下获取的新的连接数
hibernate.c3p0.acquire_increment=2
# 每次都验证连接是否可用
hibernate.c3p0.validate=true
```





#### applicationContext.xml



这个配置部分我主要分为三个部分 : 

- spring注解扫描的配置, 主要是扫描相关包下的spring注解, 通过注解而不是xml的方式进行自动注入, 不然我们就需要配置大量的bean
- Hibernate 与 MySQL相关的配置, 主要是db.properties的位置, 以及 SessionFactory 的注入, 这个我们必须使用 xml的方式进行注入
- Hibernate事务的配置



首先是第一部分 :

```xml
  <!-- Spring用来扫描注解的 -->
    <context:component-scan base-package="cn.knightzz"/>
```

用于扫描`spring`的注解, 比如 `@Component` , `@Service` 这样的注解



----





然后是第二部分, **Hibernate核心配置** : 

- 数据源的配置 
- SessionFactory的配置



首先是**数据源** : 

```xml
	<!-- 导入资源文件 -->
    <context:property-placeholder location="classpath:db.properties"/>
    <!--数据源配置-->
    <bean id="dataSource"
          class="org.springframework.jdbc.datasource.DriverManagerDataSource"
          p:driverClassName="${jdbc.driverClassName}"
          p:url="${jdbc.url}"
          p:username="${jdbc.username}"
          p:password="${jdbc.password}">
    </bean>
```

第一个是用来加载配置文件的, 这样就可以使用 `${jdbc.username}` 来获取配置文件



其次是SessionFactory : 

```xml
   <!--SessionFactory配置-->
    <bean id="sessionFactory"
          class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="hibernateProperties">
            <props>
                <!--以下是Hibernate的基础配置-->
                <!--是否自动更新表格-->
                <prop key="hibernate.hbm2ddl.auto">${hibernate.hbm2ddl.auto}</prop>
                <!--Hibernate方言配置-->
                <prop key="hibernate.dialect">${hibernate.dialect}</prop>
                <!--是否显示SQL语句-->
                <prop key="hibernate.show_sql">${hibernate.show_sql}</prop>
                <!--是否使用格式化SQL语句-->
                <prop key="hibernate.format_sql">${hibernate.format_sql}</prop>
                <!--在格式化的SQL语句的基础之上加强可读性-->
                <prop key="hibernate.use_sql_comments">${hibernate.use_sql_comments}</prop>
                <!--Hibernate缓存统计策略配置-->
                <prop key="hibernate.generate_statistics">${hibernate.generate_statistics}</prop>

                <!--以下是Hibernate的c3p0配置-->
                <!-- 最大连接数 -->
                <prop key="hibernate.c3p0.max_size">${hibernate.c3p0.max_size}</prop>
                <!-- 最小连接数 -->
                <prop key="hibernate.c3p0.min_size">${hibernate.c3p0.min_size}</prop>
                <!-- 获得连接的超时时间,如果超过这个时间,会抛出异常，单位毫秒 -->
                <prop key="hibernate.c3p0.timeout">${hibernate.c3p0.timeout}</prop>
                <!-- 最大的PreparedStatement的数量 -->
                <prop key="hibernate.c3p0.max_statements">${hibernate.c3p0.max_statements}</prop>
                <!-- 每隔120秒检查连接池里的空闲连接 ，单位是秒-->
                <prop key="hibernate.c3p0.idle_test_period">${hibernate.c3p0.idle_test_period}</prop>
                <!-- 当连接池里面的连接用完的时候，C3P0一下获取的新的连接数 -->
                <prop key="hibernate.c3p0.acquire_increment">${hibernate.c3p0.acquire_increment}</prop>
                <!-- 每次都验证连接是否可用 -->
                <prop key="hibernate.c3p0.validate">${hibernate.c3p0.validate}</prop>
            </props>
        </property>
        <!--扫描的实体类路径配置-->
        <property name="packagesToScan" value="cn.knightzz.entity"/>
    </bean>
```

需要注意的有以下几点 : 

- 如果是Hibernate4, class = org.springframework.orm.hibernate4 , 如果是 Hibernate5, class =org.springframework.orm.hibernate5 

另外就是, 一般情况下, 我们创建了一个 实体类, 比如 : 

```java
package com.southwind.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Account {
    private Integer id;
    private String name;
    private Set<Course> courses;
}

```

那么我们就需要创建一个对应的 `Account.hbm.xml` 文件去把实体类和数据库表进性映射 : 

```xml
<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<hibernate-mapping>

    <class name="com.southwind.entity.Account" table="t_account">

        <id name="id" type="java.lang.Integer">
            <column name="id"></column>
            <generator class="identity"></generator>
        </id>

        <property name="name" type="java.lang.String">
            <column name="name"></column>
        </property>

        <set name="courses" table="account_course">
            <key column="aid"></key>
            <many-to-many class="com.southwind.entity.Course" column="cid"></many-to-many>
        </set>

    </class>

</hibernate-mapping>
```

然后再 hibernate.cfg.xml 中进行配置  ` <mapping resource="com/southwind/entity/Account.hbm.xml"></mapping>`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>

    <session-factory>
       	
        ..... 
        
        <!-- 注册实体关系映射文件 -->

        <mapping resource="com/southwind/entity/Orders.hbm.xml"></mapping>
        <mapping resource="com/southwind/entity/Account.hbm.xml"></mapping>


    </session-factory>

</hibernate-configuration>
```



但是, 为了简化开发, 我们可以使用注解进行映射 : 

```java
package cn.knightzz.entity;

import javax.persistence.*;

/**
 * @author 王天赐
 * @title: Student
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 15:24
 */
@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```

注意, 如果实体类名和表名一致(不区分大小写,) 就不需要添加 `@Table(name="")` 注解去指定表名

然后,我们在配置 sessionFactory时, 添加扫描配置 

```xml
   <!--SessionFactory配置-->
    <bean id="sessionFactory"
          class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="hibernateProperties">
            <props>
                <!--以下是Hibernate的基础配置-->
                <!--是否自动更新表格-->
                <prop key="hibernate.hbm2ddl.auto">${hibernate.hbm2ddl.auto}</prop>
                <!--Hibernate方言配置-->
                <prop key="hibernate.dialect">${hibernate.dialect}</prop>
                <!--是否显示SQL语句-->
                <prop key="hibernate.show_sql">${hibernate.show_sql}</prop>
                <!--是否使用格式化SQL语句-->
                <prop key="hibernate.format_sql">${hibernate.format_sql}</prop>
                <!--在格式化的SQL语句的基础之上加强可读性-->
                <prop key="hibernate.use_sql_comments">${hibernate.use_sql_comments}</prop>
                <!--Hibernate缓存统计策略配置-->
                <prop key="hibernate.generate_statistics">${hibernate.generate_statistics}</prop>

                <!--以下是Hibernate的c3p0配置-->
                <!-- 最大连接数 -->
                <prop key="hibernate.c3p0.max_size">${hibernate.c3p0.max_size}</prop>
                <!-- 最小连接数 -->
                <prop key="hibernate.c3p0.min_size">${hibernate.c3p0.min_size}</prop>
                <!-- 获得连接的超时时间,如果超过这个时间,会抛出异常，单位毫秒 -->
                <prop key="hibernate.c3p0.timeout">${hibernate.c3p0.timeout}</prop>
                <!-- 最大的PreparedStatement的数量 -->
                <prop key="hibernate.c3p0.max_statements">${hibernate.c3p0.max_statements}</prop>
                <!-- 每隔120秒检查连接池里的空闲连接 ，单位是秒-->
                <prop key="hibernate.c3p0.idle_test_period">${hibernate.c3p0.idle_test_period}</prop>
                <!-- 当连接池里面的连接用完的时候，C3P0一下获取的新的连接数 -->
                <prop key="hibernate.c3p0.acquire_increment">${hibernate.c3p0.acquire_increment}</prop>
                <!-- 每次都验证连接是否可用 -->
                <prop key="hibernate.c3p0.validate">${hibernate.c3p0.validate}</prop>
            </props>
        </property>
        <!--扫描的实体类路径配置-->
        <property name="packagesToScan" value="cn.knightzz.entity"/>
    </bean>
```

最后一行 ` <property name="packagesToScan" value="cn.knightzz.entity"/>` 扫描实体类路径配置



最后部分是 **事务的部分** : 

```xml
    <!--Hibernate事务配置-->
    <bean id="transactionManager"
          class="org.springframework.orm.hibernate4.HibernateTransactionManager"
          p:sessionFactory-ref="sessionFactory">
    </bean>
    <!--事务配置-->
    <tx:annotation-driven transaction-manager="transactionManager"/>
```

使用bean去注入 sessionFactory, 创建 `HibernateTransactionManager` 类型的bean的对象, 另外这个配置名`id="transactionManager"`是默认识别的, 改了就识别不了



完整的配置如下 : 



```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd

    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd
    http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd">


    <!-- Spring用来扫描注解的 -->
    <context:component-scan base-package="cn.knightzz"/>

    <!-- 导入资源文件 -->
    <context:property-placeholder location="classpath:db.properties"/>
    <!--数据源配置-->
    <bean id="dataSource"
          class="org.springframework.jdbc.datasource.DriverManagerDataSource"
          p:driverClassName="${jdbc.driverClassName}"
          p:url="${jdbc.url}"
          p:username="${jdbc.username}"
          p:password="${jdbc.password}">
    </bean>

    <!--SessionFactory配置-->
    <bean id="sessionFactory"
          class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="hibernateProperties">
            <props>
                <!--以下是Hibernate的基础配置-->
                <!--是否自动更新表格-->
                <prop key="hibernate.hbm2ddl.auto">${hibernate.hbm2ddl.auto}</prop>
                <!--Hibernate方言配置-->
                <prop key="hibernate.dialect">${hibernate.dialect}</prop>
                <!--是否显示SQL语句-->
                <prop key="hibernate.show_sql">${hibernate.show_sql}</prop>
                <!--是否使用格式化SQL语句-->
                <prop key="hibernate.format_sql">${hibernate.format_sql}</prop>
                <!--在格式化的SQL语句的基础之上加强可读性-->
                <prop key="hibernate.use_sql_comments">${hibernate.use_sql_comments}</prop>
                <!--Hibernate缓存统计策略配置-->
                <prop key="hibernate.generate_statistics">${hibernate.generate_statistics}</prop>

                <!--以下是Hibernate的c3p0配置-->
                <!-- 最大连接数 -->
                <prop key="hibernate.c3p0.max_size">${hibernate.c3p0.max_size}</prop>
                <!-- 最小连接数 -->
                <prop key="hibernate.c3p0.min_size">${hibernate.c3p0.min_size}</prop>
                <!-- 获得连接的超时时间,如果超过这个时间,会抛出异常，单位毫秒 -->
                <prop key="hibernate.c3p0.timeout">${hibernate.c3p0.timeout}</prop>
                <!-- 最大的PreparedStatement的数量 -->
                <prop key="hibernate.c3p0.max_statements">${hibernate.c3p0.max_statements}</prop>
                <!-- 每隔120秒检查连接池里的空闲连接 ，单位是秒-->
                <prop key="hibernate.c3p0.idle_test_period">${hibernate.c3p0.idle_test_period}</prop>
                <!-- 当连接池里面的连接用完的时候，C3P0一下获取的新的连接数 -->
                <prop key="hibernate.c3p0.acquire_increment">${hibernate.c3p0.acquire_increment}</prop>
                <!-- 每次都验证连接是否可用 -->
                <prop key="hibernate.c3p0.validate">${hibernate.c3p0.validate}</prop>
            </props>
        </property>
        <!--扫描的实体类路径配置-->
        <property name="packagesToScan" value="cn.knightzz.entity"/>
    </bean>

    <!--Hibernate事务配置-->
    <bean id="transactionManager"
          class="org.springframework.orm.hibernate4.HibernateTransactionManager"
          p:sessionFactory-ref="sessionFactory">
    </bean>
    <!--事务配置-->
    <tx:annotation-driven transaction-manager="transactionManager"/>
</beans>
```



#### hibernate.cfg.xml



```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
    </session-factory>
</hibernate-configuration>

```

这个里面一般可以配置数据源之类的, 但是在 applicationContext中配置过了,所以不需要配置任何东西 



到这里基本上整个项目已经搭建好了





## 测试Spring+Hibernate



### 创建数据库表



先创建一个 `ssh_db` 的数据库

```sql
create table ssh_db.student
(
    id   int auto_increment
        primary key,
    name varchar(255) not null,
    age  int          not null
)
    comment 'ssh测试数据库';
```

然后创建数据库表



### 实体类生成



<img src="https://haloos.oss-cn-beijing.aliyuncs.com/typero/image-20220915165156027.png" alt="image-20220915165156027" style="zoom:50%;" />

先使用 IDEA自带的 DataBase 登陆上, 然后找到 侧边栏有个 Persistence 的功能, 如果找不到就去 IDEA 上方菜单 View -> Tool Windows 找

<img src="https://haloos.oss-cn-beijing.aliyuncs.com/typero/image-20220915165236175.png" alt="image-20220915165236175" style="zoom:50%;" />

选中自己的项目, 单击右键, 选择 Generate ... -> By DataBase Scheme

<img src="https://haloos.oss-cn-beijing.aliyuncs.com/typero/image-20220915165408205.png" alt="image-20220915165408205" style="zoom:50%;" />

如下图所示 

<img src="https://haloos.oss-cn-beijing.aliyuncs.com/typero/image-20220915165641610.png" alt="image-20220915165641610" style="zoom:50%;" />



按照图上的勾选即可, 因为我们是使用注解的方式去映射实体类, 所以不需要生成 xml 文件





### Dao层代码



#### Dao层

定义具体的方法 



```java
package cn.knightzz.dao;

import cn.knightzz.entity.Student;

import java.util.List;

/**
 * @author 王天赐
 * @title: StudentDao
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 12:04
 */
public interface StudentDao {

    public List<Student> findAll();

}

```




#### 实现类



```java
package cn.knightzz.dao.impl;

import cn.knightzz.dao.StudentDao;
import cn.knightzz.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 王天赐
 * @title: StudentDaoImpl
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 12:05
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        return criteria.list();
    }
}

```

需要注意的点是 `sessionFactory.getCurrentSession().createCriteria(Student.class);` 这里后面尽量用 `Student.class` 





### Spring4+Junit4



#### 环境搭建

添加相关的依赖 

```xml

 	<dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>4.3.9.RELEASE</version>
        </dependency>
```

需要注意的是, Spring4 和 Junit4 与 Junit5的使用方式不一样, Junit4的注解使用, Junit5不一定能用



#### 测试 

```java
package cn.knightzz.test;

import cn.knightzz.dao.StudentDao;
import cn.knightzz.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王天赐
 * @title: HibernateTest
 * @projectName zjq-codes
 * @description:
 * @website <a href="http://knightzz.cn/">http://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2022-09-15 14:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HibernateTest {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    StudentDao studentDao;

    @Test
    public void test01() {
        System.out.println(sessionFactory);
        Session session = sessionFactory.openSession();
        System.out.println(session);
        Student student = new Student();
        student.setAge(13);
        student.setId(12);
        student.setName("tom");
        session.save(student);
        // 手动提交事务, 这里和mybatis不一样
        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void test02() {
        System.out.println(studentDao.findAll());
    }
}

```



注意 , 需要两个配置 : 

- @RunWith(SpringJUnit4ClassRunner.class)
- @ContextConfiguration(locations = {"classpath:applicationContext.xml"}) , 这个很重要





## 整合 SpringMVC



### 前言 



**SpringMVC 和前面两个关系不大! 注意** 
