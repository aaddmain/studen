<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../common/up.jsp" %>

    <div class="panel">
        <div class="panel-heading">
            <span class="panel-title">协会举办活动</span>
        </div>
        <div class="panel-body">
            <form action="/activity/addActivity" method="post">
                协会ID（多个用逗号分隔）：<input type="text" class="form-control" name="activitySocietyId" placeholder="请输入协会ID" required><br>
                活动名：<input type="text" class="form-control" name="activityName" placeholder="请输入活动名称" required><br>
                活动介绍：<textarea class="form-control" name="activityIntro" placeholder="请输入活动介绍" required rows="3"></textarea><br>
                开始时间：<input type="datetime-local" class="form-control" name="activityStartTime" required/><br>
                结束时间：<input type="datetime-local" class="form-control" name="activityEndTime" required/><br>
                <input type="submit" class="btn btn-success" value="添加"/>
            </form>
        </div>
        <script>
            let msg = "";
            if (msg == 1){
                alert("添加成功")
            }
        </script>
    </div>

<%@include file="../common/down.jsp" %>
