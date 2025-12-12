<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生协会管理系统 - 首页</title>
    <!-- 引入CSS资源 -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/demo.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <style>
        /* 自定义主页样式 */
        body {
            font-family: 'Source Sans Pro', 'Microsoft YaHei', sans-serif;
            font-size: 14px;
            line-height: 1.5;
            color: #333;
            background-color: #f5f5f5;
        }
        
        /* 导航栏样式 */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        
        /* 头部横幅样式 */
        .header-banner {
            background-color: #00AAFF;
            color: white;
            padding: 60px 0;
            text-align: center;
        }
        
        .header-banner h1 {
            font-size: 48px;
            margin-bottom: 20px;
        }
        
        .header-banner p {
            font-size: 20px;
            opacity: 0.9;
        }
        
        /* 内容区域样式 */
        .content-area {
            padding: 40px 0;
            background-color: white;
        }
        
        /* 页脚样式 */
        .footer {
            background-color: #333;
            color: white;
            padding: 30px 0;
            text-align: center;
        }
        
        /* 协会卡片样式 */
        .society-card {
            border: 1px solid #eaeaea;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 20px;
            transition: all 0.3s ease;
        }
        
        .society-card:hover {
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            transform: translateY(-5px);
        }
        
        /* 统计卡片样式 */
        .stat-card {
            background-color: #f8f9fa;
            border-radius: 8px;
            padding: 30px;
            text-align: center;
            margin-bottom: 30px;
        }
        
        .stat-card h3 {
            font-size: 36px;
            color: #00AAFF;
            margin-bottom: 10px;
        }
        
        .stat-card p {
            font-size: 16px;
            color: #666;
            margin: 0;
        }
    </style>
</head>
<body>
    <!-- 导航栏 -->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">学生协会管理系统</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.jsp">首页</a></li>
                    <li><a href="#societies">协会列表</a></li>
                    <li><a href="#activities">活动信息</a></li>
                    <li><a href="#members">成员管理</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="fa fa-user"></span> 张三</a></li>
                    <li><a href="login.jsp"><span class="fa fa-sign-out"></span> 退出</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- 头部横幅 -->
    <div class="header-banner">
        <div class="container">
            <h1>欢迎使用学生协会管理系统</h1>
            <p>管理协会信息，组织精彩活动，连接学生与社团</p>
        </div>
    </div>

    <!-- 统计信息 -->
    <div class="content-area">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="stat-card">
                        <h3>25</h3>
                        <p>社团数量</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="stat-card">
                        <h3>1200</h3>
                        <p>注册会员</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="stat-card">
                        <h3>85</h3>
                        <p>活动次数</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="stat-card">
                        <h3>95%</h3>
                        <p>满意度</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 协会管理区域 -->
    <div class="content-area" id="societies">
        <div class="container">
            <h2 class="text-center" style="margin-bottom: 30px;">协会管理</h2>
            
            <!-- 整合mainIndex.jsp内容 -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">协会列表</h3>
                    <button type="button" class="btn btn-primary pull-right" onclick="showForm()">
                        <i class="fa fa-plus-square"></i>
                        申请协会
                    </button>
                </div>
                
                <div class="panel-body">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>协会名</th>
                                <th>创始人</th>
                                <th>简介</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- 这里可以动态加载协会数据 -->
                            <tr>
                                <td>1</td>
                                <td>计算机协会</td>
                                <td>张三</td>
                                <td>计算机技术交流与学习</td>
                                <td>2025-01-15</td>
                                <td>
                                    <button class="btn btn-sm btn-info">查看详情</button>
                                    <button class="btn btn-sm btn-warning">编辑</button>
                                    <button class="btn btn-sm btn-danger">删除</button>
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>篮球协会</td>
                                <td>李四</td>
                                <td>篮球运动推广与比赛组织</td>
                                <td>2025-02-20</td>
                                <td>
                                    <button class="btn btn-sm btn-info">查看详情</button>
                                    <button class="btn btn-sm btn-warning">编辑</button>
                                    <button class="btn btn-sm btn-danger">删除</button>
                                </td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>音乐协会</td>
                                <td>王五</td>
                                <td>音乐爱好者交流平台</td>
                                <td>2025-03-10</td>
                                <td>
                                    <button class="btn btn-sm btn-info">查看详情</button>
                                    <button class="btn btn-sm btn-warning">编辑</button>
                                    <button class="btn btn-sm btn-danger">删除</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- 最新活动 -->
    <div class="content-area" style="background-color: #f8f9fa;" id="activities">
        <div class="container">
            <h2 class="text-center" style="margin-bottom: 30px;">最新活动</h2>
            <div class="row">
                <div class="col-md-4">
                    <div class="society-card">
                        <h3>计算机编程大赛</h3>
                        <p><i class="fa fa-calendar"></i> 2025-12-20</p>
                        <p><i class="fa fa-map-marker"></i> 图书馆二楼报告厅</p>
                        <p>举办编程大赛，提高学生编程能力，选拔优秀人才。</p>
                        <button class="btn btn-primary btn-block">查看详情</button>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="society-card">
                        <h3>篮球友谊赛</h3>
                        <p><i class="fa fa-calendar"></i> 2025-12-25</p>
                        <p><i class="fa fa-map-marker"></i> 学校篮球场</p>
                        <p>各学院篮球队友谊赛，增进交流，提高球技。</p>
                        <button class="btn btn-primary btn-block">查看详情</button>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="society-card">
                        <h3>校园音乐节</h3>
                        <p><i class="fa fa-calendar"></i> 2026-01-05</p>
                        <p><i class="fa fa-map-marker"></i> 学校大礼堂</p>
                        <p>展示学生音乐才华，丰富校园文化生活。</p>
                        <button class="btn btn-primary btn-block">查看详情</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 页脚 -->
    <div class="footer">
        <div class="container">
            <p>&copy; 2025 学生协会管理系统. 版权所有.</p>
        </div>
    </div>

    <!-- 引入JavaScript资源 -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/scripts/klorofil-common.js"></script>
    <script>
        // 显示申请协会表单
        function showForm() {
            alert("申请协会功能开发中...");
        }
    </script>
</body>
</html>
