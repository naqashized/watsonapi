<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19/01/2017
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Watson: Text to Speech</title>

    <link rel="stylesheet" type="text/css"
          href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <spring:url value="/css/main.css" var="springCss" />
    <link rel="stylesheet" type="text/css"
          href="/css/recorder.css" />
    <link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Watson API</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <h2>Watson API</h2>
    <div class="row">
        <div class="col-md-12">
            <div id="controls">
                <img id="record" src="/images/mic128.png" onclick="toggleRecording(this);">
                <%--<a id="save" href="#"><img src="/images/save.svg"></a>--%>
            </div>

        </div>
    </div>
    <div class="row">
    <h1>Result will be show here:</h1>
    <h2 id="result"></h2>
    </div>

</div>
<!-- /.container -->
<%--<form method="post" action="/" enctype="multipart/form-data">--%>

    <%--<input type="file" id="file" name="audio">--%>

    <%--<button type="submit">Convert</button>--%>

<%--</form>--%>

<script src="/js/audiodisplay.js"></script>
<script src="/js/recorder.js"></script>
<script src="/js/main.js"></script>
<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
