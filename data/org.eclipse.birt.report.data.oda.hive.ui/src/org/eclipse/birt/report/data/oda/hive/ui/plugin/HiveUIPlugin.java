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
package org.eclipse.birt.report.data.oda.hive.ui.plugin;

import org.eclipse.core.runtime.Plugin;

/**
 *
 */
public class HiveUIPlugin extends Plugin {

	// The shared instance.
	private static HiveUIPlugin plugin;

	public HiveUIPlugin() {
		super();
		plugin = this;
	}

	public static HiveUIPlugin getDefault() {
		return plugin;
	}
}
