package org.rojoherrero.gondor.pharmacy.controller.portlet.mvc.actioncommand;

import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.rojoherrero.gondor.pharmacy.service.DrugLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PharmacyPortletKeys.PHARMACY_PORTLET,
		"mvc.command.name=/pharmacy/drug/delete"
	},
	service = MVCActionCommand.class
)
public class DeleteDrugMVCActionCommand extends BaseMVCActionCommand {
	
	private static Log _log = LogFactoryUtil.getLog(DeleteDrugMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long drugId = ParamUtil.getLong(actionRequest, "drugId");
		boolean result = _handlerMVCActionCommand(drugId);
		String message = "Drug successfuly removed";
		if (result == false) {
			message="Something gone wrong";
		}
		actionRequest.setAttribute("message", message);
		actionResponse.setRenderParameter("mvcPath", "/jsp/newDrugFormSuccess.jsp");
	}
	
	private boolean _handlerMVCActionCommand(long drugId){
		StringBuilder sb = new StringBuilder();
		boolean result;
		try {
			DrugLocalServiceUtil.deleteDrug(drugId);
			sb.append("Drug with id ").append(Long.toString(drugId)).append(" has been removed from DB");
			_log.info(sb);
			result = true;
		} catch (PortalException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}	
}
