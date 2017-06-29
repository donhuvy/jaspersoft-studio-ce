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
package com.jaspersoft.studio.components.chart.property.section.plot;

import org.eclipse.swt.widgets.Composite;

import com.jaspersoft.studio.components.chart.messages.Messages;
import com.jaspersoft.studio.properties.view.TabbedPropertySheetPage;
import com.jaspersoft.studio.property.section.AbstractRealValueSection;

import net.sf.jasperreports.charts.design.JRDesignPie3DPlot;

public class Pie3dPlot extends AbstractRealValueSection {

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		createWidget4Property(parent, JRDesignPie3DPlot.PROPERTY_SHOW_LABELS);
		createWidget4Property(parent, JRDesignPie3DPlot.PROPERTY_CIRCULAR);
 
		createWidget4Property(parent, JRDesignPie3DPlot.PROPERTY_LABEL_FORMAT);
		createWidget4Property(parent, JRDesignPie3DPlot.PROPERTY_LEGEND_LABEL_FORMAT);
		createWidget4Property(parent, JRDesignPie3DPlot.PROPERTY_DEPTH_FACTOR);

		parent = getWidgetFactory().createSectionTitle(parent, Messages.common_item_label,true, 4, 2);
		createWidget4Property(parent,JRDesignPie3DPlot.PROPERTY_ITEM_LABEL, false);
	}

}
