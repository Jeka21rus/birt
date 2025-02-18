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

package org.eclipse.birt.report.model.api;

import java.net.URL;
import java.util.Map;

/**
 *
 */

interface IResourceLocatorBase {

	/**
	 * The host name of the fragments where inner resources are located.
	 */

	public final static String FRAGMENT_RESOURCE_HOST = "org.eclipse.birt.resources"; //$NON-NLS-1$

	/**
	 * The type of the images to search
	 */

	public final static int IMAGE = 1;

	/**
	 * The type of the libraries to search
	 */

	public final static int LIBRARY = 2;

	/**
	 * The type of the cascading style sheet to search.
	 */

	public final static int CASCADING_STYLE_SHEET = 3;

	/**
	 * The type for the jar file. Includes .jar type.
	 */

	public final static int JAR_FILE = 4;

	/**
	 * The type for the message file.
	 */

	public final static int MESSAGE_FILE = 5;

	/**
	 * The other types.
	 */

	public final static int OTHERS = 0;

	/**
	 * Key for the location to search in appContext.
	 */
	public final static String BIRT_RESOURCELOCATOR_SEARCH_LOCATION = "birtResourceLocatorSearchLocation"; //$NON-NLS-1$

	/**
	 * The location mask which searches in the file system with path.
	 */
	public final static int RESOURCE_FILEPATH = 0x01;
	/**
	 * The location mask which searches in the resource bundle.
	 */
	public final static int RESOURCE_BUNDLE = 0x02;
	/**
	 * The location mask which searches in the resource folder.
	 */
	public final static int RESOURCE_FOLDER = 0x04;
	/**
	 * The location mask which searches the file relative to design.
	 */
	public final static int RESOURCE_DESIGN = 0x08;

	/**
	 * Searches the file by the given file name. The actual search algorithm will be
	 * different in different environment. The file type is just helpful when
	 * different file searching steps for different files are required. Because new
	 * file type will be added if design file includes new file, the default
	 * searching steps are encouraged for unknown file type to improve robustness.
	 * 
	 * @param moduleHandle The module to tell the search context. This could be null
	 *                     if the search algorithm does not need the design. It can
	 *                     be the instance of one of <code>ReportDesignHandle</code>
	 *                     and <code>LibraryHandle</code>.
	 * @param fileName     The file name to be searched. This could be an absolute
	 *                     path or a relative path.
	 * @param type         The type of the file to search. The value must be one of
	 *                     <code>IMAGE</code>,<code>LIBRARY</code> ,
	 *                     <code>CASCADING_STYLE_SHEET</code> and
	 *                     <code>MESSAGEFILE</code>.
	 * @return The <code>URL</code> object. <code>null</code> if the file can not be
	 *         found.
	 */

	public URL findResource(ModuleHandle moduleHandle, String fileName, int type);

	/**
	 * Searches the file by the given file name and the given user's information.
	 * The actual search algorithm will be different in different environment. The
	 * file type is just helpful when different file searching steps for different
	 * files are required. Because new file type will be added if design file
	 * includes new file, the default searching steps are encouraged for unknown
	 * file type to improve robustness.
	 * 
	 * @param moduleHandle The module to tell the search context. This could be null
	 *                     if the search algorithm does not need the design. It can
	 *                     be the instance of one of <code>ReportDesignHandle</code>
	 *                     and <code>LibraryHandle</code>.
	 * @param fileName     The file name to be searched. This could be an absolute
	 *                     path or a relative path.
	 * @param type         The type of the file to search. The value must be one of
	 *                     <code>IMAGE</code>,<code>LIBRARY</code> ,
	 *                     <code>CASCADING_STYLE_SHEET</code> and
	 *                     <code>MESSAGEFILE</code>.
	 * @param appContext   The map containing the user's information
	 * @return The <code>URL</code> object. <code>null</code> if the file can not be
	 *         found.
	 */

	public URL findResource(ModuleHandle moduleHandle, String fileName, int type, Map appContext);

}
