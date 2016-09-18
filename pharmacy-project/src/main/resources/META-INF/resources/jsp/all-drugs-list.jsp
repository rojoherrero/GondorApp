<%@ include file="/jsp/init.jsp"%>

<portlet:renderURL var="returnToMainViewURL">
	<portlet:param name="mvcRenderCommandName" value="/return/main/view"/>	
</portlet:renderURL>

<h1>All Available Drugs</h1>

<table>
	<thead>
		<tr>
			<th>Added by</th>
			<th>Created on</th>
			<th>Modified on</th>
			<th>Drug name</th>
			<th>Drug type</th>
			<th>Drug quantity</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="drug" items="${all_drugs}">
			<portlet:actionURL name="/pharmacy/drug/delete" var="deleteDrugURL" >
				<portlet:param name="drugId" value="${drug.drugId}" />
			</portlet:actionURL>
			
			<portlet:renderURL var="updateDrugURL">
				<portlet:param name="drugId" value="${drug.drugId}" />
				<portlet:param name="mvcRenderCommandName" value="/drug/get/update_form" />
			</portlet:renderURL>
			<tr>
				<td>${drug.userName}</td>
				<td>${drug.createDate}</td>
				<td>${drug.modifiedDate}</td>
				<td>${drug.drugName}</td>
				<td>${drug.drugType}</td>
				<td>${drug.drugQuantity}</td>
				<td>
					<a href="${deleteDrugURL}">Delete this drug</a>
					<br/>
					<a href="${updateDrugURL}">Update Drug</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="${returnToMainViewURL}">Return to Main View</a>