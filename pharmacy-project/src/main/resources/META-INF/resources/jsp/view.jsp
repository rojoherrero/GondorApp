<%@ include file="/jsp/init.jsp"%>

<h1>Welcome</h1>

<c:if test="${not empty roles}">
	<c:forEach var="role" items="${roles}">
		<p>${role.name} with id ${role.roleId}</p>
		<c:choose>
			<c:when test="${role.name == 'Administrator'}">
				
				<portlet:renderURL var="goToNewDrugFormURL">
					<portlet:param name="mvcPath" value="/jsp/newDrugForm.jsp"/>
				</portlet:renderURL>
				<a href="${goToNewDrugFormURL}">New drug form</a>
				
				<portlet:renderURL var="listAllDrugsURL">
					<portlet:param name="mvcRenderCommandName" value="/pharmacy/list/all_drugs"/>
				</portlet:renderURL>
				<a href="${listAllDrugsURL}">Go to the drugs management</a>
				
				</form>
			</c:when>
			<c:when test="${role.name == 'Power User'}">
				<p>Power User role</p>
			</c:when>
			<c:when test="${role.name == 'User'}">
				<p>User role</p>
			</c:when>
			<c:otherwise>
				<p>No Roles</p>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</c:if>

<p>This is just a trial for test a new functionality</p>
