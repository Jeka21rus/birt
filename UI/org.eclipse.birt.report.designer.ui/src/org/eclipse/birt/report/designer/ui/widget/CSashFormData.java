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

package org.eclipse.birt.report.designer.ui.widget;

public class CSashFormData {
	public final static int NOT_SET = -1;
	long weight;
	int exactWidth;

	CSashFormData(int exactWidth) {
		this.weight = NOT_SET;
		this.exactWidth = exactWidth;
	}

	public CSashFormData() {
		this.exactWidth = NOT_SET;
	}

	String getName() {
		String string = getClass().getName();
		int index = string.lastIndexOf('.');
		if (index == -1)
			return string;
		return string.substring(index + 1, string.length());
	}

	/**
	 * Returns a string containing a concise, human-readable description of the
	 * receiver.
	 *
	 * @return a string representation of the event
	 */
	public String toString() {
		return getName() + " {weight=" + weight + "}"; //$NON-NLS-2$
	}
}