/*******************************************************************************
 * Copyright (C) 2010 - 2013 Jaspersoft Corporation. All rights reserved. http://www.jaspersoft.com
 * 
 * Unless you have purchased a commercial license agreement from Jaspersoft, the following license terms apply:
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jaspersoft Studio Team - initial API and implementation
 ******************************************************************************/
package com.jaspersoft.studio.editor.preview.input;

import java.util.Map;
import java.util.TimeZone;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import com.jaspersoft.studio.swt.widgets.WTimeZone;

public class TimeZoneInput extends ADataInput {
	private WTimeZone txt;

	public boolean isForType(Class<?> valueClass) {
		return TimeZone.class.isAssignableFrom(valueClass);
	}

	@Override
	public void createInput(Composite parent, final IParameter param, final Map<String, Object> params) {
		super.createInput(parent, param, params);
		if (TimeZone.class.isAssignableFrom(param.getValueClass())) {
			txt = new WTimeZone(parent, SWT.DROP_DOWN | SWT.BORDER);
			txt.setToolTipText(param.getDescription());
			txt.addFocusListener(focusListener);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalIndent = 8;
			txt.setLayoutData(gd);
			txt.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateModel(txt.getTimeZone());
					updateInput();
				}

			});
			updateInput();
			setNullable(param, txt);
		}
	}

	public void updateInput() {
		Object value = params.get(param.getName());
		if (value != null && value instanceof TimeZone)
			txt.setSelection((TimeZone) params.get(param.getName()));
		setDecoratorNullable(param);
	}
}
