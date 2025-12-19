<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生协会管理系统 - 首页</title>
    <!-- 引入CSS资源 -->
    <link rel="stylesheet" href="/demo2/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/demo2/assets/css/main.css">
    <link rel="stylesheet" href="/demo2/assets/css/demo.css">
    <link rel="stylesheet" href="/demo2/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/demo2/assets/vendor/linearicons/style.css">
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
        
        /* 欢迎区域 */
        .welcome-section {
            background: linear-gradient(135deg, #00AAFF 0%, #0088cc 100%);
            color: white;
            padding: 40px;
            border-radius: 12px;
            margin-bottom: 30px;
            box-shadow: 0 4px 15px rgba(0, 170, 255, 0.2);
        }
        
        .welcome-section h1 {
            font-size: 32px;
            font-weight: 700;
            margin-bottom: 10px;
        }
        
        .welcome-section p {
            font-size: 16px;
            opacity: 0.95;
            margin: 0;
        }
        
        /* 统计数据卡片 */
        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }
        
        .stat-card {
            background-color: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            border: 1px solid #eaeaea;
            transition: all 0.3s ease;
        }
        
        .stat-card:hover {
            transform: translateY(-3px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }
        
        .stat-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        
        .stat-icon {
            width: 40px;
            height: 40px;
            border-radius: 8px;
            background: linear-gradient(135deg, #00AAFF 0%, #0088cc 100%);
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 18px;
        }
        
        .stat-title {
            font-size: 14px;
            color: #8d9093;
            font-weight: 500;
        }
        
        .stat-value {
            font-size: 28px;
            font-weight: 700;
            color: #00AAFF;
            margin-bottom: 5px;
        }
        
        .stat-change {
            font-size: 12px;
            color: #41B314;
        }
        
        /* 功能模块 - 左右布局 */
        .modules-section {
            background-color: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            border: 1px solid #eaeaea;
            margin-bottom: 30px;
        }
        
        .section-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
            padding-bottom: 15px;
            border-bottom: 2px solid #f0f0f0;
        }
        
        .section-title {
            font-size: 20px;
            font-weight: 600;
            color: #2B333E;
            margin: 0;
        }
        
        .module-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 25px;
        }
        
        .module-card {
            background-color: #f8f9fa;
            padding: 25px;
            border-radius: 10px;
            transition: all 0.3s ease;
            border: 2px solid transparent;
        }
        
        .module-card:hover {
            background-color: white;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
            border-color: #00AAFF;
        }
        
        .module-header {
            display: flex;
            align-items: center;
            gap: 15px;
            margin-bottom: 15px;
        }
        
        .module-icon {
            width: 50px;
            height: 50px;
            border-radius: 10px;
            background: linear-gradient(135deg, #00AAFF 0%, #0088cc 100%);
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 24px;
        }
        
        .module-info h3 {
            font-size: 18px;
            font-weight: 600;
            color: #2B333E;
            margin: 0 0 5px 0;
        }
        
        .module-info p {
            font-size: 14px;
            color: #8d9093;
            margin: 0;
        }
        
        .module-stats {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 15px;
            margin-bottom: 20px;
        }
        
        .module-stat {
            background-color: white;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 1px 5px rgba(0, 0, 0, 0.05);
        }
        
        .module-stat-label {
            font-size: 12px;
            color: #8d9093;
            margin-bottom: 5px;
        }
        
        .module-stat-value {
            font-size: 20px;
            font-weight: 600;
            color: #00AAFF;
        }
        
        .module-actions {
            display: flex;
            gap: 10px;
        }
        
        /* 快速操作卡片 */
        .quick-actions {
            background-color: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            border: 1px solid #eaeaea;
        }
        
        .actions-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
        }
        
        .action-card {
            background-color: #f8f9fa;
            padding: 25px 20px;
            border-radius: 10px;
            text-align: center;
            cursor: pointer;
            transition: all 0.3s ease;
            border: 2px solid transparent;
        }
        
        .action-card:hover {
            background-color: white;
            transform: translateY(-3px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            border-color: #00AAFF;
        }
        
        .action-card i {
            font-size: 32px;
            color: #00AAFF;
            margin-bottom: 15px;
            display: block;
        }
        
        .action-card h4 {
            font-size: 16px;
            font-weight: 600;
            color: #2B333E;
            margin-bottom: 8px;
        }
        
        .action-card p {
            font-size: 13px;
            color: #8d9093;
            margin: 0;
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
        @media (max-width: 1024px) {
            .module-grid {
                grid-template-columns: 1fr;
            }
        }
        
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
            
            .stats-grid {
                grid-template-columns: repeat(2, 1fr);
            }
            
            .actions-grid {
                grid-template-columns: repeat(2, 1fr);
            }
        }
        
        @media (max-width: 480px) {
            .stats-grid,
            .actions-grid {
                grid-template-columns: 1fr;
            }
            
            .welcome-section {
                padding: 20px;
            }
            
            .welcome-section h1 {
                font-size: 24px;
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
                <a href="index.jsp" class="sidebar-logo">
                    <i class="fa fa-university"></i>
                    <span>学生协会管理系统</span>
                </a>
            </div>
            
            <!-- 侧边栏导航 -->
            <nav>
                <ul class="sidebar-nav">
                    <li>
                        <a href="index" class="active">
                            <i class="fa fa-dashboard"></i>
                            <span>首页</span>
                        </a>
                    </li>
                    <li>
                        <a href="society">
                            <i class="fa fa-university"></i>
                            <span>协会管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="activity">
                            <i class="fa fa-calendar-check-o"></i>
                            <span>活动管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="member">
                            <i class="fa fa-users"></i>
                            <span>成员管理</span>
                        </a>
                    </li>
                    <li>
                        <a href="login.jsp">
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
                    <i class="fa fa-home"></i> 首页
                </div>
                
                <div class="user-info">
                    <span>欢迎，${studentName}</span>
                    <div class="user-avatar">${studentName.substring(0, 1)}</div>
                </div>
            </nav>
            
            <!-- 主要内容 -->
            <div class="content">
                <!-- 欢迎区域 -->
                <section class="welcome-section">
                    <h1>欢迎使用学生协会管理系统</h1>
                    <p>高效管理协会事务，打造丰富多彩的校园社团文化</p>
                </section>
                
                <!-- 统计数据 -->
                <section class="stats-section">
                    <div class="stats-grid">
                        <div class="stat-card">
                            <div class="stat-header">
                                <span class="stat-title">协会总数</span>
                                <div class="stat-icon">
                                    <i class="fa fa-university"></i>
                                </div>
                            </div>
                            <div class="stat-value">${societyCount}</div>
                            <div class="stat-change">
                                <i class="fa fa-arrow-up"></i> 2 个新协会
                            </div>
                        </div>
                        
                        <div class="stat-card">
                            <div class="stat-header">
                                <span class="stat-title">注册会员</span>
                                <div class="stat-icon">
                                    <i class="fa fa-users"></i>
                                </div>
                            </div>
                            <div class="stat-value">${studentCount}</div>
                            <div class="stat-change">
                                <i class="fa fa-arrow-up"></i> 50 名新会员
                            </div>
                        </div>
                        
                        <div class="stat-card">
                            <div class="stat-header">
                                <span class="stat-title">活动次数</span>
                                <div class="stat-icon">
                                    <i class="fa fa-calendar-check-o"></i>
                                </div>
                            </div>
                            <div class="stat-value">${activityCount}</div>
                            <div class="stat-change">
                                <i class="fa fa-arrow-up"></i> 5 个新活动
                            </div>
                        </div>
                        
                        <div class="stat-card">
                            <div class="stat-header">
                                <span class="stat-title">满意度</span>
                                <div class="stat-icon">
                                    <i class="fa fa-line-chart"></i>
                                </div>
                            </div>
                            <div class="stat-value">95%</div>
                            <div class="stat-change">
                                <i class="fa fa-arrow-up"></i> 2% 提升
                            </div>
                        </div>
                    </div>
                </section>
                
                <!-- 功能模块 -->
                <section class="modules-section">
                    <div class="section-header">
                        <h2 class="section-title">核心功能</h2>
                        <button class="btn btn-primary">
                            <i class="fa fa-plus"></i> 新建任务
                        </button>
                    </div>
                    
                    <div class="module-grid">
                        <!-- 协会管理模块 -->
                        <div class="module-card">
                            <div class="module-header">
                                <div class="module-icon">
                                    <i class="fa fa-university"></i>
                                </div>
                                <div class="module-info">
                                    <h3>协会管理</h3>
                                    <p>管理协会信息，包括创建、审核、编辑和状态管理</p>
                                </div>
                            </div>
                            
                            <div class="module-stats">
                                <div class="module-stat">
                                    <div class="module-stat-label">待审核协会</div>
                                    <div class="module-stat-value">${pendingSocieties}</div>
                                </div>
                                <div class="module-stat">
                                    <div class="module-stat-label">活跃协会</div>
                                    <div class="module-stat-value">${activeSocieties}</div>
                                </div>
                            </div>
                            
                            <div class="module-actions">
                                <a href="society" class="btn btn-primary">
                                    <i class="fa fa-list"></i> 查看所有
                                </a>
                                <a href="society?action=create" class="btn btn-secondary">
                                    <i class="fa fa-plus"></i> 新建协会
                                </a>
                            </div>
                        </div>
                        
                        <!-- 活动管理模块 -->
                        <div class="module-card">
                            <div class="module-header">
                                <div class="module-icon">
                                    <i class="fa fa-calendar-check-o"></i>
                                </div>
                                <div class="module-info">
                                    <h3>活动管理</h3>
                                    <p>发布、管理和推广协会活动，支持活动报名和签到</p>
                                </div>
                            </div>
                            
                            <div class="module-stats">
                                <div class="module-stat">
                                    <div class="module-stat-label">本月活动</div>
                                    <div class="module-stat-value">${thisMonthActivities}</div>
                                </div>
                                <div class="module-stat">
                                    <div class="module-stat-label">待审批</div>
                                    <div class="module-stat-value">${pendingActivities}</div>
                                </div>
                            </div>
                            
                            <div class="module-actions">
                                <a href="activity" class="btn btn-primary">
                                    <i class="fa fa-calendar"></i> 活动列表
                                </a>
                                <a href="activity?action=create" class="btn btn-secondary">
                                    <i class="fa fa-plus"></i> 发布活动
                                </a>
                            </div>
                        </div>
                    </div>
                </section>
                
                <!-- 快速操作 -->
                <section class="quick-actions">
                    <div class="section-header">
                        <h2 class="section-title">快速操作</h2>
                    </div>
                    
                    <div class="actions-grid">
                        <div class="action-card" onclick="location.href='#'">
                            <i class="fa fa-line-chart"></i>
                            <h4>数据统计</h4>
                            <p>查看协会运营数据报表</p>
                        </div>
                        
                        <div class="action-card" onclick="location.href='#'">
                            <i class="fa fa-bell"></i>
                            <h4>通知管理</h4>
                            <p>发送协会通知和活动提醒</p>
                        </div>
                        
                        <div class="action-card" onclick="location.href='#'">
                            <i class="fa fa-comments"></i>
                            <h4>留言反馈</h4>
                            <p>处理成员留言和反馈信息</p>
                        </div>
                        
                        <div class="action-card" onclick="location.href='#'">
                            <i class="fa fa-cog"></i>
                            <h4>系统设置</h4>
                            <p>配置协会系统参数和权限</p>
                        </div>
                    </div>
                </section>
            </div>
            
            <!-- 页脚 -->
            <footer class="footer">
                <p>&copy; 2025 学生协会管理系统. 版权所有.</p>
            </footer>
        </main>
    </div>

    <!-- 引入JavaScript资源 -->
    <script src="/demo2/assets/vendor/jquery/jquery.min.js"></script>
    <script src="/demo2/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="/demo2/assets/scripts/klorofil-common.js"></script>
</body>
</html>
