<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controlador" id="formulario">
	<table>
	<tr>
	<th>Título</th>
	<th>Precio</th>
	<th>Operación</th>
	</tr>
		<c:forEach var="libro" items="${libros}">
			<tr>
				<td><input type="text" name="titulo" id="titulo${libro.id}" value="<c:out value="${libro.titulo}" />"></td>
					<td><input type="text" name="precio" id="precio${libro.id}" value="<c:out value="${libro.precio}" />"></td>
			
			<td><input type="button"  value="modificar" onclick="modificar(${libro.id})">

<input type="button"  value="borrar" onclick="borrar(${libro.id})"></td>
			</tr>
		</c:forEach>
<tr>
<td><input type="text" name="tituloAlta"></td>
<td><input type="text" name="precioAlta"></td>


<td><input type="submit" value="Dar de alta"></td>
</tr>
	</table>
	<input type="hidden" name="action" id="actionGuay" value="alta">
	<input type="hidden" id="idDelLibroABorrar" name="idDelLibroABorrar" >
		<input type="hidden" id="precioLibro" name="precioLibro" >
	
		<input type="hidden" id="tituloLibro" name="tituloLibro" >
	
	</form>
	<script>
	function borrar(identificador){
		document.getElementById("actionGuay").value="borrar";
		document.getElementById("idDelLibroABorrar").value=identificador;
		document.getElementById("formulario").submit()
	}
	function modificar(identificador){
		document.getElementById("actionGuay").value="modificar"
		
		
			document.getElementById("idDelLibroABorrar").value=identificador;
		document.getElementById("precioLibro").value=	document.getElementById("precio"+identificador).value;
		document.getElementById("tituloLibro").value=	document.getElementById("titulo"+identificador).value;
	
			document.getElementById("formulario").submit()

	}
	</script>
	
</body>
</html>