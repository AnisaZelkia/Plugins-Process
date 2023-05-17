/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package com.rise.processes;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for RED_Asset_Transfer
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="RED_Asset_Transfer")
public class X_RED_Asset_Transfer extends PO implements I_RED_Asset_Transfer, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230517L;

    /** Standard Constructor */
    public X_RED_Asset_Transfer (Properties ctx, int RED_Asset_Transfer_ID, String trxName)
    {
      super (ctx, RED_Asset_Transfer_ID, trxName);
      /** if (RED_Asset_Transfer_ID == 0)
        {
			setA_Asset_ID (0);
			setM_Locator_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RED_Asset_Transfer (Properties ctx, int RED_Asset_Transfer_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, RED_Asset_Transfer_ID, trxName, virtualColumns);
      /** if (RED_Asset_Transfer_ID == 0)
        {
			setA_Asset_ID (0);
			setM_Locator_ID (0);
        } */
    }

    /** Load Constructor */
    public X_RED_Asset_Transfer (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_RED_Asset_Transfer[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_A_Asset getA_Asset() throws RuntimeException
	{
		return (org.compiere.model.I_A_Asset)MTable.get(getCtx(), org.compiere.model.I_A_Asset.Table_ID)
			.getPO(getA_Asset_ID(), get_TrxName());
	}

	/** Set Asset.
		@param A_Asset_ID Asset used internally or by customers
	*/
	public void setA_Asset_ID (int A_Asset_ID)
	{
		if (A_Asset_ID < 1)
			set_ValueNoCheck (COLUMNNAME_A_Asset_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_A_Asset_ID, Integer.valueOf(A_Asset_ID));
	}

	/** Get Asset.
		@return Asset used internally or by customers
	  */
	public int getA_Asset_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Comment/Help.
		@param Help Comment or Hint
	*/
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp()
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	public I_M_Locator getM_Locator() throws RuntimeException
	{
		return (I_M_Locator)MTable.get(getCtx(), I_M_Locator.Table_ID)
			.getPO(getM_Locator_ID(), get_TrxName());
	}

	/** Set Locator.
		@param M_Locator_ID Warehouse Locator
	*/
	public void setM_Locator_ID (int M_Locator_ID)
	{
		if (M_Locator_ID < 1)
			set_ValueNoCheck (COLUMNNAME_M_Locator_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_M_Locator_ID, Integer.valueOf(M_Locator_ID));
	}

	/** Get Locator.
		@return Warehouse Locator
	  */
	public int getM_Locator_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Locator_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_M_Locator getM_LocatorTo() throws RuntimeException
	{
		return (I_M_Locator)MTable.get(getCtx(), I_M_Locator.Table_ID)
			.getPO(getM_LocatorTo_ID(), get_TrxName());
	}

	/** Set Locator To.
		@param M_LocatorTo_ID Location inventory is moved to
	*/
	public void setM_LocatorTo_ID (int M_LocatorTo_ID)
	{
		if (M_LocatorTo_ID < 1)
			set_ValueNoCheck (COLUMNNAME_M_LocatorTo_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_M_LocatorTo_ID, Integer.valueOf(M_LocatorTo_ID));
	}

	/** Get Locator To.
		@return Location inventory is moved to
	  */
	public int getM_LocatorTo_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_LocatorTo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set RED_Asset_Transfer_ID.
		@param RED_Asset_Transfer_ID RED_Asset_Transfer_ID
	*/
	public void setRED_Asset_Transfer_ID (int RED_Asset_Transfer_ID)
	{
		if (RED_Asset_Transfer_ID < 1)
			set_ValueNoCheck (COLUMNNAME_RED_Asset_Transfer_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_RED_Asset_Transfer_ID, Integer.valueOf(RED_Asset_Transfer_ID));
	}

	/** Get RED_Asset_Transfer_ID.
		@return RED_Asset_Transfer_ID	  */
	public int getRED_Asset_Transfer_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RED_Asset_Transfer_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set RED_Asset_Transfer_UU.
		@param RED_Asset_Transfer_UU RED_Asset_Transfer_UU
	*/
	public void setRED_Asset_Transfer_UU (String RED_Asset_Transfer_UU)
	{
		set_ValueNoCheck (COLUMNNAME_RED_Asset_Transfer_UU, RED_Asset_Transfer_UU);
	}

	/** Get RED_Asset_Transfer_UU.
		@return RED_Asset_Transfer_UU	  */
	public String getRED_Asset_Transfer_UU()
	{
		return (String)get_Value(COLUMNNAME_RED_Asset_Transfer_UU);
	}
}