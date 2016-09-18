<%@ include file="/jsp/init.jsp"%>

<portlet:renderURL var="returnToMainViewURL">
	<portlet:param name="mvcRenderCommandName" value="/return/main/view"/>	
</portlet:renderURL>

<h1>Congratulations</h1>
<a href="${returnToMainViewURL}">Return to Main View</a>

<c:choose>
	<c:when test="${not empty savedDrug}">
		<p>${savedDrug}</p>
	</c:when>
	<c:when test="${not empty message}">
		<p>${message}</p>
	</c:when>
	<c:when test="${fromUpdate == true}">
		<p>${drugQuantity}</p>
		<p>${drugName}</p>
		<p>${drugType}</p>
	</c:when>
	<c:otherwise>
		<p>Nothing to say</p>
	</c:otherwise>
</c:choose>

