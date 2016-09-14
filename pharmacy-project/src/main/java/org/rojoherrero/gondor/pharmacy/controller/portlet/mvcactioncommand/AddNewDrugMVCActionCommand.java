package org.rojoherrero.gondor.pharmacy.controller.portlet.mvcactioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.rojoherrero.gondor.pharmacy.portlet.constants.PharmacyPortletWebKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

@Component(
	immediate=true,
	property={
		"mvc.command.name=/pharmacy/add/new-drug",
		"javax.portlet.name=" + PharmacyPortletWebKeys.PORTLET_NAME
	},
	service=MVCActionCommand.class	
)
public class AddNewDrugMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub

	}

}
