package org.rojoherrero.gondor.pharmacy.controller.portlet.mvcrendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.rojoherrero.gondor.pharmacy.model.Drug;
import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletWebKeys;
import org.rojoherrero.gondor.pharmacy.service.DrugLocalServiceUtil;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

@Component(
	immediate=true,
	property={
		"mvc.command.name=/pharmacy/list/all-drugs",
		"javax.portlet.name=" + PharmacyPortletWebKeys.PORTLET_NAME
	},
	service=MVCRenderCommand.class
)
public class ListAllDrugsMVCRenderCommand implements MVCRenderCommand {

	private static final String ALL_DRUGS = "all_drugs";
	private static final int INITIAL_VALUE = 0;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		List<Drug> allDrugs = _handlerMVCRenderCommand(renderRequest);
		renderRequest.setAttribute(ALL_DRUGS, allDrugs);
		return "/jsp/all-drugs-list.jsp";
	}
	
	private List<Drug>_handlerMVCRenderCommand(RenderRequest renderRequest){
		return DrugLocalServiceUtil.getDrugs(INITIAL_VALUE, DrugLocalServiceUtil.getDrugsCount());
	}

}
