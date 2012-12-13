/*******************************************************************************
 * Copyright (C) 2010 - 2012 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 * 
 * Unless you have purchased a commercial license agreement from Jaspersoft, 
 * the following license terms apply:
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Jaspersoft Studio Team - initial API and implementation
 ******************************************************************************/
package com.jaspersoft.studio.server.wizard.resource.page.runit;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.jaspersoft.jasperserver.api.metadata.xml.domain.impl.ResourceDescriptor;
import com.jaspersoft.studio.model.ANode;
import com.jaspersoft.studio.server.messages.Messages;
import com.jaspersoft.studio.server.model.MResource;
import com.jaspersoft.studio.server.wizard.resource.APageContent;
import com.jaspersoft.studio.server.wizard.resource.page.QueryPageContent;
import com.jaspersoft.studio.server.wizard.resource.page.selector.SelectorJrxml;

public class ReportUnitQueryContent extends APageContent {

	public ReportUnitQueryContent(ANode parent, MResource resource,
			DataBindingContext bindingContext) {
		super(parent, resource, bindingContext);
	}

	public ReportUnitQueryContent(ANode parent, MResource resource) {
		super(parent, resource);
	}

	@Override
	public String getName() {
		return Messages.RDReportUnitPage_reportunit;
	}

	@Override
	public String getPageName() {
		return "com.jaspersoft.studio.server.page.runit.query";
	}

	@Override
	public boolean isPageComplete() {
		if (res != null)
			return SelectorJrxml.getMainReport(res.getValue()) != null;
		return false;
	}

	@Override
	public Control createContent(Composite parent) {
		ResourceDescriptor rd = res.getValue();
		for (Object obj : rd.getChildren()) {
			ResourceDescriptor r = (ResourceDescriptor) obj;
			if (r.getWsType().equals(ResourceDescriptor.TYPE_QUERY)) {
				return QueryPageContent.createContentComposite(parent,
						bindingContext, r);
			}
		}
		return null;
	}

	public static boolean hasTypeQuery(MResource res) {
		ResourceDescriptor rd = res.getValue();
		for (Object obj : rd.getChildren()) {
			ResourceDescriptor r = (ResourceDescriptor) obj;
			if (r.getWsType().equals(ResourceDescriptor.TYPE_QUERY))
				return true;
		}
		return false;
	}
}
