<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生协会管理系统 - 编辑活动</title>
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
        
        /* 表单容器 */
        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            max-width: 800px;
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
            margin-right: 10px;
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
        
        /* 表单组 */
        .form-group {
            margin-bottom: 20px;
        }
        
        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #2B333E;
        }
        
        .form-group input,
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #eaeaea;
            border-radius: 6px;
            font-size: 14px;
        }
        
        .form-group textarea {
            resize: vertical;
            min-height: 100px;
        }
        
        /* 操作按钮区域 */
        .form-actions {
            margin-top: 30px;
            display: flex;
            gap: 10px;
        }
        
        /* 隐藏的输入框 */
        .hidden-input {
            display: none;
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
                        <a href="/demo2_war_exploded/activity" class="active">
                            <i class="fa fa-calendar-check-o"></i>
                            <span>活动管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="/demo2_war_exploded/member">
                            <i class="fa fa-users"></i>
                            <span>成员管理</span>
                        </a>
                    </li>
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
                    <i class="fa fa-calendar-check-o"></i> 活动管理
                </div>
                
                <div class="user-info">
                    <span>欢迎，${studentName}</span>
                    <div class="user-avatar">${studentName.substring(0, 1)}</div>
                </div>
            </nav>
            
            <!-- 主要内容 -->
            <div class="content">
                <!-- 页面标题 -->
                <h1 class="page-title">
                    <i class="fa fa-pencil"></i> 编辑活动
                </h1>
                
                <!-- 表单容器 -->
                <div class="form-container">
                    <form action="/demo2_war_exploded/activity?action=edit" method="post">
                        <!-- 隐藏的活动ID输入框 -->
                        <input type="hidden" name="activityId" value="${activity.activityId}" class="hidden-input">
                        
                        <div class="form-group">
                            <label for="activityName">活动名称</label>
                            <input type="text" id="activityName" name="activityName" value="${activity.activityName}" placeholder="请输入活动名称" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="activitySocietyId">协会ID</label>
                            <input type="text" id="activitySocietyId" name="activitySocietyId" value="${activity.activitySocietyId}" placeholder="请输入协会ID" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="activityIntro">活动介绍</label>
                            <textarea id="activityIntro" name="activityIntro" placeholder="请输入活动介绍" required>${activity.activityIntro}</textarea>
                        </div>
                        
                        <div class="form-group">
                            <label for="activityStartTime">开始时间</label>
                            <input type="datetime-local" id="activityStartTime" name="activityStartTime" value="${activity.activityStartTime}" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="activityEndTime">结束时间</label>
                            <input type="datetime-local" id="activityEndTime" name="activityEndTime" value="${activity.activityEndTime}" required>
                        </div>
                        
                        <!-- 操作按钮 -->
                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary">
                                <i class="fa fa-save"></i> 保存修改
                            </button>
                            <a href="/demo2_war_exploded/activity" class="btn btn-secondary">
                                <i class="fa fa-times"></i> 取消
                            </a>
                        </div>
                    </form>
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
    <script>
        // 格式化日期时间，将LocalDateTime格式转换为datetime-local输入框需要的格式
        function formatLocalDateTime(dateTimeStr) {
            if (!dateTimeStr) return '';
            // 移除T后面的秒数和纳秒数
            return dateTimeStr.replace(/(\d{4}-\d{2}-\d{2}T\d{2}:\d{2}):\d{2}(\.\d+)?/g, '$1');
        }
        
        // 页面加载完成后格式化日期时间
        document.addEventListener('DOMContentLoaded', function() {
            // 获取开始时间和结束时间输入框
            const startTimeInput = document.getElementById('activityStartTime');
            const endTimeInput = document.getElementById('activityEndTime');
            
            // 格式化日期时间
            if (startTimeInput.value) {
                startTimeInput.value = formatLocalDateTime(startTimeInput.value);
            }
            if (endTimeInput.value) {
                endTimeInput.value = formatLocalDateTime(endTimeInput.value);
            }
        });
    </script>
</body>
</html>