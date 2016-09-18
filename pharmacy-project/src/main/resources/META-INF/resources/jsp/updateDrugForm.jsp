<%@ include file="/jsp/init.jsp"%>

<portlet:renderURL var="returnToMainViewURL">
	<portlet:param name="mvcRenderCommandName" value="/return/main/view"/>	
</portlet:renderURL>

<portlet:actionURL name="/drug/post/update_form" var="updateDrugFormURL" />

<h1>Update Drug Form</h1>

<aui:form action="${updateDrugFormURL}" method="post" name="updateDrugForm" >

</aui:form>
