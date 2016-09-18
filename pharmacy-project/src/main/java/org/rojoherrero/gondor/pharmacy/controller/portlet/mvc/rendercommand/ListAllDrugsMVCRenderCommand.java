package org.rojoherrero.gondor.pharmacy.controller.portlet.mvc.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.rojoherrero.gondor.pharmacy.model.Drug;
import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletKeys;
import org.rojoherrero.gondor.pharmacy.service.DrugLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

@Component(
	immediate=true,
	property={
		"mvc.command.name=/pharmacy/list/all_drugs",
		"javax.portlet.name=" + PharmacyPortletKeys.PHARMACY_PORTLET
	},
	service=MVCRenderCommand.class
)
public class ListAllDrugsMVCRenderCommand implements MVCRenderCommand {

	private static Log _log = LogFactoryUtil.getLog(ListAllDrugsMVCRenderCommand.class);
	private static final String ALL_DRUGS = "all_drugs";
	private static final int INITIAL_VALUE = 0;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_log.info("Request recieved to retrieve all the availables dugs");
		List<Drug> allDrugs = DrugLocalServiceUtil
				.getDrugs(INITIAL_VALUE, DrugLocalServiceUtil.getDrugsCount());
		renderRequest.setAttribute(ALL_DRUGS, allDrugs);
		_log.info("All available drugs send to /jsp/all-drugs-list.jsp");
		return "/jsp/all-drugs-list.jsp";
	}
}
