# Studen - 学生社团管理系统

[![Java](https://img.shields.io/badge/Java-98.2%25-blue.svg)](https://www.java.com/)
[![Maven](https://img.shields.io/badge/Maven-Build-orange.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-Database-brightgreen.svg)](https://www.mysql.com/)
[![Tomcat](https://img.shields.io/badge/Tomcat-Server-red.svg)](https://tomcat.apache.org/)

## 项目简介

**Studen** 是一个简单易用的学生社团管理系统 demo，专为 Java Web 课程设计。该项目实现了社团（Society）、成员（Member）、活动（Activity）、学生（Student）和参与记录（Participation）的基本 CRUD 操作，支持用户登录/注册、列表查看、详情编辑等功能。项目采用传统的 Servlet + JSP + MyBatis 架构，适合初学者学习后端开发和数据库交互。

项目灵感来源于校园社团管理需求，帮助管理员快速维护社团信息和活动记录。当前版本为 demo2，仓库包含完整的源代码和数据库脚本。

## 核心功能

- **用户认证**：登录（Login）和注册（Register）功能，支持 Session 管理。
- **社团管理**：创建、查看、编辑、删除社团（SocietyServlet）。
- **成员管理**：成员列表、添加、编辑（MemberServlet，支持详细 CRUD）。
- **活动管理**：活动列表、创建、详情、编辑（ActivityServlet + JSP 页面）。
- **参与记录**：记录学生对活动的参与（Participation 实体）。
- **首页**：简单仪表盘（IndexServlet）。

## 技术栈

| 类别 | 技术/工具 |
|------|-----------|
| **后端** | Java 8+, Servlet, MyBatis (ORM), JDBC |
| **前端** | JSP, Bootstrap 3.x, jQuery, Font Awesome |
| **数据库** | MySQL 5.7+ |
| **构建** | Maven 3.x |
| **服务器** | Apache Tomcat 9.x |
| **开发工具** | IntelliJ IDEA (推荐) |

- **依赖**：详见 [pom.xml](项目二/demo2/pom.xml)（包括 MySQL Connector、JUnit 等）。
- **项目结构**：
  ```
  项目二/
  └── demo2/
      ├── src/main/java/...          # Servlet、实体、Mapper、Util
      ├── src/main/resources/...      # MyBatis XML、SQL 脚本
      └── webapp/...                 # JSP 页面、静态资源 (assets/)
  ```

## 快速启动

### 环境要求
- JDK 8 或更高
- Maven 3.6+
- MySQL 5.7+
- Tomcat 9.x

### 步骤

1. **克隆仓库**：
   ```bash
   git clone https://github.com/aaddmain/studen.git
   cd 项目二/demo2
   ```

2. **构建项目**：
   ```bash
   mvn clean package
   ```
   这将生成 `target/demo2-1.0-SNAPSHOT.war` 文件。

3. **设置数据库**：
   - 创建数据库：`CREATE DATABASE student_society DEFAULT CHARACTER SET utf8mb4;`
   - 导入 SQL 脚本：
     ```bash
     mysql -u root -p student_society < src/main/resources/student_society.sql
     ```
     SQL 文件定义了 5 张表：`student`、`society`、`member`、`activity`、`participation`，包含外键关系。

4. **部署到 Tomcat**：
   - 将 `target/demo2-1.0-SNAPSHOT.war` 复制到 Tomcat 的 `webapps/` 目录。
   - 启动 Tomcat：`bin/startup.sh` (Linux/Mac) 或 `bin/startup.bat` (Windows)。
   - 访问：http://localhost:8080/demo2-1.0-SNAPSHOT/

5. **测试入口**：
   - 首页：http://localhost:8080/demo2-1.0-SNAPSHOT/
   - 登录：默认无初始用户，需先注册。
   - 示例：访问 `/activity/list` 查看活动列表。

### 配置说明
- 数据库连接：在 `src/main/java/com/gzy/demo2/util/JDBCUtil.java` 中修改 URL、用户名、密码。
- MyBatis 配置：`src/main/resources/mybatis-config.xml`。
- 编码过滤：项目已启用 UTF-8（EncodingFilter）。

## 截图

### 活动列表页面
![Activity List](screenshots/activity-list.png)  
*(Bootstrap 表格显示活动详情，支持分页和搜索。)*

### 成员编辑页面
![Member Edit](screenshots/member-edit.png)  
*(表单输入成员信息，关联学生和社团。)*

*(注：实际截图可通过运行项目后用工具（如 Snipping Tool）生成并上传到 `screenshots/` 目录。)*

## 潜在问题与调试

- **数据库连接失败**：检查 MySQL 服务和 JDBCUtil 配置。
- **JSP 页面 404**：确认 WAR 部署成功，路径为 `/demo2-1.0-SNAPSHOT/[page].jsp`。
- **Maven 依赖问题**：运行 `mvn dependency:resolve`。
- **日志**：Tomcat logs 在 `logs/catalina.out`。

## 贡献指南

1. Fork 仓库。
2. 创建 feature 分支：`git checkout -b feature/new-feature`。
3. 提交更改：`git commit -m 'Add: new feature'`。
4. Push 到分支：`git push origin feature/new-feature`。
5. 提交 Pull Request。

欢迎 issue 反馈或 PR！如需优化建议（如添加分页、Spring Boot 迁移），参考 [issues](https://github.com/aaddmain/studen/issues)。

## 许可证

此项目为开源学习 demo，无特定许可证（MIT 风格）。使用时请注明来源。

---

*项目作者：aaddmain*  
*最后更新：2025-12-18*  
*如有疑问，联系： [your-email@example.com](mailto:your-email@example.com)*
