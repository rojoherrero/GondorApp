package org.rojoherrero.gondor.pharmacy.controller.portlet.mvc.actioncommand;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.rojoherrero.gondor.pharmacy.model.Drug;
import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletKeys;
import org.rojoherrero.gondor.pharmacy.service.DrugLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	immediate = true,
	property = {
		"mvc.command.name=/drug/post/update_form",
		"javax.portlet.name=" + PharmacyPortletKeys.PHARMACY_PORTLET
	}
	,service = MVCActionCommand.class)
public class UpdateDrugMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_handlerMVCActionCommand(actionRequest);
		actionResponse.setRenderParameter("mvcPath", "/jsp/newDrugFormSuccess.jsp");
	}
	
	private boolean _handlerMVCActionCommand(ActionRequest actionRequest){
		boolean success = false;
		long drugId = ParamUtil.getLong(actionRequest, "drugId");
		try {
			Drug drug = DrugLocalServiceUtil.getDrug(drugId);
			drug.setDrugQuantity(getNewDrugQuantity(actionRequest));
			drug.setDrugName(getNewDrugName(actionRequest));
			drug.setDrugType(getNewDrugType(actionRequest));				
			drug.setModifiedDate(new Date());
			DrugLocalServiceUtil.updateDrug(drug);
			success = true;
			
		} catch (PortalException e) {
			e.printStackTrace();
			
		}
		return success;
	}

	private String getNewDrugType(ActionRequest actionRequest) {
		String formerType = ParamUtil.getString(actionRequest, "formerDrugType");
		return ParamUtil.get(actionRequest, "drugType", formerType);
	}

	private String getNewDrugName(ActionRequest actionRequest) {
		String formerName = ParamUtil.getString(actionRequest, "formerDrugName");
		return ParamUtil.get(actionRequest, "drugName", formerName);
	}

	private double getNewDrugQuantity(ActionRequest actionRequest) {
		double formerQuantity = ParamUtil.getDouble(actionRequest, "formerDrugQuantity");
		return ParamUtil.get(actionRequest, "drugQuantity", formerQuantity);
	}

}
