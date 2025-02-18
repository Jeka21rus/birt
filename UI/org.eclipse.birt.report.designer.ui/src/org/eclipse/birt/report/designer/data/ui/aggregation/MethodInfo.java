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

package org.eclipse.birt.report.designer.data.ui.aggregation;

/**
 * Represents the method information for both class and element. The class
 * includes the argument list, return type, and whether this method is static or
 * constructor,
 */

public class MethodInfo extends org.eclipse.birt.report.model.api.metadata.MethodInfo {

	public MethodInfo(boolean isConstructor) {
		super(isConstructor);
	}

	/**
	 * Adds an optional argument list to the method information.
	 * 
	 * @param argumentList an optional argument list
	 * 
	 */

	protected void addArgumentList(ArgumentInfoList argumentList) {
		super.addArgumentList(argumentList);
	}

	/**
	 * Sets the script type for return.
	 * 
	 * @param returnType the script type to set
	 */

	protected void setReturnType(String returnType) {
		super.setReturnType(returnType);
	}

	/**
	 * Sets whether this method is static.
	 * 
	 * @param isStatic true if this method is static
	 */

	protected void setStatic(boolean isStatic) {
		super.setStatic(isStatic);
	}

	/**
	 * Sets the internal name of the property.
	 * 
	 * @param theName the internal property name
	 */

	protected void setName(String theName) {
		super.setName(theName);
	}

	/**
	 * Sets the resource key for display name.
	 * 
	 * @param displayNameKey the resource key to set
	 */

	protected void setDisplayNameKey(String displayNameKey) {
		super.setDisplayNameKey(displayNameKey);
	}

}