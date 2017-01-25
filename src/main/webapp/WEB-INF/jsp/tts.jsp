<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19/01/2017
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Watson: Text to Speech</title>

    <link rel="stylesheet" type="text/css"
          href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Alchemy API</a>
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
            <form th:action="@{/text}" method="post" th:object="${text}">
                <label>Text</label>
                <div class="form-group">
                    <textarea class="form-control" placeholder="Enter text here" th:field="${text.getText()}" name="text" rows="10">${text.getText()}</textarea>
                    <p></p>
                    <button type="submit" class="btn btn-info pull-right">Submit</button>
                </div>

            </form>

        </div>
    </div>


</div>

    <div class="row">
        <div class="col-md-12">
            <audio controls>
                <source src="<c:url value="/${audio}" />" type="audio/wav">
                Your browser does not support the audio tag.
            </audio>
        </div>
    </div>

</div>
<!-- /.container -->

<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
