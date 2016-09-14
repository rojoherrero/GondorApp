package org.rojoherrero.gondor.pharmacy.controller.portlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletWebKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", 
		"javax.portlet.display-name=pharmacy-project Portlet",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/jsp/view.jsp",
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.name=" + PharmacyPortletWebKeys.PORTLET_NAME
	}, 
	service = Portlet.class
)
public class PharmacyPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(PharmacyPortlet.class);
	private static final String ROLES_LIST = "roles";
	private static final String REMOTE_USER = "user";

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			// here, I guess who is using the portlet
			User user = PortalUtil.getUser(renderRequest);
			List<Role> roles = getUserRoles(user);
			renderRequest.setAttribute(ROLES_LIST, roles);
			renderRequest.setAttribute(REMOTE_USER, user);

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.render(renderRequest, renderResponse);
	}

	private List<Role> getUserRoles(User user) throws PortalException {
		StringBuilder userRoles = new StringBuilder();
		List<Role> roles = null;
		if (Validator.isNotNull(user)) {
			roles = (List<Role>) RoleServiceUtil.getUserRoles(user.getUserId());
			userRoles.append(user.getFullName()).append(" has the following roles: ");
			/* 
			 * This iterator iterate through all the roles 
			 * of the user and appends it to the roles list
			 */
			for (Iterator<Role> iteratorRole = roles.iterator(); iteratorRole.hasNext();) {
				userRoles.append((String) iteratorRole.next().getName());
				userRoles.append((!iteratorRole.hasNext()) ? "." : ", ");
			}
		}
		_log.info(userRoles);
		return roles;
	}
}