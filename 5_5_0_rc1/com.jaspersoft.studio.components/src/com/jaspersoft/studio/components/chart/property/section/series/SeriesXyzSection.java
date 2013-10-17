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
package com.jaspersoft.studio.components.chart.property.section.series;

import net.sf.jasperreports.charts.design.JRDesignXyzSeries;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.jaspersoft.studio.components.chart.messages.Messages;
import com.jaspersoft.studio.properties.view.TabbedPropertySheetPage;
import com.jaspersoft.studio.property.section.AbstractSection;

/*
 * The location section on the location tab.
 * 
 * @author Chicu Veaceslav
 */
public class SeriesXyzSection extends AbstractSection {

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		parent.setLayout(new GridLayout(2, false));

		createWidget4Property(parent,
				JRDesignXyzSeries.PROPERTY_X_VALUE_EXPRESSION);
		createWidget4Property(parent,
				JRDesignXyzSeries.PROPERTY_Y_VALUE_EXPRESSION);
		createWidget4Property(parent,
				JRDesignXyzSeries.PROPERTY_Z_VALUE_EXPRESSION);
		createWidget4Property(parent,
				JRDesignXyzSeries.PROPERTY_SERIES_EXPRESSION);

	}
	
	@Override
	protected void initializeProvidedProperties() {
		super.initializeProvidedProperties();
		addProvidedProperties(JRDesignXyzSeries.PROPERTY_X_VALUE_EXPRESSION, Messages.common_x_value_expression);
		addProvidedProperties(JRDesignXyzSeries.PROPERTY_Y_VALUE_EXPRESSION, Messages.common_y_value_expression);
		addProvidedProperties(JRDesignXyzSeries.PROPERTY_Z_VALUE_EXPRESSION, Messages.MXYZSeries_z_value_expression);
		addProvidedProperties(JRDesignXyzSeries.PROPERTY_SERIES_EXPRESSION, Messages.common_series_expression);
	}

}
