package com.rise.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MAsset;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.CLogger;
import org.compiere.util.Msg;

import com.rise.model.MRED_Asset_Transfer_Line;

public class AssetLocationCallout implements IColumnCallout {
	CLogger log = CLogger.getCLogger(AssetLocationCallout.class);
	private int param_A_Asset_ID = 0;


	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		log.warning("ColumnName : " + mField.getColumnName());

		if (mField.getColumnName().equals(MRED_Asset_Transfer_Line.COLUMNNAME_A_Asset_ID)) {
			if (value != null) {
				param_A_Asset_ID = (Integer) value;
			}
		}

		// Process locator from asset
		MAsset asset = new MAsset(ctx, param_A_Asset_ID, null);
		if (asset.getM_Locator_ID() == 0) {
			throw new AdempiereUserError(Msg.parseTranslation(ctx,
					"Please set location of the asset before using this process"));
		}

		mTab.setValue(MRED_Asset_Transfer_Line.COLUMNNAME_M_Locator_ID, asset.getM_Locator_ID());

	

		if (value != null) {
			log.warning("NewValue : " + value.toString());
		}

		if (oldValue != null) {
			log.warning("OldValue : " + oldValue.toString());
		}

		if (mTab != null) {
			log.warning("mTab : " + mTab.toString());
		}

		if (mField != null) {
			log.warning("mField : " + mField.toString());
		}

		return null;
	}
}
