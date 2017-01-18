<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Alchemy Language API</title>

    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

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

    <h2>Alchemy Language API</h2>
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

    <div class="row">
        <c:if test="${results != null}">
            <h2 class="text-center">Results</h2>

            <div class="col-md-4">Entities</div>
            <div class="col-md-8">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Text</th>
                        <th>Relevance</th>
                        <th>Type</th>
                    </tr>
                    </thead>
                    <c:forEach items="${results.getEntities().getEntities()}" var="entity">
                        <tr>
                            <td>${entity.text}</td>
                            <td>${entity.relevance}</td>
                            <td>${entity.type}</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
            <hr/>
            <div class="col-md-4">Keywords</div>
            <div class="col-md-8">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Text</th>
                        <th>Relevance</th>
                    </tr>
                    </thead>
                    <c:forEach items="${results.getKeywords().getKeywords()}" var="keyword">
                    <tr>
                        <td>${keyword.text}</td>
                        <td>${keyword.relevance}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="col-md-4">Concepts</div>
            <div class="col-md-8">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Text</th>
                        <th>Relevance</th>
                    </tr>
                    </thead>
                    <c:forEach items="${results.getConcepts().getConcepts()}" var="concept">
                        <tr>
                            <td>${concept.text}</td>
                            <td>${concept.relevance}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="col-md-4">Relations</div>
            <div class="col-md-8">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Text</th>
                        <th>Sentence</th>
                    </tr>
                    </thead>
                    <c:forEach items="${results.getRelations().getRelations()}" var="relation">
                        <tr>
                            <td>${relation.subject.text}</td>
                            <td>${relation.sentence}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="col-md-4">Dates</div>
            <div class="col-md-8">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Text</th>
                        <th>Sentence</th>
                    </tr>
                    </thead>
                    <%--<c:forEach items="${results.getRelations().getRelations()}" var="relation">--%>
                        <tr>
                            <td>${results.getDates()}</td>
                        </tr>
                    <%--</c:forEach>--%>
                </table>
            </div>

        </c:if>
    </div>

</div>

</div>
<!-- /.container -->

<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
