<%@ include file="/jsp/init.jsp"%>

<portlet:renderURL var="returnToMainViewURL">
	<portlet:param name="mvcRenderCommandName" value="/return/main/view"/>	
</portlet:renderURL>

<h1>New Drug Form</h1>

<portlet:actionURL name="/pharmacy/add/new_drug" var="addNewDrugURL" />

<aui:form action="${addNewDrugURL}" method="post" name="new_drug_form" >
	<aui:input name="drugName" type="text" label="Drug Name" />
	<aui:input name="drugType" type="text" label="Drug Type"/>
	<aui:input name="drugQuantity" type="number" label="Drug Quantity"/>
	<aui:button	type="submit"/>
	<aui:button	href="${returnToMainViewURL}" type="cancel"/>
</aui:form>
