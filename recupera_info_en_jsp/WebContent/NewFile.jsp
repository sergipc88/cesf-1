<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <form action="Controlador">
    <input type="text" name="cosa">
    <input type="submit" value="Añadir palabra">
    </form>
    
    <%= request.getAttribute("colchon") %>
    
    ${colchon}
    
    ${cositas}