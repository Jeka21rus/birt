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

package org.eclipse.birt.chart.ui.swt;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

/**
 * 
 */

public class CustomPreviewTableDragListener extends DragSourceAdapter {

	private String strHeader;
	private CustomPreviewTable customTable;

	/**
	 * 
	 */
	public CustomPreviewTableDragListener(CustomPreviewTable customTable, String strHeader) {
		super();
		this.strHeader = strHeader;
		this.customTable = customTable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.
	 * DragSourceEvent)
	 */
	public void dragSetData(DragSourceEvent event) {
		event.data = strHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.
	 * DragSourceEvent)
	 */
	public void dragStart(DragSourceEvent event) {
		event.doit = (strHeader != null && strHeader.length() > 0);
	}

	public void dragFinished(DragSourceEvent event) {
		super.dragFinished(event);

		if (event.detail == DND.DROP_COPY) {
			// Reset column color
			for (int i = 0; i < customTable.getColumnNumber(); i++) {
				customTable.setColumnColor(i, ColorPalette.getInstance().getColor(customTable.getColumnHeading(i)));
			}
		}
	}

}
