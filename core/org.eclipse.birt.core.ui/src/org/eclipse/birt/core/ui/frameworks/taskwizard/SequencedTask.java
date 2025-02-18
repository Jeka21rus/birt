/***********************************************************************
 * Copyright (c) 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Actuate Corporation - initial API and implementation
 ***********************************************************************/

package org.eclipse.birt.core.ui.frameworks.taskwizard;

import java.util.Vector;

import org.eclipse.birt.core.ui.frameworks.taskwizard.interfaces.ITask;
import org.eclipse.birt.core.ui.frameworks.taskwizard.interfaces.IWizardContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.ibm.icu.util.ULocale;

/**
 * @deprecated For later use
 * 
 */
class SequencedTask implements ITask {

	private transient Vector subtasks = new Vector();
	protected transient IWizardContext context = null;
	protected transient WizardBase container = null;
	private transient int iCurrentSubtaskIndex = 0;
	private transient String sLabel = ""; //$NON-NLS-1$

	public SequencedTask(String sLabel) {
		this.sLabel = sLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.frameworks.taskwizard.interfaces.ITask#getUI(org.eclipse.swt
	 * .widgets.Composite)
	 */
	public Composite getUI(Composite parent) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDisplayLabel(ULocale locale) {
		return sLabel;
	}

	public void addSubtask(int iSubtaskIndex, ITask task) {
		if (subtasks.size() <= iSubtaskIndex) {
			subtasks.add(task);
		} else {
			subtasks.setElementAt(task, iSubtaskIndex);
		}
	}

	public void next() {
		// TODO: Switch to next subtask
		this.iCurrentSubtaskIndex++;
	}

	public void previous() {
		// TODO: Switch to previous subtask
		this.iCurrentSubtaskIndex--;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.frameworks.taskwizard.interfaces.ITask#setContext(org.
	 * eclipse.birt.frameworks.taskwizard.interfaces.IWizardContext)
	 */
	public void setContext(IWizardContext context) {
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.frameworks.taskwizard.interfaces.ITask#getContext()
	 */
	public IWizardContext getContext() {
		return this.context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.frameworks.taskwizard.interfaces.ITask#setUIProvider(org.
	 * eclipse.birt.frameworks.taskwizard.WizardBase)
	 */
	public void setUIProvider(WizardBase wizard) {
		this.container = wizard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.core.ui.frameworks.taskwizard.interfaces.ITask#getErrors()
	 */
	public String[] getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.birt.core.ui.frameworks.taskwizard.interfaces.ITask#setErrorHints
	 * (java.lang.Object[])
	 */
	public void setErrorHints(Object[] errorHints) {
		// TODO Auto-generated method stub

	}

	public String getDescription(ULocale locale) {
		return sLabel;
	}

	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public Control getControl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public void performHelp() {
		// TODO Auto-generated method stub

	}

	public void setDescription(String description) {
		// TODO Auto-generated method stub

	}

	public void setImageDescriptor(ImageDescriptor image) {
		// TODO Auto-generated method stub

	}

	public void setTitle(String title) {
		// TODO Auto-generated method stub

	}

	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub

	}
}