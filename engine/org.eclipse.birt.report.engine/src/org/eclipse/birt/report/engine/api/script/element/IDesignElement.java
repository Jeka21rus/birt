/*******************************************************************************
 * Copyright (c) 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.engine.api.script.element;

import org.eclipse.birt.report.engine.api.script.ScriptException;

/**
 * Script wrapper of DesignElementHandle
 * 
 */
public interface IDesignElement {

	/**
	 * Gets design element style.
	 * 
	 * @return style
	 */
	IScriptStyleDesign getStyle();

	/**
	 * Gets the name of this element. The returned element name will be the same as
	 * <CODE>getName()</CODE>, plus the namespace of the module that the elment is
	 * contained, if any. If the element is existed in the current module,this
	 * method and <CODE>getName()</CODE> will return identical results.
	 * 
	 * @return the qualified name of thie element.
	 */

	String getQualifiedName();

	/**
	 * Returns name of user property defined in this element.
	 * 
	 * @param name
	 * @return name of user property
	 */
	String getNamedExpression(String name);

	/**
	 * Sets name of user property defined in this element.
	 * 
	 * @param name name of user property
	 * @param exp  name expression
	 * @throws ScriptException
	 */

	void setNamedExpression(String name, String exp) throws ScriptException;

	/**
	 * Returns user property defined in this element.
	 * 
	 * @param name
	 * @return user property
	 * @deprecated
	 */

	@Deprecated
	Object getUserProperty(String name);

	/**
	 * Sets user property defined in this element.
	 * 
	 * @param name
	 * @param value
	 * @throws ScriptException
	 */
	void setUserProperty(String name, String value) throws ScriptException;

	/**
	 * Sets user property defined in this element.
	 * 
	 * @param name
	 * @param value
	 * @param type
	 * @throws ScriptException
	 */

	void setUserProperty(String name, Object value, String type) throws ScriptException;

	/**
	 * Return the parent of this element
	 * 
	 * @return the parent
	 */
	IDesignElement getParent();

	/**
	 * Gets the report.
	 * 
	 * @return the report
	 */
	IReportDesign getReport();

	/**
	 * Returns user property as an expression defined in this element.
	 * 
	 * @param name the user property name
	 * @return user property as an expression
	 */

	Object getUserPropertyExpression(String name);
}
