package org.rojoherrero.gondor.pharmacy.controller.portlet.mvc.actioncommand;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.rojoherrero.gondor.pharmacy.model.Drug;
import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletKeys;
import org.rojoherrero.gondor.pharmacy.service.DrugLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(
	immediate=true,
	property={
		"mvc.command.name=/pharmacy/add/new_drug",
		"javax.portlet.name=" + PharmacyPortletKeys.PHARMACY_PORTLET
	},
	service=MVCActionCommand.class	
)
public class AddNewDrugMVCActionCommand extends BaseMVCActionCommand {

	private static final String DRUG_QUANTITY = "drugQuantity";
	private static final String DRUG_TYPE = "drugType";
	private static final String SAVED_DRUG = "savedDrug";
	private static final String DRUG_NAME = "drugName";
	private static final String SUCCESS_FORM_VIEW = "/jsp/newDrugFormSuccess.jsp";
	private static final String MVC_PATH = "mvcPath";
	private static Log _log = LogFactoryUtil.getLog(AddNewDrugMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("Request recieved to create a new drug entity");
		Drug drug = _handlerMVCActionCommand(actionRequest);
		actionRequest.setAttribute(SAVED_DRUG, drug);
		actionResponse.setRenderParameter(MVC_PATH, SUCCESS_FORM_VIEW);

	}
	
	private Drug _handlerMVCActionCommand(ActionRequest request) throws PortalException{
		
		long drugId = CounterLocalServiceUtil.increment(Drug.class.getName());
		Drug drug = DrugLocalServiceUtil.createDrug(drugId);
		drug.setDrugName(ParamUtil.getString(request, DRUG_NAME));
		drug.setDrugQuantity(ParamUtil.getDouble(request, DRUG_QUANTITY));
		drug.setDrugType(ParamUtil.getString(request, DRUG_TYPE));
		drug.setUserId(PortalUtil.getUserId(request));
		drug.setGroupId(PortalUtil.getScopeGroupId(request));
		drug.setUserName(PortalUtil.getUser(request).getFullName());
		drug.setCreateDate(new Date());
		drug.setModifiedDate(new Date());
		_log.info(drug.toString());
		return DrugLocalServiceUtil.addDrug(drug);
	}

}
