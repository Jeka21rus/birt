/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.designer.core.commands;

import org.eclipse.birt.report.designer.core.DesignerConstants;
import org.eclipse.birt.report.designer.core.model.schematic.HandleAdapterFactory;
import org.eclipse.birt.report.designer.core.model.schematic.TableHandleAdapter;
import org.eclipse.birt.report.designer.util.DEUtil;
import org.eclipse.birt.report.model.api.DesignElementHandle;
import org.eclipse.birt.report.model.api.GridHandle;
import org.eclipse.birt.report.model.api.RowHandle;
import org.eclipse.birt.report.model.api.TableHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.gef.commands.Command;

/**
 * This command deletes an object from the RowHandle.
 * 
 */
public class DeleteRowCommand extends Command {

	private RowHandle handle = null;

	/**
	 * Deletes the command
	 * 
	 * @param model the model
	 */

	public DeleteRowCommand(Object model) {
		assert model instanceof RowHandle;
		this.handle = (RowHandle) model;
	}

	/**
	 * Executes the Command. This method should not be called if the Command is not
	 * executable.
	 */

	public void execute() {
		if (getTableParent() != null) {
			if (DesignerConstants.TRACING_COMMANDS) {
				System.out.println("DeleteRowCommand >> starts. Target: " //$NON-NLS-1$
						+ DEUtil.getDisplayLabel(getTableParent()));
			}
			TableHandleAdapter tableHandle = HandleAdapterFactory.getInstance().getTableHandleAdapter(getTableParent());

			int rowNumber = HandleAdapterFactory.getInstance().getRowHandleAdapter(handle).getRowNumber();

			try {
				tableHandle.deleteRow(new int[] { rowNumber });
				if (DesignerConstants.TRACING_COMMANDS) {
					System.out.println("DeleteRowCommand >> Finished. "); //$NON-NLS-1$
				}
			} catch (SemanticException e) {
				if (DesignerConstants.TRACING_COMMANDS) {
					System.out.println("DeleteRowCommand >> Failed. "); //$NON-NLS-1$
				}
			}
		}
	}

	/**
	 * Get the parent table
	 * 
	 * @return Return the parent table
	 */
	private Object getTableParent() {
		DesignElementHandle parent = handle.getContainer();
		while (parent != null) {
			if (parent instanceof TableHandle || parent instanceof GridHandle) {
				return parent;
			}
			parent = parent.getContainer();
		}
		return null;
	}

	/**
	 * Check whether the command can be executed or not
	 * 
	 * @return true or false
	 */
	public boolean canExecute() {
		return super.canExecute() && handle.canDrop();
	}
}
