### 1.执行mybatis generator
`generatorConfig.xml`
#### 执行步骤
`点击Maven→→→→→Plugins→→→→→mybatis-generator→→→→→双击mybatis-generator:generate`
![img.png](img.png)


### 2.Windown10环境Mysql
`dump文件位置路径\resources\db_dump\huinongwang.db`
#### 2.1 mysql导出dump
```sql
--在系统命令行操作
--C:\Users\30270> mysqldump -uroot -p huinongwang> D:\sql\huinongwang.db
mysqldump -uroot -p huinongwang> D:\sql\huinongwang.db
```
#### 2.2 mysql导入dump
##### 2.2.1 系统行命令
```sql
--在系统命令行操作
--格式：mysql -h[ip] -P[(大写)端口] -u[用户名] -p[密码]  [数据库名] < d:XX.sql(路径) 
--导入命令：mysql -uroot -proot -h127.0.0.1 -P3306 education<d:/database.sql
mysql -uroot -proot -h127.0.0.1 -P3306 huinongwang<D:\sql\huinongwang.db
```
##### 2.2.2 soure 方法
```sql
mysql > use db_name
mysql > source D:\sql\huinongwang.db
```

### 3.git问题
#### 3.1 git push报错
`报错信息如下`
```sql
fatal: unable to access 'https://github.com/Gitcll/huinong_wx.git/': OpenSSL SSL_read: SSL_ERROR_SYSCALL, errno 10054
```
`解决方案`
```sql
--参考网站
--https://zhuanlan.zhihu.com/p/273370216
git config http.sslVerify "false"
```

### 4.jacoco
```properties
#sonar-project.properties
sonar.projectKey=huinong_wx_sonar
sonar.projectName=huinong_wx_sonar_name
sonar.projectVersion=1.3
sonar.language=java
#sonar.modules=huinong_wx
sonar.sources=src/main/java
sonar.java.binaries=target/classes
sonar.sourceEncoding=UTF-8
sonar.coverage.jacoco.xmlReportPaths=..
```
```xml
    <dependencies>
        <properties>
            <java.version>11</java.version>
            <jacoco.version>0.8.5</jacoco.version>
        </properties>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.6</version>
                <configuration>
                    <configurationFile>${basedir}/src/main/resources/generatorConfig.xml</configurationFile>
                    <overwrite>true</overwrite>
                    <verbose>true</verbose>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>${jacoco.version}</version>
                <configuration>
                    <skip>true</skip>
                    <destFile>${basedir}/target/coverage-reports/jacoco-unit.exec</destFile>
                    <dataFile>${basedir}/target/coverage-reports/jacoco-unit.exec</dataFile>
                    <output>file</output>
                    <append>true</append>
                    <excludes>
                        <exclude>com/huinong/**</exclude>
                    </excludes>

                    <rules>
                        <rule implementation="org.jacoco.maven.RuleConfiguration">
                            <element>BUNDLE</element>
                            <limits>　　
                                <limit implementation="org.jacoco.report.check.Limit">
                                    <counter>METHOD</counter>
                                    <value>COVEREDRATIO</value>
                                    <minimum>0.50</minimum>
                                </limit>
                                <limit implementation="org.jacoco.report.check.Limit">
                                    <counter>BRANCH</counter>
                                    <value>COVEREDRATIO</value>
                                    <minimum>0.50</minimum>
                                </limit>
                                <limit implementation="org.jacoco.report.check.Limit">
                                    <counter>CLASS</counter>
                                    <value>MISSEDCOUNT</value>
                                    <maximum>0</maximum>
                                </limit>
                            </limits>
                        </rule>
                    </rules>

                </configuration>
                <executions>
                    <execution>
                        <id>jacoco-initialize</id>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                        <phase>test-compile</phase>
                    </execution>

                    <!--                    <execution>-->
                    <!--                        <id>check</id>-->
                    <!--                        <goals>-->
                    <!--                            <goal>check</goal>-->
                    <!--                        </goals>-->
                    <!--                    </execution>-->

                    <execution>
                        <id>jacoco-site</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <!--                <sonar.jdbc.url>jdbc:postgresql://localhost/sonar</sonar.jdbc.url>-->
                <!--                <sonar.jdbc.driver>org.postgresql.Driver</sonar.jdbc.driver>-->
                <!--                <sonar.jdbc.username>user</sonar.jdbc.username>-->
                <!--                <sonar.jdbc.password>password</sonar.jdbc.password>-->
                <sonar.host.url>http://localhost:9000</sonar.host.url>
<!--                <sonar.login>admin</sonar.login>
                <sonar.password>admin</sonar.password>-->
                <sonar.login>9656c84090b2481db6ea97b6d14d87d546bff619</sonar.login>

            </properties>
        </profile>
    </profiles>
```