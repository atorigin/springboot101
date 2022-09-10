# 問題整理

## 導入 actuator health check endpoint 功能
參考 <https://spring.io/guides/gs/spring-boot/> 之後，導入 `spring-boot-starter-actuator` 到 pom，但是啟動 server 後找不到 <http://localhost:8080/actuator/health>

### 解決方式
1. 在 `application.properties` 檔案裡面新增參數
2. 若新增完還是沒有，要在 `pom.xml` build 標籤改成下面這樣，主要新增 addResources 標籤

```
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<addResources>true</addResources>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>
```

> 參考來源 https://github.com/redhat-developer/vscode-java/issues/400