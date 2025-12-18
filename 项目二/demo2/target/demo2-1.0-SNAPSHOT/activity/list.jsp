<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生协会管理系统 - 活动列表</title>
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
        
        /* 工具栏 */
        .toolbar {
            background-color: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            margin-bottom: 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        
        /* 搜索框 */
        .search-box {
            display: flex;
            gap: 10px;
            align-items: center;
        }
        
        .search-box input {
            padding: 8px 15px;
            border: 1px solid #eaeaea;
            border-radius: 6px;
            font-size: 14px;
            width: 250px;
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
        
        /* 状态标签 */
        .status-tag {
            padding: 4px 12px;
            border-radius: 12px;
            font-size: 12px;
            font-weight: 600;
        }
        
        .status-normal {
            background-color: #d4edda;
            color: #155724;
        }
        
        .status-paused {
            background-color: #fff3cd;
            color: #856404;
        }
        
        .status-stopped {
            background-color: #f8d7da;
            color: #721c24;
        }
        
        /* 操作按钮组 */
        .action-buttons {
            display: flex;
            gap: 8px;
        }
        
        /* 分页 */
        .pagination {
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
            gap: 10px;
        }
        
        .pagination a {
            padding: 8px 12px;
            border: 1px solid #eaeaea;
            border-radius: 6px;
            color: #676a6d;
            text-decoration: none;
            transition: all 0.3s ease;
        }
        
        .pagination a:hover {
            background-color: #00AAFF;
            color: white;
            border-color: #00AAFF;
        }
        
        .pagination .active {
            background-color: #00AAFF;
            color: white;
            border-color: #00AAFF;
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
        
        /* 响应式设计 */
        @media (max-width: 768px) {
            .sidebar {
                width: 60px;
            }
            
            .sidebar-logo span,
            .sidebar-nav a span {
                display: none;
            }
            
            .sidebar-nav a {
                padding: 18px 15px;
                text-align: center;
            }
            
            .sidebar-nav a i {
                margin-right: 0;
            }
            
            .main-content {
                margin-left: 60px;
            }
            
            .top-nav {
                padding: 0 15px;
            }
            
            .content {
                padding: 15px;
            }
            
            .toolbar {
                flex-direction: column;
                gap: 15px;
                align-items: stretch;
            }
            
            .search-box {
                justify-content: center;
            }
            
            .action-buttons {
                flex-wrap: wrap;
            }
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
                    <i class="fa fa-list"></i> 活动列表
                </h1>
                
                <!-- 工具栏 -->
                <div class="toolbar">
                    <div class="search-box">
                        <input type="text" placeholder="搜索活动名称..." name="keyword">
                        <button class="btn btn-primary">
                            <i class="fa fa-search"></i> 搜索
                        </button>
                    </div>
                    <a href="/demo2_war_exploded/activity?action=create" class="btn btn-primary">
                        <i class="fa fa-plus"></i> 新建活动
                    </a>
                </div>
                
                <!-- 活动列表表格 -->
                <div class="table-container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>活动ID</th>
                                <th>活动名称</th>
                                <th>活动时间</th>
                                <th>活动地点</th>
                                <th>协会名称</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- 活动列表数据将从数据库动态获取 -->
                            <tr>
                                <td colspan="7" style="text-align: center; color: #999; padding: 50px;">
                                    <i class="fa fa-info-circle"></i> 暂无活动数据
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <!-- 分页 -->
                <div class="pagination">
                    <a href="#">&laquo; 上一页</a>
                    <a href="#" class="active">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页 &raquo;</a>
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
</body>
</html>