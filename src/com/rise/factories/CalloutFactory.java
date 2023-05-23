package com.rise.factories;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

import com.rise.callout.AssetLocationCallout;
import com.rise.model.MRED_Asset_Transfer_Line;
import com.rise.processes.TransferProcess;

public class CalloutFactory implements IColumnCalloutFactory, IProcessFactory{

	
	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {

		List<IColumnCallout> list = new ArrayList<IColumnCallout>();

		if (tableName.equalsIgnoreCase(MRED_Asset_Transfer_Line.Table_Name) && columnName.equalsIgnoreCase(MRED_Asset_Transfer_Line.COLUMNNAME_A_Asset_ID))
			list.add(new AssetLocationCallout());

		if (tableName.equalsIgnoreCase(MRED_Asset_Transfer_Line.Table_Name) && columnName.equalsIgnoreCase(MRED_Asset_Transfer_Line.COLUMNNAME_M_Locator_ID))
			list.add(new AssetLocationCallout());

		return list != null ? list.toArray(new IColumnCallout[0]) : new IColumnCallout[0];
	}

	@Override
	public ProcessCall newProcessInstance(String className) {
		
		if(className.equals("com.rise.callout.assetlocationcallout"))
			return new TransferProcess();
		return null;
		
	}

}
