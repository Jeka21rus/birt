/*******************************************************************************
 * Copyright (c) 2004, 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.data.oda.xml.util;

import org.eclipse.datatools.connectivity.oda.OdaException;

/**
 * This class is used to dealing with the strings which are parsed as arguments
 * to create an XML data source connection.The structure of string must follow
 * the given rule:
 * TableName1#:#[TableRootPath]#:#{columnName1;Type;RelativeXPath},{columnName2;Type;RelativeXPath}...
 * #-#TableName2#:#[TableRootPath]#:#{columnName1;Type;RelativeXpath}.....
 * 
 * @deprecated Please use DTP xml driver
 */
public class RelationInformation extends org.eclipse.datatools.enablement.oda.xml.util.RelationInformation {
	/**
	 * 
	 * @param relationString
	 * @throws OdaException
	 */
	public RelationInformation(String relationString) throws OdaException {
		super(relationString);
	}
}