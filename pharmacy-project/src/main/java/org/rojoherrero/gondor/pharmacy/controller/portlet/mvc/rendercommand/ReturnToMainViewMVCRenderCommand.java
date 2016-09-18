package org.rojoherrero.gondor.pharmacy.controller.portlet.mvc.rendercommand;

import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

@Component(
	immediate = true,
	property={
		"javax.portlet.name=" + PharmacyPortletKeys.PHARMACY_PORTLET,
		"mvc.command.name=/return/main/view"
	},
	service = MVCRenderCommand.class
)
public class ReturnToMainViewMVCRenderCommand implements MVCRenderCommand {
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/jsp/view.jsp";
	}
	
	
}
