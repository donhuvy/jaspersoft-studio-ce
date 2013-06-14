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
package com.jaspersoft.studio.model;

import com.jaspersoft.studio.model.dataset.MDatasetRun;

/**
 * Interface to specify if an element keep inside a dataset run (like table or crosstab)
 */
public interface IDatasetContainer {
	/**
	 * Return the dataset run of the element
	 */
	public MDatasetRun getDatasetRun();
}
