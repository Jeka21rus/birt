/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation. All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Actuate Corporation -
 * initial API and implementation
 ******************************************************************************/

package org.eclipse.birt.report.tests.model.regression;

import java.util.List;

import org.eclipse.birt.report.model.api.DesignFileException;
import org.eclipse.birt.report.tests.model.BaseTestCase;

/**
 * Regression description:
 * <p>
 * If i try to open the customers.rptdesign from the tutorial, i get the
 * following eclipse error...
 * <p>
 * Test description:
 * <p>
 * Open the example report, ensure that there won't be any parser or semantic
 * exceptions.
 * <p>
 */
public class Regression_96292 extends BaseTestCase {

	private final static String INPUT = "customers.rptdesign"; //$NON-NLS-1$

	/**
	 * @throws DesignFileException
	 */

	protected void setUp() throws Exception {
		super.setUp();
		removeResource();

		// retrieve two input files from tests-model.jar file
		copyResource_INPUT(INPUT, INPUT);

	}

	public void tearDown() {
		removeResource();
	}

	public void test_regression_96292() throws DesignFileException {
		openDesign(INPUT);
		List errors = designHandle.getErrorList();
		assertEquals(0, errors.size());
	}
}
