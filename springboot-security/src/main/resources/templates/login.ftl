<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <!-- 使用bootstrap动画必须引入，动画依赖jquery -->
    <script src="/static/js/jquery-3.5.1.min.js"></script>
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <h1 class="text-center">登陆</h1>
        <div class="col-md-8 col-md-offset-2">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="">用户名</label>
                    <input type="text" name="username" id="username" class="form-control">
                </div>
                <div class="form-group">
                    <label for="">密码</label>
                    <input type="password" name="password" id="password" class="form-control">
                </div>
                <input type="submit" class="btn btn-success" name="login" id="login" value="登陆">
                <label id="error" style="color: red">
                    <#if RequestParameters['error']??>
                        用户名或密码错误
                    </#if>
                </label>
            </form>
        </div>
    </div>
</div>
</body>
</html>