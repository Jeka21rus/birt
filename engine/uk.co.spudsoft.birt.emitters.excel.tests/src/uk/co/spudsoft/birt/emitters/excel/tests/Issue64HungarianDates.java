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

package uk.co.spudsoft.birt.emitters.excel.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.eclipse.birt.core.exception.BirtException;
import org.junit.Test;

public class Issue64HungarianDates extends ReportRunner {

	@Test
	public void testThreeTablesNoNastinessPdfCheck() throws BirtException, IOException {

		InputStream inputStream = new FileInputStream(deriveFilepath("formatted_date_office2010_hungarian.xls"));
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			Cell cell = workbook.getSheetAt(0).getRow(0).getCell(0);
			System.out.println("Data format string = " + cell.getCellStyle().getDataFormatString());
		} finally {
			inputStream.close();
		}
	}
}
