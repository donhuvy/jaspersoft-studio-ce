package com.jaspersoft.studio.data.sql.ui.gef.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;

import com.jaspersoft.studio.data.sql.SQLQueryDesigner;
import com.jaspersoft.studio.data.sql.Util;
import com.jaspersoft.studio.data.sql.action.table.EditTable;
import com.jaspersoft.studio.data.sql.model.metadata.MSqlTable;
import com.jaspersoft.studio.data.sql.model.query.from.MFromTable;
import com.jaspersoft.studio.data.sql.model.query.from.MFromTableJoin;
import com.jaspersoft.studio.data.sql.model.query.from.TableJoin;
import com.jaspersoft.studio.data.sql.model.query.select.MSelect;
import com.jaspersoft.studio.data.sql.model.query.select.MSelectColumn;
import com.jaspersoft.studio.data.sql.ui.gef.SQLQueryDiagram;
import com.jaspersoft.studio.data.sql.ui.gef.anchors.BottomAnchor;
import com.jaspersoft.studio.data.sql.ui.gef.anchors.TopAnchor;
import com.jaspersoft.studio.data.sql.ui.gef.figures.SqlTableFigure;
import com.jaspersoft.studio.data.sql.ui.gef.policy.TableLayoutEditPolicy;
import com.jaspersoft.studio.data.sql.ui.gef.policy.TableNodeEditPolicy;
import com.jaspersoft.studio.model.INode;

public class TableEditPart extends AbstractGraphicalEditPart {
	private Map<String, MSelectColumn> set = new HashMap<String, MSelectColumn>();
	private SQLQueryDesigner designer;

	@Override
	protected IFigure createFigure() {
		SqlTableFigure fig = new SqlTableFigure("");
		return fig;
	}

	public Map<String, MSelectColumn> getColumnMap() {
		return set;
	}

	@Override
	public MFromTable getModel() {
		return (MFromTable) super.getModel();
	}

	@Override
	public SqlTableFigure getFigure() {
		return (SqlTableFigure) super.getFigure();
	}

	@Override
	protected void refreshVisuals() {
		SqlTableFigure f = getFigure();

		MFromTable fromTable = getModel();
		MSqlTable table = fromTable.getValue();
		String tblName = table.getValue();
		if (fromTable.getAlias() != null)
			tblName += fromTable.getAliasKeyword() + fromTable.getAlias();

		f.setName(tblName);

		MSelect msel = Util.getKeyword(fromTable, MSelect.class);
		set.clear();
		for (INode n : msel.getChildren()) {
			if (n instanceof MSelectColumn && ((MSelectColumn) n).getMFromTable().equals(fromTable)) {
				MSelectColumn msc = (MSelectColumn) n;
				set.put(msc.getValue().getValue(), msc);
			}
		}
		// for (String col : set) {
		// CheckBox cb = cbMap.get(col);
		// cb.setSelected(set.contains(((Label)
		// cb.getChildren().get(0)).getText()));
		// }
		AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart) getParent();
		Point location = f.getLocation();
		Rectangle constraint = new Rectangle(location.x, location.y, -1, -1);
		parent.setLayoutConstraint(this, f, constraint);
	}

	@Override
	protected List getModelChildren() {
		return getModel().getValue().getChildren();
	}

	public SQLQueryDesigner getDesigner() {
		if (designer == null)
			designer = (SQLQueryDesigner) getViewer().getProperty(SQLQueryDiagram.SQLQUERYDIAGRAM);
		return designer;
	}

	@Override
	public void performRequest(Request req) {
		System.out.println("Table" + req);
		if (RequestConstants.REQ_OPEN.equals(req.getType())) {
			EditTable ct = getDesigner().getOutline().getAfactory().getAction(EditTable.class);
			if (ct.calculateEnabled(new Object[] { getModel() }))
				ct.run();
		}
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new TableNodeEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new TableLayoutEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new SelectionEditPolicy() {

			@Override
			protected void hideSelection() {
				getFigure().hideSelectedBorder();
			}

			@Override
			protected void showSelection() {
				getFigure().showSelectedBorder();
			}
		});
	}

	@Override
	protected List getModelSourceConnections() {
		if (getModel().getTableJoins() != null && !getModel().getTableJoins().isEmpty())
			return getModel().getTableJoins();
		return super.getModelSourceConnections();
	}

	@Override
	protected List getModelTargetConnections() {
		if (getModel() instanceof MFromTableJoin) {
			List<TableJoin> joins = new ArrayList<TableJoin>();
			joins.add(((MFromTableJoin) getModel()).getTableJoin());
			return joins;
		}
		return super.getModelTargetConnections();
	}

	/**
	 * @see NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return new TopAnchor(getFigure());
	}

	/**
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new TopAnchor(getFigure());
	}

	/**
	 * @see NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return new BottomAnchor(getFigure());
	}

	/**
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new BottomAnchor(getFigure());
	}
}
