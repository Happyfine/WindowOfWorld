<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>待审核通过</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/bootstrap-v2.1.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="../../Webapp/assets/css/theme.css">
    <link rel="stylesheet" href="../../Webapp/assets/font-awesome/css/font-awesome.css">

    <script src="../../Webapp/assets/js/jquery.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../../Webapp/assets/ico/favicon.ico">
    
  </head>

  <body class="http-error"> 
  <!--<![endif]-->
    


    

    
        <div class="row-fluid">
    <div class="http-error">
        <div class="http-error-message">
            <div class="error-caption">
                <p>您的注册请求还未审核通过!</p>
            </div>
            <div class="error-message">
                <p>请等待其他管理员审核.<p>
                <p class="return-home"><a href="../../Webapp/admin/sign-in.jsp">返回登录页</a></p>
            </div>
        </div>
    </div>
</div>





    


    <script src="../../Webapp/assets/bootstrap-v2.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


