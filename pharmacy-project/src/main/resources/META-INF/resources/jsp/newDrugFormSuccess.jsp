<%@ include file="/jsp/init.jsp"%>

<portlet:renderURL var="mainViewURL">
    <portlet:param name="mvcRenderCommandName" value="/jsp/view.jsp" />
</portlet:renderURL>

<h1>Congratulations</h1>
<a href="${mainViewURL}">Return to Main View</a>
<div>
	${savedDrug}
</div>
