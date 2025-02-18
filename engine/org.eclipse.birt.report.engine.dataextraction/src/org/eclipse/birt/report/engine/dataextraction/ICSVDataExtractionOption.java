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

package org.eclipse.birt.report.engine.dataextraction;

/**
 * Extends Data Extraction options for CSV format
 * 
 */
public interface ICSVDataExtractionOption extends ICommonDataExtractionOption {
	public static final String SEPARATOR_PIPE = "|"; //$NON-NLS-1$
	public static final String SEPARATOR_COMMA = ","; //$NON-NLS-1$
	public static final String SEPARATOR_COLON = ":"; //$NON-NLS-1$
	public static final String SEPARATOR_SEMICOLON = ";"; //$NON-NLS-1$
	public static final String SEPARATOR_TAB = "\t"; //$NON-NLS-1$

	/**
	 * the separator
	 */
	public static final String OUTPUT_SEPARATOR = "Separator"; //$NON-NLS-1$

	/**
	 * the option checks if using CR + LF as the line separator.
	 */
	public static final String ADD_CR_LINE_BREAK = "AddCR";

	/**
	 * Sets the output separator
	 * 
	 * @param sep
	 */
	void setSeparator(String sep);

	/**
	 * Returns the output separator
	 * 
	 * @return String
	 */
	String getSeparator();

	boolean getAddCR();

	void setAddCR(boolean addCR);
}
