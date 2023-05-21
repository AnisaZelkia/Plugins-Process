package com.rise.factories;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

import com.rise.processes.TransferProcess;

public class TransferProsesFactory implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		
		if(className.equals("com.rise.processes.transferprocess"))
			return new TransferProcess();
		return null;
	}

	
}
