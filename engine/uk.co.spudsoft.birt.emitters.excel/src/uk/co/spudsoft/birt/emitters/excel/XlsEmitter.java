/*************************************************************************************
 * Copyright (c) 2011, 2012, 2013 James Talbut.
 *  jim-emitters@spudsoft.co.uk
 *  
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     James Talbut - Initial implementation.
 ************************************************************************************/

package uk.co.spudsoft.birt.emitters.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * XlsEmitter is the leaf class for implementing the ExcelEmitter with
 * HSSFWorkbook.
 * 
 * @author Jim Talbut
 *
 */
public class XlsEmitter extends ExcelEmitter {

	/**
	 */
	public XlsEmitter() {
		super(StyleManagerHUtils.getFactory());
		log.debug("Constructed XlsEmitter");
	}

	public String getOutputFormat() {
		return "xls";
	}

	protected Workbook createWorkbook() {
		return new HSSFWorkbook();
	}

	protected Workbook openWorkbook(File templateFile) throws IOException {
		InputStream stream = new FileInputStream(templateFile);
		try {
			return new HSSFWorkbook(stream);
		} finally {
			stream.close();
		}
	}

}
