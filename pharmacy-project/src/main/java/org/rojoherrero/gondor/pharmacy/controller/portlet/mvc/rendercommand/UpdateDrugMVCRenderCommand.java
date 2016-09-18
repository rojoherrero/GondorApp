package org.rojoherrero.gondor.pharmacy.controller.portlet.mvc.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.rojoherrero.gondor.pharmacy.model.Drug;
import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletKeys;
import org.rojoherrero.gondor.pharmacy.service.DrugLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	immediate = true,
	property={
		"javax.portlet.name=" + PharmacyPortletKeys.PHARMACY_PORTLET,
		"mvc.command.name=/drug/get/update_form"
	},
	service=MVCRenderCommand.class
)
public class UpdateDrugMVCRenderCommand implements MVCRenderCommand {

	private static Log _log = LogFactoryUtil.getLog(UpdateDrugMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		StringBuilder sb = new StringBuilder();
		long drugId = ParamUtil.getLong(renderRequest, "drugId");
		sb.append("Drug with id: ").append(Long.toString(drugId)).append(" send to update");
		_log.info(sb);
		try {
			Drug drug = DrugLocalServiceUtil.getDrug(drugId);
			renderRequest.setAttribute("oldDrugData", drug);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/updateDrugForm.jsp";
	}
}
