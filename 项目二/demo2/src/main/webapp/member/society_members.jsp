<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生协会管理系统 - 协会成员</title>
    <!-- 引入CSS资源 -->
    <link rel="stylesheet" href="/demo2_war_exploded/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/demo2_war_exploded/assets/css/main.css">
    <link rel="stylesheet" href="/demo2_war_exploded/assets/css/demo.css">
    <link rel="stylesheet" href="/demo2_war_exploded/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/demo2_war_exploded/assets/vendor/linearicons/style.css">
    <style>
        /* 全局样式重置 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Source Sans Pro', 'Microsoft YaHei', sans-serif;
            font-size: 15px;
            line-height: 1.6;
            color: #676a6d;
            background-color: #F3F5F8;
        }
        
        /* 主容器 - 左右布局 */
        .main-container {
            min-height: 100vh;
            display: flex;
            flex-direction: row;
        }
        
        /* 左侧导航栏 */
        .sidebar {
            width: 260px;
            background-color: #2B333E;
            color: #AEB7C2;
            position: fixed;
            top: 0;
            left: 0;
            bottom: 0;
            z-index: 1000;
            box-shadow: 2px 0 10px rgba(0, 0, 0, 0.1);
            overflow-y: auto;
        }
        
        /* 侧边栏头部 */
        .sidebar-header {
            padding: 20px;
            background-color: #252c35;
            border-bottom: 1px solid #3a434d;
        }
        
        .sidebar-logo {
            font-size: 18px;
            font-weight: 600;
            color: #00AAFF;
            text-decoration: none;
            display: block;
            text-align: center;
        }
        
        /* 侧边栏导航菜单 */
        .sidebar-nav {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        
        .sidebar-nav li {
            border-bottom: 1px solid #3a434d;
        }
        
        .sidebar-nav a {
            display: block;
            padding: 18px 30px;
            color: #AEB7C2;
            text-decoration: none;
            transition: all 0.3s ease;
            border-left: 5px solid transparent;
        }
        
        .sidebar-nav a:hover,
        .sidebar-nav a.active {
            color: white;
            background-color: #252c35;
            border-left-color: #00AAFF;
        }
        
        .sidebar-nav a i {
            margin-right: 10px;
            font-size: 18px;
        }
        
        .sidebar-nav a:hover i,
        .sidebar-nav a.active i {
            color: #00AAFF;
        }
        
        /* 右侧主内容区 */
        .main-content {
            margin-left: 260px;
            flex: 1;
            display: flex;
            flex-direction: column;
        }
        
        /* 顶部导航栏 */
        .top-nav {
            background-color: white;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            padding: 0 30px;
            height: 60px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            position: sticky;
            top: 0;
            z-index: 999;
        }
        
        .nav-title {
            font-size: 20px;
            font-weight: 600;
            color: #2B333E;
        }
        
        .user-info {
            display: flex;
            align-items: center;
            gap: 15px;
        }
        
        .user-avatar {
            width: 36px;
            height: 36px;
            border-radius: 50%;
            background-color: #00AAFF;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
        }
        
        /* 内容区域 */
        .content {
            flex: 1;
            padding: 30px;
        }
        
        /* 页面标题 */
        .page-title {
            font-size: 24px;
            font-weight: 600;
            color: #2B333E;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        
        /* 按钮样式 */
        .btn {
            padding: 8px 20px;
            border-radius: 6px;
            font-weight: 600;
            text-decoration: none;
            transition: all 0.3s ease;
            display: inline-block;
            border: none;
            cursor: pointer;
            font-size: 14px;
        }
        
        .btn-primary {
            background-color: #00AAFF;
            color: white;
        }
        
        .btn-primary:hover {
            background-color: #0088cc;
            transform: translateY(-1px);
            box-shadow: 0 3px 10px rgba(0, 170, 255, 0.3);
        }
        
        .btn-secondary {
            background-color: #f8f9fa;
            color: #676a6d;
            border: 1px solid #eaeaea;
        }
        
        .btn-secondary:hover {
            background-color: #eaeaea;
            transform: translateY(-1px);
        }
        
        .btn-danger {
            background-color: #dc3545;
            color: white;
        }
        
        .btn-danger:hover {
            background-color: #c82333;
            transform: translateY(-1px);
            box-shadow: 0 3px 10px rgba(220, 53, 69, 0.3);
        }
        
        .btn-success {
            background-color: #28a745;
            color: white;
        }
        
        .btn-success:hover {
            background-color: #218838;
            transform: translateY(-1px);
            box-shadow: 0 3px 10px rgba(40, 167, 69, 0.3);
        }
        
        /* 表格样式 */
        .table-container {
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
        }
        
        .table {
            width: 100%;
            border-collapse: collapse;
        }
        
        .table th,
        .table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #eaeaea;
        }
        
        .table th {
            background-color: #f8f9fa;
            font-weight: 600;
            color: #2B333E;
            font-size: 14px;
        }
        
        .table tr:hover {
            background-color: #f8f9fa;
        }
        
        /* 操作按钮组 */
        .action-buttons {
            display: flex;
            gap: 8px;
        }
        
        /* 页脚 */
        .footer {
            background-color: white;
            padding: 20px 30px;
            border-top: 1px solid #eaeaea;
            text-align: center;
            font-size: 14px;
            color: #8d9093;
        }
    </style>
</head>
<body>
    <div class="main-container">
        <!-- 左侧导航栏 -->
        <aside class="sidebar">
            <!-- 侧边栏头部 -->
            <div class="sidebar-header">
                <a href="/demo2_war_exploded/index" class="sidebar-logo">
                    <i class="fa fa-university"></i>
                    <span>学生协会管理系统</span>
                </a>
            </div>
            
            <!-- 侧边栏导航 -->
            <nav>
                <ul class="sidebar-nav">
                    <li>
                        <a href="/demo2_war_exploded/index">
                            <i class="fa fa-dashboard"></i>
                            <span>首页</span>
                        </a>
                    </li>
                    <li>
                        <a href="/demo2_war_exploded/society">
                            <i class="fa fa-university"></i>
                            <span>协会管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="/demo2_war_exploded/activity">
                            <i class="fa fa-calendar-check-o"></i>
                            <span>活动管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="/demo2_war_exploded/member" class="active">
                            <i class="fa fa-users"></i>
                            <span>成员管理</span>
                        </a>
                    </li>
                    <!-- 只有会长和副会长可以看到申请列表 -->
                    <c:if test="${isPresidentOrVice}">
                        <li>
                            <a href="/demo2_war_exploded/member?action=joinApplicationList">
                                <i class="fa fa-list-alt"></i>
                                <span>加入申请列表</span>
                            </a>
                        </li>
                        <li>
                            <a href="/demo2_war_exploded/member?action=quitApplicationList">
                                <i class="fa fa-list-alt"></i>
                                <span>退出申请列表</span>
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="#">
                            <i class="fa fa-line-chart"></i>
                            <span>数据报表</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-bell"></i>
                            <span>通知管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-comments"></i>
                            <span>留言反馈</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-cog"></i>
                            <span>系统设置</span>
                        </a>
                    </li>
                    <li>
                        <a href="/demo2_war_exploded/login.jsp">
                            <i class="fa fa-sign-out"></i>
                            <span>退出登录</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </aside>
        
        <!-- 右侧主内容区 -->
        <main class="main-content">
            <!-- 顶部导航栏 -->
            <nav class="top-nav">
                <div class="nav-title">
                    <i class="fa fa-users"></i> 成员管理
                </div>
                
                <div class="user-info">
                    <span>欢迎，${studentName}</span>
                    <div class="user-avatar">${studentName.substring(0, 1)}</div>
                </div>
            </nav>
            
            <!-- 主要内容 -->
            <div class="content">
                <!-- 消息提示 -->
                <c:if test="${not empty message}">
                    <div class="alert alert-${messageType == 'error' ? 'danger' : 'success'}" style="margin-bottom: 20px;">
                        <i class="fa fa-${messageType == 'error' ? 'exclamation-circle' : 'check-circle'}"></i> ${message}
                    </div>
                </c:if>
                
                <!-- 页面标题 -->
                <h1 class="page-title">
                    <i class="fa fa-users"></i> ${society.societyName} - 成员列表
                </h1>
                
                <!-- 成员列表表格 -->
                <div class="table-container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>学号</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>加入时间</th>
                                <th>职位</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${empty members}">
                                    <tr>
                                        <td colspan="6" style="text-align: center; color: #999; padding: 50px;">
                                            <i class="fa fa-info-circle"></i> 暂无成员数据
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${members}" var="member">
                                        <tr>
                                            <td>${member.studentNumber}</td>
                                            <td>${member.studentName}</td>
                                            <td>${member.gender}</td>
                                            <td>${member.joinDate}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${member.memberPosition == 1}">会长</c:when>
                                                    <c:when test="${member.memberPosition == 2}">副会长</c:when>
                                                    <c:when test="${member.memberPosition == 3}">成员</c:when>
                                                    <c:otherwise>未知</c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <div class="action-buttons">
                                                    <!-- 退出协会按钮 -->
                                                    <form action="/demo2_war_exploded/member" method="post" style="display: inline;">
                                                        <input type="hidden" name="action" value="applyQuit">
                                                        <input type="hidden" name="id" value="${member.memberId}">
                                                        <input type="hidden" name="societyId" value="${society.societyId}">
                                                        <button type="submit" class="btn btn-danger" onclick="return confirm('确定要退出这个协会吗？')">
                                                            <i class="fa fa-sign-out"></i> 退出协会
                                                        </button>
                                                    </form>
                                                    <!-- 会长和副会长可以审批退出 -->
                                                    <c:if test="${currentMember.memberPosition == 1 || currentMember.memberPosition == 2}">
                                                        <!-- 同意退出按钮 -->
                                                        <form action="/demo2_war_exploded/member" method="post" style="display: inline;">
                                                            <input type="hidden" name="action" value="approveQuit">
                                                            <input type="hidden" name="id" value="${member.memberId}">
                                                            <button type="submit" class="btn btn-success" onclick="return confirm('确定要同意这个退出申请吗？')">
                                                                <i class="fa fa-check"></i> 同意退出
                                                            </button>
                                                        </form>
                                                        <!-- 拒绝退出按钮 -->
                                                        <form action="/demo2_war_exploded/member" method="post" style="display: inline;">
                                                            <input type="hidden" name="action" value="rejectQuit">
                                                            <input type="hidden" name="id" value="${member.memberId}">
                                                            <button type="submit" class="btn btn-warning" onclick="return confirm('确定要拒绝这个退出申请吗？')">
                                                                <i class="fa fa-times"></i> 拒绝退出
                                                            </button>
                                                        </form>
                                                    </c:if>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
            
            <!-- 页脚 -->
            <footer class="footer">
                <p>&copy; 2025 学生协会管理系统. 版权所有.</p>
            </footer>
        </main>
    </div>

    <!-- 引入JavaScript资源 -->
    <script src="/demo2_war_exploded/assets/vendor/jquery/jquery.min.js"></script>
    <script src="/demo2_war_exploded/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/demo2_war_exploded/assets/scripts/klorofil-common.js"></script>
    
    <!-- 弹窗提示脚本 -->
    <c:if test="${not empty alertMessage}">
        <script type="text/javascript">
            alert("${alertMessage}");
        </script>
    </c:if>
</body>
</html>