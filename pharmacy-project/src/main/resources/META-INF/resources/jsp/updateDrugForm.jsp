<%@ include file="/jsp/init.jsp"%>

<portlet:renderURL var="returnToMainViewURL">
	<portlet:param name="mvcRenderCommandName" value="/pharmacy/list/all_drugs"/>	
</portlet:renderURL>

<portlet:actionURL name="/drug/post/update_form" var="updateDrugFormURL" >
	<portlet:param name="drugId" value="${oldDrugData.drugId}"/>
	<portlet:param name="formerDrugType" value="${oldDrugData.drugType}"/>
	<portlet:param name="formerDrugQuantity" value="${oldDrugData.drugQuantity}"/>
	<portlet:param name="formerDrugName" value="${oldDrugData.drugName}" />
</portlet:actionURL>

<h1>Update Drug Form</h1>

<aui:form action="${updateDrugFormURL}" method="post" name="updateDrugForm" >
	<div>
		<aui:input name="drugName" type="text" label="Drug Name" />
		<p>Former value: ${oldDrugData.drugName}</p>
	</div>
	<div>
		<aui:input name="drugType" type="text" label="Drug Type"/>
		<p>Former value: ${oldDrugData.drugType}</p>
	</div>
	<div>
		<aui:input name="drugQuantity" type="number" label="Drug Quantity"/>
		<p>Former value: ${oldDrugData.drugQuantity}</p>
	</div>
	<div>
		<aui:button	type="submit"/>
		<aui:button	href="${returnToMainViewURL}" type="cancel"/>
	</div>
</aui:form>
