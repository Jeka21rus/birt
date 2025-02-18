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

package org.eclipse.birt.report.designer.ui.views.attributes;

import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * The interface defines the control of Property MVC structure.It takes charge
 * of creating view and processes interactions between user & model.
 */
public interface IPropertyDescriptor {

	/**
	 * Creates UI widgets this IPropertyDescriptor represented.
	 * 
	 * @param parent The container control
	 * @return The Control object this IPropertyDescriptor represented.
	 */
	Control createControl(Composite parent);

	/**
	 * Gets the view part of Property MVC structure.
	 * 
	 * @return Control The Control instance stand for the view part.
	 */
	Control getControl();

	/**
	 * After selection changed,re-set UI data.
	 */
	void load();

	void save(Object obj) throws SemanticException;

	/**
	 * Set DE model List instance
	 * 
	 * @param handle The model List to set.
	 */
	void setInput(Object handle);

	void reset();
}