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

package org.eclipse.birt.report.designer.internal.ui.views.attributes.widget;

import org.eclipse.birt.report.designer.internal.ui.swt.custom.FormWidgetFactory;
import org.eclipse.birt.report.designer.internal.ui.util.ExceptionHandler;
import org.eclipse.birt.report.designer.internal.ui.views.attributes.page.WidgetUtil;
import org.eclipse.birt.report.designer.internal.ui.views.attributes.provider.ComboPropertyDescriptorProvider;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * ComboPropertyDescriptor manages Combo choice control.
 */
public class RadioGroupPropertyDescriptor extends PropertyDescriptor {

	protected String oldValue;

	public RadioGroupPropertyDescriptor(boolean formStyle) {
		setFormStyle(formStyle);
	}

	public void setInput(Object handle) {
		this.input = handle;
		getDescriptorProvider().setInput(input);
	}

	private Composite composite;

	private Button[] choices = new Button[0];

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.ui.attributes.widget.PropertyDescriptor
	 * #resetUIData()
	 */
	void refresh(String value) {
		String displayName = ((ComboPropertyDescriptorProvider) getDescriptorProvider()).getDisplayName(value);
		displayName = displayName != null ? displayName : value;
		for (int i = 0; i < choices.length; i++) {
			if (choices[i].getText().equals(displayName)) {
				choices[i].setSelection(true);
			} else {
				choices[i].setSelection(false);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.internal.ui.views.attributes.widget.
	 * PropertyDescriptor#getControl()
	 */
	public Control getControl() {
		return composite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.designer.ui.extensions.IPropertyDescriptor#
	 * createControl(org.eclipse.swt.widgets.Composite)
	 */
	public Control createControl(Composite parent) {
		if (isFormStyle()) {
			composite = FormWidgetFactory.getInstance().createComposite(parent, SWT.NONE);
		} else {
			composite = new Composite(parent, SWT.NONE);
		}

		if (getDescriptorProvider() instanceof ComboPropertyDescriptorProvider) {
			ComboPropertyDescriptorProvider provider = (ComboPropertyDescriptorProvider) getDescriptorProvider();
			String[] items = provider.getItems();
			GridLayout layout = new GridLayout();
			layout.numColumns = items.length;
			composite.setLayout(layout);

			choices = new Button[items.length];

			for (int i = 0; i < items.length; i++) {
				if (isFormStyle()) {
					choices[i] = FormWidgetFactory.getInstance().createButton(composite, items[i], SWT.RADIO);
				} else {
					choices[i] = new Button(composite, SWT.RADIO);
					choices[i].setText(items[i]);
				}

				final Button button = choices[i];
				choices[i].addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent e) {
						try {
							if (button.getSelection())
								save(button.getText());
						} catch (SemanticException e1) {
							for (int i = 0; i < choices.length; i++) {
								if (choices[i].getText().equals(oldValue)) {
									choices[i].setSelection(true);
								} else {
									choices[i].setSelection(false);
								}
							}
							ExceptionHandler.handle(e1);
						}
					}
				});
			}
		}

		return composite;
	}

	public void save(Object value) throws SemanticException {
		descriptorProvider.save(value);
	}

	public void setHidden(boolean isHidden) {
		WidgetUtil.setExcludeGridData(composite, isHidden);
	}

	public void setVisible(boolean isVisible) {
		composite.setVisible(isVisible);
	}

	public void load() {
		oldValue = getDescriptorProvider().load().toString();
		refresh(oldValue);
	}
}