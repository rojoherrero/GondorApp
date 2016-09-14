<%@ include file="/jsp/init.jsp"%>

<portlet:renderURL var="returnToMainViewURL">
	<portlet:param name="mvcPath" value="/jsp/view.jsp"/>	
</portlet:renderURL>

<h1>New Drug Form</h1>

<a href="${returnToMainViewURL}">Return to the main view</a>