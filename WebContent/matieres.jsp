<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>vos matieres</title>
<style type="text/css">
<%@include file="./style/bootstrap.css" %>

h4{
color:white;
letter-spacing: 5px;
font-family: "Tekton Pro", serif;
font-size: 1.6em;
}
.article_title{
margin-top:10%;
}
</style>

</head>
<body>
<header class="header_page">
    <nav class="nav navbar-inverse" >
        <div class="container-fluid">
            <div class="navbar-header" >
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Bienvenue à E-school </a>
            </div>
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Professeur  <i><c:out value="${sessionScope.user}" /> </i></a></li>
                    <li><a href="${pageContext.request.contextPath}/" ><span class="glyphicon glyphicon-log-out">Déconnexion</span></a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container">
<div class="well article_title" style="background-color:lightblue;">
<h4><i>Liste de vos matiéres</i></h4>
<hr>
</div>

  <div class="row">
     <div class="col-lg-9">
        <table class="table table-hover">
           <tr>
           <th>Réf Matiere</th>
           <th>Description</th>
           <th>Volume horaire</th>
           <th>heures enseignées</th>
           <th></th>
           </tr>
           <c:forEach items="${matieres}" var="m">
           <tr>
           <td>${m.reference } </td>
           <td>${m.description }</td>
           <td>${m.volume }</td>
           <td>${m.heures }</td>
           <td><a href="${pageContext.request.contextPath}/del?ref=${m.reference}" class="btn btn-danger">Supprimer</a></td>
           </tr>
           </c:forEach>
        </table>
     </div>
  </div>
</div>
</body>
</html>