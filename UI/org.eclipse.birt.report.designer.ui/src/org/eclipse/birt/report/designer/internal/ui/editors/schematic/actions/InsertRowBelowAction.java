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

package org.eclipse.birt.report.designer.internal.ui.editors.schematic.actions;

import java.util.logging.Level;

import org.eclipse.birt.report.designer.internal.ui.command.CommandUtils;
import org.eclipse.birt.report.designer.internal.ui.command.ICommandParameterNameContants;
import org.eclipse.birt.report.designer.nls.Messages;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Action to insert one row below the selected row.
 */
public class InsertRowBelowAction extends InsertRowAction {

	private static final String ACTION_MSG_ROW_BELOW = Messages.getString("InsertRowBelowAction.actionMsg.rowBelow"); //$NON-NLS-1$

	/** action ID */
	public static final String ID = "org.eclipse.birt.report.designer.internal.ui.editors.schematic.actions.InsertRowBelowAction"; //$NON-NLS-1$

	/**
	 * Constructs new instance.
	 * 
	 * @param part current work bench part
	 */
	public InsertRowBelowAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText(ACTION_MSG_ROW_BELOW);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	protected boolean calculateEnabled() {
		return super.calculateEnabled();
	}

	/**
	 * Runs action.
	 * 
	 */
	public void run() {

		CommandUtils.setVariable(ICommandParameterNameContants.INSERT_ROW_POSITION, Integer.valueOf(1));

		try {
			CommandUtils.executeCommand("org.eclipse.birt.report.designer.ui.command.insertRowCommand", null); //$NON-NLS-1$
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}