/***********************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Actuate Corporation - initial API and implementation
 ***********************************************************************/

package org.eclipse.birt.report.engine.layout;

/**
 * 
 * Represents all dynamic layout information, includes
 * <ul>
 * <li>maximum available width
 * <li>maximum available height
 * <li>current position in block direction
 * <li>current position in inline direction
 * <li>the X offset from border box start point to content box start point
 * <li>the Y offset from border box start point to content box start point
 * <li>flag identify is area object is ready
 * </ul>
 * 
 */
public interface ILayoutContext {

	/**
	 * get maximum available width in current line
	 * 
	 * @return
	 */
	public int getCurrentMaxContentWidth();

	public int getCurrentMaxContentHeight();

	/**
	 * get current positon in inline direction, the origin point is content box
	 * start point of container
	 * 
	 * @return
	 */
	public int getCurrentIP();

	public void setCurrentIP(int ip);

	/**
	 * get current positon in block direction, the origin point is content box start
	 * point of container
	 * 
	 * @return
	 */
	public int getCurrentBP();

	public void setCurrentBP(int bp);

	/**
	 * the X offset from border box start point to content box start point
	 */
	public int getOffsetX();

	public void setOffsetX(int x);

	/**
	 * the Y offset from border box start point to content box start point
	 */
	public int getOffsetY();

	public void setOffsetY(int y);

}
