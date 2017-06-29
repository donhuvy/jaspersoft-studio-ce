/*******************************************************************************
 * Copyright (C) 2005 - 2014 TIBCO Software Inc. All rights reserved. http://www.jaspersoft.com.
 * 
 * Unless you have purchased a commercial license agreement from Jaspersoft, the following license terms apply:
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package com.jaspersoft.studio.editor.preview.actions;

import org.eclipse.jface.action.Action;

import com.jaspersoft.studio.editor.preview.MultiPageContainer;

public abstract class ASwitchAction extends Action {
	protected MultiPageContainer container;
	protected String viewKey;

	public ASwitchAction(MultiPageContainer container, String view) {
		super(view);
		this.container = container;
		this.viewKey = view;
	}

	public ASwitchAction(MultiPageContainer container, String view, int style) {
		super(view, style);
		this.container = container;
		this.viewKey = view;
	}

	@Override
	public void run() {
		if (viewKey != null) {
			container.switchView(viewKey);
		}
	}
}
