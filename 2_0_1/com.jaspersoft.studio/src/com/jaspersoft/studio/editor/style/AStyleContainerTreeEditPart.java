/*******************************************************************************
 * Copyright (C) 2010 - 2013 Jaspersoft Corporation. All rights reserved.
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
package com.jaspersoft.studio.editor.style;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;

import com.jaspersoft.studio.editor.style.editpolicy.JDStyleContainerEditPolicy;
import com.jaspersoft.studio.editor.style.editpolicy.JDStyleTreeContainerEditPolicy;
/*
 * The Class AContainerTreeEditPart.
 */
public class AStyleContainerTreeEditPart extends AStyleTreeEditPart {

	/**
	 * Creates and installs pertinent EditPolicies.
	 */
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new JDStyleContainerEditPolicy());
		installEditPolicy(EditPolicy.TREE_CONTAINER_ROLE, new JDStyleTreeContainerEditPolicy());
		// If this editpart is the contents of the viewer, then it is not deletable!
		if (getParent() instanceof RootEditPart)
			installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
	}
}
