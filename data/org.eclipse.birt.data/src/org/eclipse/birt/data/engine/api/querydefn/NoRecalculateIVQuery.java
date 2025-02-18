
/*******************************************************************************
 * Copyright (c) 2011 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/
package org.eclipse.birt.data.engine.api.querydefn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.birt.data.engine.api.IBaseQueryDefinition;
import org.eclipse.birt.data.engine.api.IBinding;
import org.eclipse.birt.data.engine.api.IFilterDefinition;
import org.eclipse.birt.data.engine.api.IQueryDefinition;
import org.eclipse.birt.data.engine.api.ISortDefinition;
import org.eclipse.birt.data.engine.core.DataException;

/**
 * Query Definition for optimizing IV.
 * <p>
 * The optimize query will only do no recalculate filtering based on the
 * previous query result set.
 * 
 */

public class NoRecalculateIVQuery extends QueryDefnDelegator {
	private IBaseQueryDefinition sourceQuery;
	private HashMap<String, IBinding> bindingsMap = new HashMap<String, IBinding>();
	private List<IFilterDefinition> filters;
	private List<ISortDefinition> sortings;
	private List groups;
	private String name;

	public NoRecalculateIVQuery(IQueryDefinition queryDefn, IBaseQueryDefinition sourceQuery,
			List<ISortDefinition> sorts, List<IFilterDefinition> filters, List groups, String queryResultId)
			throws DataException {
		super(queryDefn);
		this.queryResultsId = queryResultId;
		this.dataSetName = queryDefn.getDataSetName();
		this.sourceQuery = new QueryDefnDelegator(sourceQuery, this.queryResultsId, this.dataSetName);
		this.filters = filters;
		this.sortings = sorts;
		this.groups = groups;

		initBindings();
	}

	private void initBindings() throws DataException {
		Iterator<Map.Entry<String, IBinding>> it = baseQuery.getBindings().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, IBinding> e = it.next();
			IBinding b = e.getValue();

			Binding n = new Binding(b.getBindingName());
			n.setDataType(b.getDataType());
			n.setDisplayName(b.getDisplayName());
			n.setExportable(b.exportable());
			n.setFilter(b.getFilter());
			n.setTimeFunction(b.getTimeFunction());

			n.setExpression(new ScriptExpression("dataSetRow[\"" + b.getBindingName() + "\"]")); //$NON-NLS-1$//$NON-NLS-2$
			bindingsMap.put(n.getBindingName(), n);
		}
	}

	public List getGroups() {
		return groups;
	}

	public void addBinding(IBinding binding) throws DataException {
		this.bindingsMap.put(binding.getBindingName(), binding);
	}

	public Map getBindings() {
		return this.bindingsMap;
	}

	public List getFilters() {
		return filters;
	}

	public List getSorts() {
		return sortings;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public IBaseQueryDefinition getSourceQuery() {
		return sourceQuery;
	}

	public IQueryDefinition getBaseQuery() {
		return (IQueryDefinition) baseQuery;
	}

	public void setSourceQuery(IBaseQueryDefinition object) {
		sourceQuery = object;
	}

}
