package com.rise.document;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.compiere.acct.Doc;
import org.compiere.acct.Fact;
import org.compiere.model.MAcctSchema;

public class Doc_REDAssetTransfer extends Doc{

	public Doc_REDAssetTransfer(MAcctSchema as, Class<?> clazz, ResultSet rs, String defaultDocumentType,
			String trxName) {
		super(as, clazz, rs, defaultDocumentType, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String loadDocumentDetails() {
		log.warning("---------------------------------------------------");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBalance() {
		// TODO Auto-generated method stub
		return BigDecimal.ZERO;
		}

	@Override
	public ArrayList<Fact> createFacts(MAcctSchema as) {
		ArrayList<Fact> facts = new ArrayList<Fact>();
		return facts;
	}

}
