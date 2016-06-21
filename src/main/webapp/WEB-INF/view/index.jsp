<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/static/img/favicon.ico">
    <title>菜单查看</title>
    <link href="/static/css/main.css" rel="stylesheet">
    <link href="/static/css/theme.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/static/css/dashboard.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>

    <!-- Bootstrap core JavaScript
  ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/static/js/jquery-2.1.1.min.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../static/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../static/js/ie10-viewport-bug-workaround.js"></script>
    <script src="/static/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/static/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">CEIT</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">菜单查看<span class="sr-only">(current)</span></a></li>
                <li><a href="static/pages/authority/authority.jsp">权限管理</a></li>
                <li><a href="#">角色管理</a></li>
                <li><a href="#">用户管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">项目类别管理</a></li>
                <li><a href="">项目管理</a></li>
                <li><a href="">比赛类别管理</a></li>
                <li><a href="">比赛管理</a></li>
                <li><a href="">证书管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">书籍类管理</a></li>
                <li><a href="">书籍管理</a></li>
                <li><a href="">设备类别管理</a></li>
                <li><a href="">设备管理</a></li>
                <li><a href="">技术网站类别管理</a></li>
                <li><a href="">技术网站管理</a></li>
                <li><a href="static/pages/account/account.jsp">账号管理</a></li>
                <li><a href="">工作室信息管理</a></li>
                <li><a href="">活动管理</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">菜单查看</h1>

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/1.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>权限</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/2.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>角色</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/1.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>用户</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/2.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>项目</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/2.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>比赛</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/1.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>证书</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/2.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>书籍</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/1.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>设备</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <a href="/ceit/account/list">
                    <div class="col-xs-6 col-sm-3 placeholder">
                        <img src="/static/img/1.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                        <div class="labels">
                            <h4>账号</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                    </div>
                </a>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/2.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>技术网站</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img src="/static/img/1.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                    <div class="labels">
                        <h4>活动</h4>
                        <span class="text-muted">Something else</span>
                    </div>
                </div>
                <a href="../ceitInfo.jsp">
                    <div class="col-xs-6 col-sm-3 placeholder">
                        <img src="/static/img/2.jpg" class="img-responsive" alt="Generic placeholder thumbnail">
                        <div class="labels">
                            <h4>测试</h4>
                            <span class="text-muted">Something else</span>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
