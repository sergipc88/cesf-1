<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<s:form>				
	<s:textfield label="Introduce el titulo" name="libro.titulo" value="%{libro.titulo}"/>
	<s:textfield label="Introduce el precio" name="libro.precio" value="%{libro.precio}"/>
<s:hidden name="libro.id" value="%{libro.id}"/>
	<s:submit action="modificar" value="modificar"/>
		<s:submit action="borrar" value="borrar"/>
	
</s:form>


</body>
</html>