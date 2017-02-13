<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="serviciopersonas.service.PersonaLocalServiceUtil"%>
<%@page import="serviciopersonas.model.Persona"%>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="03_PersonaPortlet.caption"/></b>
</p>

<%
	String dni = ParamUtil.get(request, "dni", "");
	Persona p = PersonaLocalServiceUtil.getPersona(dni);
%>

<portlet:actionURL var="updatePersona" >
	<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="updatePersona"/>
</portlet:actionURL>

<aui:form action="${updatePersona}" method="post" name="name">
	<aui:input name="dni" type="text" label="DNI" value="<%=p.getDni() %>" />
	<aui:input name="nombre" type="text" label="Nombre" value="<%=p.getNombre()%>" />
	<aui:input name="edad" type="number" label="Edad" value="<%=p.getEdad()%>"/>
	<aui:button type="submit" value="Modificar" />
</aui:form>












