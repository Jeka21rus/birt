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

package org.eclipse.birt.chart.script.internal.attribute;

import org.eclipse.birt.chart.model.attribute.Text;
import org.eclipse.birt.chart.model.component.Label;
import org.eclipse.birt.chart.script.api.attribute.ILabel;
import org.eclipse.birt.chart.script.api.attribute.IText;
import org.eclipse.birt.chart.script.internal.ChartComponentUtil;

/**
 * 
 */

public class LabelImpl implements ILabel {

	private Label label;

	public LabelImpl(Label label) {
		this.label = label;
	}

	public IText getCaption() {
		Text caption = label.getCaption();
		if (caption == null) {
			caption = ChartComponentUtil.createEMFText();
			label.setCaption(caption);
		}
		return ChartComponentUtil.convertText(caption);
	}

	public boolean isVisible() {
		return label.isVisible();
	}

	public void setCaption(IText text) {
		label.setCaption(ChartComponentUtil.convertIText(text));

	}

	public void setVisible(boolean visible) {
		label.setVisible(visible);

	}

}
