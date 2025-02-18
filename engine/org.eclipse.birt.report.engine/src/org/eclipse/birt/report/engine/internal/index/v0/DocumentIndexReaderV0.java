/*******************************************************************************
 * Copyright (c) 2008 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.engine.internal.index.v0;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.birt.core.archive.IDocArchiveReader;
import org.eclipse.birt.core.archive.RAInputStream;
import org.eclipse.birt.core.util.IOUtil;
import org.eclipse.birt.report.engine.api.impl.ReportDocumentConstants;
import org.eclipse.birt.report.engine.content.impl.BookmarkContent;
import org.eclipse.birt.report.engine.internal.index.IDocumentIndexReader;
import org.eclipse.birt.report.engine.toc.TOCBuilder;

public class DocumentIndexReaderV0 implements IDocumentIndexReader, ReportDocumentConstants {

	IDocArchiveReader archive;
	HashMap<String, Long> bookmarks;
	HashMap<String, Long> reportlets;
	HashMap<String, Long> pageNumbers;

	public DocumentIndexReaderV0(IDocArchiveReader archive) throws IOException {
		this.archive = archive;
	}

	public int getVersion() {
		return VERSION_0;
	}

	public void close() {
	}

	private HashMap<String, Long> loadIndexStream(IDocArchiveReader archive, String streamName) throws IOException {
		HashMap<String, Long> map = new HashMap<String, Long>();
		RAInputStream in = archive.getStream(streamName);
		try {
			DataInputStream di = new DataInputStream(in);
			long count = IOUtil.readLong(di);
			for (long i = 0; i < count; i++) {
				String key = IOUtil.readString(di);
				long offset = IOUtil.readLong(di);
				map.put(key, new Long(offset));
			}
		} finally {
			in.close();
		}
		return map;
	}

	public long getOffsetOfBookmark(String bookmark) throws IOException {
		if (bookmarks == null) {
			bookmarks = loadIndexStream(archive, REPORTLET_BOOKMARK_INDEX_STREAM);
		}
		if (bookmarks != null) {
			Long offset = bookmarks.get(bookmark);
			if (offset != null) {
				return offset.longValue();
			}
		}
		return -1;
	}

	public long getOffsetOfInstance(String instanceId) throws IOException {
		if (reportlets == null) {
			reportlets = loadIndexStream(archive, REPORTLET_ID_INDEX_STREAM);
		}
		if (reportlets != null) {
			Long offset = reportlets.get(instanceId);
			if (offset != null) {
				return offset.longValue();
			}
		}
		return -1;
	}

	public long getPageOfBookmark(String bookmark) throws IOException {
		if (pageNumbers == null) {
			pageNumbers = loadIndexStream(archive, BOOKMARK_STREAM);
		}
		if (pageNumbers != null) {
			Long offset = pageNumbers.get(bookmark);
			if (offset != null) {
				return offset.longValue();
			}
		}
		return -1;
	}

	public List<String> getBookmarks() throws IOException {
		if (pageNumbers == null) {
			pageNumbers = loadIndexStream(archive, BOOKMARK_STREAM);
		}
		if (pageNumbers != null) {
			ArrayList<String> list = new ArrayList<String>();
			for (String bookmark : pageNumbers.keySet()) {
				if (bookmark != null && !bookmark.startsWith(TOCBuilder.TOC_PREFIX)) {
					list.add(bookmark);
				}
			}
			return list;
		}
		return null;
	}

	public BookmarkContent getBookmark(String bookmark) {
		return null;
	}

	public List<BookmarkContent> getBookmarkContents() throws IOException {
		return null;
	}
}
