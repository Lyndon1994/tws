<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wuhul
  Date: 2016/3/27
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>TWS</title>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="robots" content=""/>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" media="all"/>
    <!--[if IE]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie.css" media="all"/><![endif]-->
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/lt-ie-9.css" media="all"/><![endif]-->
</head>
<body class="login">
<section>
    <h1><strong>TWS</strong></h1>
    <div class="green"><s:actionmessage/></div>
    <form method="post" action="login">
        <input type="text" value="name" name="name"/>
        <input value="Password" type="password" name="password"/>
        <button class="blue" type="submit">Login</button>
    </form>
    <p><a href="#">Forgot your password?</a></p>
</section>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
    // Page load delay by Curtis Henson - http://curtishenson.com/articles/quick-tip-delay-page-loading-with-jquery/
    $(function () {
        $('.login button').click(function (e) {
            // Get the url of the link
            var toLoad = $(this).attr('href');

            // Do some stuff
            $(this).addClass("loading");

            // Stop doing stuff
            // Wait 700ms before loading the url
            setTimeout(function () {
                window.location = toLoad
            }, 10000);

            // Don't let the link do its natural thing
            e.preventDefault
        });

        $('input').each(function () {

            var default_value = this.value;

            $(this).focus(function () {
                if (this.value == default_value) {
                    this.value = '';
                }
            });

            $(this).blur(function () {
                if (this.value == '') {
                    this.value = default_value;
                }
            });

        });
    });
</script>
</body>
</html>