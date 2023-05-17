package com.rise.processes;

import org.compiere.model.MProcessPara;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.Msg;

public class TransferProcess extends SvrProcess{
	private int param_A_Asset_ID = 0;		
	private int param_M_LocatorTo_ID = 0 ;	
	
	
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] paras = getParameter();
		for (ProcessInfoParameter para : paras) {
			String name = para.getParameterName();
			
			if (name.equals("A_Asset_ID"))
				param_A_Asset_ID = para.getParameterAsInt();
			else if(name.equals("M_LocatorTo_ID"))
				param_M_LocatorTo_ID = para.getParameterAsInt();
			else
				MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), para);
		}
		
	}

	@Override
	protected String doIt() throws Exception {
		if (param_A_Asset_ID == 0)
			throw new AdempiereUserError(Msg.parseTranslation(getCtx(), "@FillMandatory@ @A_Asset_ID@"));
		if (param_M_LocatorTo_ID == 0)
			throw new AdempiereUserError(Msg.parseTranslation(getCtx(), "@FillMandatory@ @param_A_Asset_ID@"));
		
		try {
			M_RED_Asset_Transfer assetTrans = new M_RED_Asset_Transfer(getCtx(), 0, get_TrxName());
			assetTrans.setA_Asset_ID(param_A_Asset_ID);
			assetTrans.setM_LocatorTo_ID(param_M_LocatorTo_ID);
			assetTrans.saveEx();
		} catch (Exception e) {
		}
		
		return "Asset Transfered";
	}

}