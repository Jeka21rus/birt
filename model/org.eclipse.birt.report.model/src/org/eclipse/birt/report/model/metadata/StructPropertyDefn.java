/*******************************************************************************
* Copyright (c) 2004 Actuate Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Actuate Corporation  - initial API and implementation
*******************************************************************************/

package org.eclipse.birt.report.model.metadata;

/**
 * Represents the definition of a member of a property structure.
 * 
 */

public class StructPropertyDefn extends PropertyDefn {

	/**
	 * Default constructor.
	 */

	public StructPropertyDefn() {
	}

	/**
	 * Constructs a member definition given the name, its type and the display name
	 * id.
	 * 
	 * @param theName  the member name
	 * @param typeDefn the member type given as a property type
	 * @param id       the message ID for the display name
	 */

	public StructPropertyDefn(String theName, PropertyType typeDefn, String id) {
		name = theName;
		type = typeDefn;
		displayNameID = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.design.metadata.ValueDefn#getValueType()
	 */

	public int getValueType() {
		return SYSTEM_PROPERTY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.model.metadata.PropertyDefn#isStructureMember()
	 */
	public boolean isStructureMember() {
		return true;
	}
}
