<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Modification des Etudiants
</div>
<div class="card-body">
<form action="update.do" method="post">
<div  hidden class="form-group">
<label  class="control-label">ID Etudiant :</label>
<input type="text" name="id" class="form-control"
value="${etudiant.idEtudiant}"/>
</div>
<div class="form-group">
<label class="control-label">Nom Produit :</label>
 <input type="text" name="Nom" class="form-control"
value="${etudiant.nomEtudiant }"/>
 </div>
<div class="form-group">
<label class="control-label">Prenom Etudiant :</label>
<input type="text" name="prix" class="form-control" value="${etudiant.penomEtudiant}"/>
</div>

<div class="form-group">
<label class="control-label">Email Etudiant :</label>
<input type="text" name="prix" class="form-control" value="${etudiant.emailEtudiant}"/>
</div>
<div class="form-group">
 <select name="filiere" class="form-control">
 <option value="${etudiant.filiere.idFil}"
selected>${etudiant.filiere.nomFil}</option>
 <c:forEach items="${filModel.filieres}" var="cat">
 <c:if test="${fil.idFil != etudiant.filiere.idFil}">
 <option value="${fil.idFil}">${fil.nomFil}</option>
 </c:if>
 </c:forEach>
 </select>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>