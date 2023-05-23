package com.rise.processes;

import org.compiere.model.MAsset;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Msg;

public class GenerateAssetProcess extends SvrProcess {

	private int p_A_Asset_ID = 0;
	private int p_M_Location_ID = 0;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] params = getParameter();
		for (ProcessInfoParameter param : params) {
			String paramName = param.getParameterName();
			if (paramName.equals("A_Asset_ID")) {
				p_A_Asset_ID = param.getParameterAsInt();
			}
			if (paramName.equals("M_Location_ID")) {
				p_M_Location_ID = param.getParameterAsInt();
			}
			
			
		
		}
	}

	@Override
	protected String doIt() throws Exception {
		// Load the original asset
		MAsset originalAsset = new MAsset(getCtx(), p_A_Asset_ID, get_TrxName());

		// Create a new asset record
		MAsset newAsset = new MAsset(getCtx(), 0, get_TrxName());
		;
		newAsset.setAD_User_ID(Env.getAD_User_ID(getCtx())); // Set the user to the current user

		// Copy asset attributes from the existing asset to the new asset
		newAsset.setDescription(originalAsset.getDescription());
		newAsset.setA_Asset_Status(originalAsset.getA_Asset_Status());
		newAsset.setA_Asset_Type_ID(originalAsset.getA_Asset_Type_ID());
		newAsset.setAssetServiceDate(originalAsset.getAssetServiceDate());
		newAsset.setA_Depreciation_ID(originalAsset.getA_Depreciation_ID());
		newAsset.setIsOwned(originalAsset.isOwned());
		newAsset.setM_Locator_ID(p_M_Location_ID);
		newAsset.setName(originalAsset.getName() + "_");

		// Set the asset group
		if (originalAsset.getA_Asset_Group_ID() >= 0) {
			newAsset.setA_Asset_Group_ID(originalAsset.getA_Asset_Group_ID());
		} else {
			throw new Exception(Msg.getMsg(getCtx(), "AssetGroupMandatory"));
		}

		// Set the product
		if (originalAsset.getM_Product_ID() >= 0) {
			newAsset.setM_Product_ID(originalAsset.getM_Product_ID());
		} else {
			throw new Exception(Msg.getMsg(getCtx(), "ProductMandatory"));
		}

		// Save the new asset
		if (!newAsset.save()) {

			throw new Exception(Msg.getMsg(getCtx(), "FailedSaveAsset") + newAsset.get_ValueAsString("ProcessMsg"));
		}
		newAsset.saveEx();
		return Msg.getMsg(getCtx(), "Process Asset Created is successfully.");

	}
}
