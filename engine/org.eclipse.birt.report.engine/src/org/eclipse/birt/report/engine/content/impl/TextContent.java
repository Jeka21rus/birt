/***********************************************************************
 * Copyright (c) 2004, 2009 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Actuate Corporation - initial API and implementation
 ***********************************************************************/

package org.eclipse.birt.report.engine.content.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.util.IOUtil;
import org.eclipse.birt.report.engine.content.IContent;
import org.eclipse.birt.report.engine.content.IContentVisitor;
import org.eclipse.birt.report.engine.content.ITextContent;
import org.eclipse.birt.report.engine.ir.TextItemDesign;

public class TextContent extends AbstractContent implements ITextContent {

	protected String text;
	protected String textKey;
	protected String textType;

	TextContent(ITextContent textContent) {
		super(textContent);
		text = textContent.getText();
	}

	public int getContentType() {
		return TEXT_CONTENT;
	}

	TextContent(ReportContent report) {
		super(report);
	}

	TextContent(IContent content) {
		super(content);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.birt.report.engine.content.impl.AbstractContent#accept(org.
	 * eclipse.birt.report.engine.content.IContentVisitor)
	 */
	public Object accept(IContentVisitor visitor, Object value) throws BirtException {
		return visitor.visitText(this, value);
	}

	public void setTextKey(String key) {
		this.textKey = key;
	}

	public String getTextKey() {
		if (textKey != null) {
			return textKey;
		}
		if (generateBy instanceof TextItemDesign) {
			return ((TextItemDesign) generateBy).getTextKey();
		}
		return null;
	}

	public void setTextType(String type) {
		this.textType = type;
	}

	public String getTextType() {
		if (textType != null) {
			return textType;
		}
		if (generateBy instanceof TextItemDesign) {
			return ((TextItemDesign) generateBy).getTextType();
		}
		return null;
	}

	static final protected short FIELD_TEXT = 1100;

	protected void writeFields(DataOutputStream out) throws IOException {
		super.writeFields(out);
		if (text != null) {
			IOUtil.writeShort(out, FIELD_TEXT);
			IOUtil.writeString(out, text);
		}
	}

	protected void readField(int version, int filedId, DataInputStream in, ClassLoader loader) throws IOException {
		switch (filedId) {
		case FIELD_TEXT:
			text = IOUtil.readString(in);
			break;
		default:
			super.readField(version, filedId, in, loader);
		}
	}

	public boolean needSave() {
		if (text != null) {
			return true;
		}
		return super.needSave();
	}

	protected IContent cloneContent() {
		return new TextContent(this);
	}

}
