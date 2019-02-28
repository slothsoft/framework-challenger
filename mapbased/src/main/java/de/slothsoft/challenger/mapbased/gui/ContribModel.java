package de.slothsoft.challenger.mapbased.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import de.slothsoft.challenger.core.Contrib;

/**
 * A table model that displays all {@link Contrib}s with a selection check box.
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public class ContribModel extends AbstractTableModel {

	private static final long serialVersionUID = 6708900198232721648L;

	private static final String[] COLUMNS = {"Use", "Name", "Author", "Class"};
	public static final int COLUMN_SELECTED = 0;
	public static final int COLUMN_NAME = 1;
	public static final int COLUMN_AUTHOR = 2;
	public static final int COLUMN_CLASS = 3;

	private final List<Row> rows = new ArrayList<>();

	public ContribModel(List<Contrib> contribs) {
		for (final Contrib contrib : contribs) {
			this.rows.add(new Row(contrib.getDisplayName(), contrib.getAuthor(), contrib.getClass()));
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		final Row row = this.rows.get(rowIndex);
		switch (columnIndex) {
			case COLUMN_SELECTED :
				return Boolean.valueOf(row.selected);
			case COLUMN_NAME :
				return row.displayName;
			case COLUMN_AUTHOR :
				return row.author;
			case COLUMN_CLASS :
				return row.contribClass.getSimpleName();
			default :
				return null;
		}
	}

	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMNS.length;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMNS[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case COLUMN_SELECTED :
				return Boolean.class;
			case COLUMN_NAME :
			case COLUMN_AUTHOR :
			case COLUMN_CLASS :
				return String.class;
			default :
				return super.getColumnClass(columnIndex);
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case COLUMN_SELECTED :
				return true;
			default :
				return false;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		final Row row = this.rows.get(rowIndex);
		switch (columnIndex) {
			case COLUMN_SELECTED :
				row.selected = ((Boolean) aValue).booleanValue();
				break;
			default :
		}
	}

	public Contrib createContrib(int rowIndex) {
		final Row row = this.rows.get(rowIndex);
		try {
			return row.selected ? row.contribClass.newInstance() : null;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("Cannot create instance of " + row.contribClass, e);
		}
	}

	/*
	 *
	 */

	private static class Row {

		final String displayName;
		final String author;
		final Class<? extends Contrib> contribClass;
		boolean selected = true;

		public Row(String displayName, String author, Class<? extends Contrib> contribClass) {
			this.displayName = displayName;
			this.author = author;
			this.contribClass = contribClass;
		}

	}

}
