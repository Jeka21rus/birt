
/*******************************************************************************
 * Copyright (c) 2004, 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/
package org.eclipse.birt.data.engine.executor.cache;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.birt.data.engine.binding.MultiplePassTest;

/**
 * 
 */

public class CachedMultiplePassTest extends MultiplePassTest {
	protected Map getAppContext() {
		Map appContext = new HashMap();
		appContext.put("birt.data.engine.test.memcachesize", "20000");
		return appContext;
	}
}
