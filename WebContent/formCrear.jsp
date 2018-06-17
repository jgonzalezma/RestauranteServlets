<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="navBar.html"></jsp:include>
<div class="container">
		<div class="row">
			<div class="col">
				<form action="AlmacenarHamburguesa" method="post">
					<strong>Nombre: <input type="text" name="nombre"/></strong><br><br>
					<strong>Precio: <input type="text" name="precio"/></strong><br><br>
					<strong>Fecha compra: <input type="text" name="fechaCompra" placeholder="yyyy-MM-dd"/></strong><br><br>
					<input class="btn btn-secondary" type="submit" value="guardar"/>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</html>