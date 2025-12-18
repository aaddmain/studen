<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生协会管理系统 - 协会详情</title>
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
        
        /* 详情卡片 */
        .detail-card {
            background-color: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            margin-bottom: 30px;
        }
        
        .detail-header {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            margin-bottom: 30px;
            padding-bottom: 20px;
            border-bottom: 2px solid #f0f0f0;
        }
        
        .detail-title {
            font-size: 20px;
            font-weight: 600;
            color: #2B333E;
            margin: 0;
        }
        
        .detail-status {
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
        
        /* 详情内容 */
        .detail-content {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 30px;
        }
        
        .detail-item {
            margin-bottom: 20px;
        }
        
        .detail-label {
            font-weight: 600;
            color: #2B333E;
            margin-bottom: 8px;
            display: block;
            font-size: 14px;
        }
        
        .detail-value {
            color: #676a6d;
            font-size: 15px;
        }
        
        /* 详情描述 */
        .detail-description {
            grid-column: 1 / -1;
            margin-top: 20px;
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
            
            .detail-content {
                grid-template-columns: 1fr;
            }
            
            .detail-header {
                flex-direction: column;
                gap: 15px;
                align-items: flex-start;
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
                        <a href="/demo2_war_exploded/society" class="active">
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
                    <i class="fa fa-university"></i> 协会管理
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
                    <i class="fa fa-eye"></i> 协会详情
                </h1>
                
                <!-- 工具栏 -->
                <div class="toolbar">
                    <div>
                        <a href="/demo2_war_exploded/society" class="btn btn-secondary">
                            <i class="fa fa-arrow-left"></i> 返回列表
                        </a>
                        <a href="/demo2_war_exploded/society?action=edit&id=${society.societyId}" class="btn btn-primary">
                            <i class="fa fa-pencil"></i> 编辑协会
                        </a>
                    </div>
                </div>
                
                <!-- 协会详情卡片 -->
                <div class="detail-card">
                    <div class="detail-header">
                        <h2 class="detail-title">${society.societyName}</h2>
                        <span class="detail-status status-${society.societyStatus == 1 ? 'normal' : society.societyStatus == 2 ? 'paused' : 'stopped'}">
                            ${society.societyStatus == 1 ? '正常' : society.societyStatus == 2 ? '停招' : '停运'}
                        </span>
                    </div>
                    
                    <div class="detail-content">
                        <div>
                            <div class="detail-item">
                                <span class="detail-label">协会ID</span>
                                <div class="detail-value">${society.societyId}</div>
                            </div>
                            
                            <div class="detail-item">
                                <span class="detail-label">创始人</span>
                                <div class="detail-value">${society.societyCreator}</div>
                            </div>
                            
                            <div class="detail-item">
                                <span class="detail-label">创建时间</span>
                                <div class="detail-value">${society.societyCreateDate}</div>
                            </div>
                        </div>
                        
                        <div>
                            <div class="detail-item">
                                <span class="detail-label">协会状态</span>
                                <div class="detail-value">
                                    ${society.societyStatus == 1 ? '正常' : society.societyStatus == 2 ? '停招' : '停运'}
                                </div>
                            </div>
                        </div>
                        
                        <div class="detail-description">
                            <span class="detail-label">协会简介</span>
                            <div class="detail-value">${society.societyIntro}</div>
                        </div>
                    </div>
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