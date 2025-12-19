<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生协会管理系统 - 注册</title>
    <!-- 引入CSS资源 -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/demo.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <style>
        /* 重置样式 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        /* 修复乱码问题 */
        body {
            font-family: 'Source Sans Pro', 'Microsoft YaHei', sans-serif;
            font-size: 14px;
            line-height: 1.5;
            color: #333;
            background-color: #f5f5f5;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }
        
        /* 自定义注册页面样式，与登录页面保持一致 */
        .login-container {
            display: flex;
            height: 80vh;
            width: 90vw;
            max-width: 1200px;
            margin: 10vh auto;
            overflow: hidden;
            border-radius: 8px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
        }
        
        /* 优化页面比例，左侧表单占40%，右侧背景占60% */
        .login-form {
            flex: 0 0 40%;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #ffffff;
            padding: 0 40px;
        }
        
        .login-form-box {
            width: 100%;
            max-width: 400px;
        }

        .login-form h2 {
            font-family: 'Source Sans Pro', 'Microsoft YaHei', sans-serif;
            font-size: 24px;
            font-weight: 600;
            margin-bottom: 30px;
            color: #333;
            text-align: center;
        }

        .login-form .form-group {
            margin-bottom: 20px;
        }

        .login-form .form-control {
            padding: 15px;
            font-size: 14px;
            border: 1px solid #eaeaea;
            border-radius: 3px;
            box-shadow: none;
            transition: all 0.3s ease;
            background-color: #fafafa;
            width: 100%; /* 增加此行以确保输入框占满父容器 */
        }
        
        .login-form .form-control:focus {
            border-color: #00AAFF;
            box-shadow: 0 0 5px rgba(0, 170, 255, 0.3);
            background-color: #ffffff;
        }
        
        .login-form .btn-primary {
            background-color: #00AAFF;
            border: none;
            padding: 15px;
            font-size: 16px;
            font-weight: 600;
            border-radius: 3px;
            margin-top: 15px;
            transition: all 0.3s ease;
            width: 100%;
        }
        
        .login-form .btn-primary:hover, .login-form .btn-primary:focus {
            background-color: #0099e6;
            box-shadow: 0 2px 8px rgba(0, 170, 255, 0.4);
        }
        
        /* 注册链接样式 */
        .register-link {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
            color: #666;
        }
        
        .register-link a {
            color: #00AAFF;
            text-decoration: none;
            transition: color 0.3s ease;
        }
        
        .register-link a:hover {
            color: #0099e6;
            text-decoration: underline;
        }
        
        /* 优化右侧背景区域，占60%宽度 */
        .login-bg {
            flex: 0 0 60%;
            background-image: url('assets/img/login-bg.jpg');
            background-size: cover;
            background-position: center;
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        
        .login-bg::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: rgba(0, 170, 255, 0.8);
            transition: background-color 0.3s ease;
        }
        
        .login-bg-content {
            position: relative;
            z-index: 1;
            text-align: center;
            color: #ffffff;
            padding: 0 40px;
        }
        
        .login-bg-content h1 {
            font-size: 36px;
            font-weight: 300;
            margin-bottom: 15px;
            line-height: 1.2;
        }
        
        .login-bg-content p {
            font-size: 18px;
            font-weight: 300;
            margin: 0;
            opacity: 0.9;
        }
        
        /* 增强响应式设计 */
        @media (max-width: 1024px) {
            .login-container {
                height: 85vh;
                width: 95vw;
            }
            
            .login-form {
                flex: 0 0 50%;
            }
            
            .login-bg {
                flex: 0 0 50%;
            }
        }
        
        @media (max-width: 768px) {
            .login-container {
                flex-direction: column;
                height: auto;
                margin: 5vh auto;
            }
            
            .login-bg {
                flex: 0 0 25vh;
                height: 25vh;
            }
            
            .login-form {
                flex: 0 0 auto;
                padding: 30px;
            }
            
            .login-bg-content h1 {
                font-size: 28px;
            }
            
            .login-bg-content p {
                font-size: 16px;
            }
        }
        
        @media (max-width: 480px) {
            .login-container {
                width: 95vw;
                margin: 3vh auto;
            }
            
            .login-form {
                padding: 20px;
            }
            
            .login-form h2 {
                font-size: 20px;
                margin-bottom: 20px;
            }
            
            .login-form .form-control {
                padding: 12px;
            }
            
            .login-bg-content h1 {
                font-size: 24px;
            }
        }
        
        /* 添加加载动画效果 */
        .login-form .btn-primary:active {
            transform: translateY(1px);
        }
        
        /* 优化表单输入框的placeholder样式 */
        ::-webkit-input-placeholder {
            color: #999 !important;
        }
        
        :-moz-placeholder {
            color: #999 !important;
        }
        
        ::-moz-placeholder {
            color: #999 !important;
        }
        
        :-ms-input-placeholder {
            color: #999 !important;
        }
        
        /* 优化select下拉框样式 */
        select.form-control {
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            background-image: url('data:image/svg+xml;charset=utf8,%3Csvg xmlns=\'http://www.w3.org/2000/svg\' viewBox=\'0 0 4 5\'%3E%3Cpath fill=\'%23333\' d=\'M2 0L0 2h4zm0 5L0 3h4z\'/%3E%3C/svg%3E');
            background-repeat: no-repeat;
            background-position: right 15px center;
            background-size: 8px 10px;
            padding-right: 30px;
        }
    </style>
</head>
<body class="fullscreen-bg">
    <div class="login-container">
        <!-- 左侧注册表单 -->
        <div class="login-form">
            <div class="login-form-box">
                <h2>学生协会管理系统</h2>
                <%-- 显示错误信息 --%>
                <% String errorMsg = (String) request.getAttribute("errorMsg");
                   if (errorMsg != null) { %>
                    <div style="color: red; margin-bottom: 15px; text-align: center;">
                        <%= errorMsg %>
                    </div>
                <% } %>
                <form action="register" method="post" accept-charset="UTF-8">
                    <div class="form-group">
                        <input type="text" class="form-control" name="studentNumber" placeholder="学号" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="studentName" placeholder="姓名" required>
                    </div>
                    <div class="form-group">
                        <select class="form-control" name="gender" required>
                            <option value="">请选择性别</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" name="birthday" required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="密码" required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="confirmPassword" placeholder="确认密码" required>
                    </div>
                    <button type="submit" class="btn btn-primary">注册</button>
                    <div class="register-link">
                        <p>已有账号? <a href="login.jsp">立即登录</a></p>
                    </div>
                </form>
            </div>
        </div>
        
        <!-- 右侧背景图片 -->
        <div class="login-bg">
            <div class="login-bg-content">
                <h1>学生协会管理系统</h1>
                <p>STUDENT ASSOCIATION SYSTEM</p>
            </div>
        </div>
    </div>

    <!-- 引入JavaScript资源 -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/scripts/klorofil-common.js"></script>
</body>
</html>