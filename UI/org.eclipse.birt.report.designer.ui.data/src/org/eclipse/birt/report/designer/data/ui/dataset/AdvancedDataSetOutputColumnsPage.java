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

package org.eclipse.birt.report.designer.data.ui.dataset;

import org.eclipse.birt.report.model.api.DataSetHandle;

public class AdvancedDataSetOutputColumnsPage extends OutputColumnsPage {

	public AdvancedDataSetOutputColumnsPage() {
		super();
	}

	public AdvancedDataSetOutputColumnsPage(DataSetHandle ds, boolean newlyCreated) {
		super();
		isNewlyCreated = newlyCreated;
	}
}
