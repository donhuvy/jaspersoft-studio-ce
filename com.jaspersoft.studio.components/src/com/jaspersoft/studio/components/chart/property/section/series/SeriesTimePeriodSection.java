/*******************************************************************************
 * Copyright (C) 2005 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com.
 * 
 * Unless you have purchased  a commercial license agreement from Jaspersoft,
 * the following license terms  apply:
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package com.jaspersoft.studio.components.chart.property.section.series;

import net.sf.jasperreports.charts.design.JRDesignTimePeriodSeries;

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
public class SeriesTimePeriodSection extends AbstractSection {

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ITabbedPropertySection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		parent.setLayout(new GridLayout(2, false));

		createWidget4Property(parent,
				JRDesignTimePeriodSeries.PROPERTY_START_DATE_EXPRESSION);
		createWidget4Property(parent,
				JRDesignTimePeriodSeries.PROPERTY_END_DATE_EXPRESSION);
		createWidget4Property(parent,
				JRDesignTimePeriodSeries.PROPERTY_LABEL_EXPRESSION);
		createWidget4Property(parent,
				JRDesignTimePeriodSeries.PROPERTY_SERIES_EXPRESSION);
		createWidget4Property(parent,
				JRDesignTimePeriodSeries.PROPERTY_VALUE_EXPRESSION);
	}
	
	@Override
	protected void initializeProvidedProperties() {
		super.initializeProvidedProperties();
		addProvidedProperties(JRDesignTimePeriodSeries.PROPERTY_START_DATE_EXPRESSION, Messages.common_start_date_expression);
		addProvidedProperties(JRDesignTimePeriodSeries.PROPERTY_END_DATE_EXPRESSION, Messages.common_end_date_expression);
		addProvidedProperties(JRDesignTimePeriodSeries.PROPERTY_LABEL_EXPRESSION, Messages.common_label_expression);
		addProvidedProperties(JRDesignTimePeriodSeries.PROPERTY_SERIES_EXPRESSION, Messages.common_series_expression);
		addProvidedProperties(JRDesignTimePeriodSeries.PROPERTY_VALUE_EXPRESSION, Messages.common_value_expression);
	}

}
