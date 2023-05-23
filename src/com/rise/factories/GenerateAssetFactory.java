package com.rise.factories;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

import com.rise.processes.GenerateAssetProcess;

public class GenerateAssetFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		if(className.equals("com.rise.processes.generateassetprocess"))
			return new GenerateAssetProcess();
		return null;
	}

}
