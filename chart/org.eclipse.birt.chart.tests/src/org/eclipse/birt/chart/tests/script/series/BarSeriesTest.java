/*******************************************************************************
 * Copyright (c) 2006 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.chart.tests.script.series;

import org.eclipse.birt.chart.model.attribute.RiserType;
import org.eclipse.birt.chart.script.api.component.IValueSeries;
import org.eclipse.birt.chart.script.api.series.IBar;
import org.eclipse.birt.chart.script.api.series.data.ISimpleData;
import org.eclipse.birt.chart.tests.script.BaseChartTestCase;

/**
 * 
 */

public class BarSeriesTest extends BaseChartTestCase {

	public void testBarType() {
		IValueSeries series = getChartWithAxes().getValueSeries()[0][0];
		assertTrue(series instanceof IBar);
		assertEquals(((IBar) series).getBarType(), RiserType.RECTANGLE_LITERAL.getName());
		((IBar) series).setBarType(RiserType.CONE_LITERAL.getName());
		assertEquals(((IBar) series).getBarType(), RiserType.CONE_LITERAL.getName());
	}

	public void testGetDataExpr() {
		IValueSeries series = getChartWithAxes().getValueSeries()[0][0];
		assertTrue(series.getDataExpr() instanceof ISimpleData);
		assertEquals(((ISimpleData) series.getDataExpr()).getExpr(), "row[\"ORDERDATE\"]");

		((ISimpleData) series.getDataExpr()).setExpr("");
		assertEquals(((ISimpleData) series.getDataExpr()).getExpr(), "");
	}
}
