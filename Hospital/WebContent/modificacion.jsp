<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Controlador" id="formulario">
<input type="text" name="nombre" value="${paciente.nombre}">
<input type="text" name="apellido" value="${paciente.apellidos}">
<input type="date" name="fecha" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${paciente.fecha}" />">
<input type="hidden" name="id_paciente" value="${paciente.id}">
<input type="hidden" name="action" id="action" value="modificacion">
<input type="submit" value="enviar">


<input type="button" value="borrar" onclick="cambiarAction()">
</form>

		

<script type="text/javascript">
function cambiarAction(){
        document.getElementById("action").value="borrar";
        document.getElementById("formulario").submit();
}
</script>
		

	


</body>
</html>