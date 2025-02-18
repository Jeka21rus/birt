/*******************************************************************************
 * Copyright (c) 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *  IBM Corporation  - Bidi direction of text
 *******************************************************************************/

package org.eclipse.birt.sample.reportitem.rotatedtext;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.report.engine.extension.IRowSet;
import org.eclipse.birt.report.engine.extension.ReportItemPresentationBase;
import org.eclipse.birt.report.model.api.ExtendedItemHandle;
import org.eclipse.birt.report.model.api.extension.ExtendedElementException;
import org.eclipse.birt.sample.reportitem.rotatedtext.util.SwingGraphicsUtil;

/**
 * RotatedTextPresentationImpl
 */
public class RotatedTextPresentationImpl extends ReportItemPresentationBase {

	private RotatedTextItem textItem;

	public void setModelObject(ExtendedItemHandle modelHandle) {
		try {
			textItem = (RotatedTextItem) modelHandle.getReportItem();
		} catch (ExtendedElementException e) {
			e.printStackTrace();
		}
	}

	public int getOutputType() {
		return OUTPUT_AS_IMAGE;
	}

	public Object onRowSets(IRowSet[] rowSets) throws BirtException {
		if (textItem == null) {
			return null;
		}

		int angle = textItem.getRotationAngle();
		String text = textItem.getText();

		BufferedImage rotatedImage = SwingGraphicsUtil.createRotatedTextImage(text, angle, new Font("Default", 0, 12)); //$NON-NLS-1$

		ByteArrayInputStream bis = null;

		try {
			ImageIO.setUseCache(false);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			ImageOutputStream ios = ImageIO.createImageOutputStream(baos);

			ImageIO.write(rotatedImage, "png", ios); //$NON-NLS-1$
			ios.flush();
			ios.close();

			bis = new ByteArrayInputStream(baos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bis;

	}

}
