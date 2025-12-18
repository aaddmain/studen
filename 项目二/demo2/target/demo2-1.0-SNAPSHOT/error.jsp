<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .error-container {
            max-width: 600px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        h1 {
            color: #d9534f;
        }
        p {
            color: #666;
        }
        .back-link {
            margin-top: 20px;
        }
        .back-link a {
            color: #337ab7;
            text-decoration: none;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>服务器内部错误</h1>
        <p>${error != null ? error : '发生了未知错误'}</p>
        <div class="back-link">
            <a href="javascript:history.back()">返回上一页</a> | 
            <a href="index.jsp">返回首页</a>
        </div>
    </div>
</body>
</html>