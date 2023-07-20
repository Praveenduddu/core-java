package de.zeroco.jdbc;

import java.util.Arrays;
import java.util.List;

import de.zeroco.util.Utility;

public class QueryBuilder {
	
	public static final String GRAVE = "`";

	public static void main(String[] args) {
		
		String[] columns = {"id_number", "name"};
		String[] columnOperator = {">", "="};
		String[] conditionOperator = {"AND"};
		System.out.println(getInsertQuery("zerocode", "staff", Arrays.asList(columns)));
//		System.out.println(getDeleteQuery("zerocode", "staff", "idnumber"));
//		System.out.println(getUpdateQuery("zerocode", "staff", Arrays.asList(columns), "idnumber"));
		System.out.println(getQuery("zerocode", "staff", Arrays.asList(columns), "Job_Role", ">"));
//		System.out.println(getListQuery("zerocode", "staff", Arrays.asList(columns)));
//		System.out.println(getQuery("zerocode", "staff", Arrays.asList(), Arrays.asList(columns), Arrays.asList(columnOperator), Arrays.asList(conditionOperator)));
	}
	
	public static String getQuery(String schema, String tableName, List<String> columns, String conditionColumn, String operator) {
		if(Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(conditionColumn)) return null;
		String query = getListQuery(schema, tableName, columns);
		return query.substring(0, query.length() - 1) + " WHERE " + "(" + GRAVE + conditionColumn + GRAVE + operator +" ?);";
	}
	
	public static String getInsertQuery(String schema, String tableName, List<String> columns) {
		if(Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(columns)) return null;
		String col = "";
		String placeHolders = "";
		for (String column : columns) {
			col += "," + GRAVE + column + GRAVE;
			placeHolders += ",?";
		}
		return "INSERT INTO " + GRAVE + schema + GRAVE + "." + GRAVE + tableName + GRAVE + "(" + col.substring(1) + ") VALUES (" + placeHolders.substring(1) + ");";
	}
	
	public static String getDeleteQuery(String schema, String tableName, String column) {
		if(Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(column)) return null;
	    return "DELETE FROM " + GRAVE + schema + GRAVE + "." + GRAVE + tableName + GRAVE + " WHERE (" + GRAVE + column + GRAVE + "= ?" + ");";
	}
	
	public static String getUpdateQuery(String schema, String tableName, List<String> columns, String conditionColumn) {
		if(Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(columns) || Utility.isBlank(conditionColumn)) return null;
		String setCondition = "";
		for (String column : columns) {
			setCondition += "," + GRAVE + column + GRAVE + "= ?";
		}
		return "UPDATE " + GRAVE + schema + GRAVE + "." + GRAVE + tableName + GRAVE + " SET " + setCondition.substring(1) + " WHERE " + "(" + GRAVE + conditionColumn + GRAVE + "= ?);";
	}
	
	public static String getUpdateQuery(String schema, String tableName, List<String> columns) {
		if(Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(columns)) return null;
		String setCondition = "";
		for (String column : columns) {
			setCondition += "," + GRAVE + column + GRAVE + "= ?";
		}
		return "UPDATE " + GRAVE + schema + GRAVE + "." + GRAVE + tableName + GRAVE + " SET " + setCondition.substring(1) + " ;";
	}
	
	public static String getListQuery(String schema, String tableName, List<String> columns) {
		if(Utility.isBlank(schema) || Utility.isBlank(tableName)) return null;
		if(Utility.isBlank(columns)) {
			return "SELECT " + "*" + " FROM " + GRAVE + schema + GRAVE + "." + GRAVE + tableName + GRAVE + ";";
		}
		String selectCondition = "";
		for (String column : columns) {
			selectCondition += "," + GRAVE + column + GRAVE;
		}
		return "SELECT " + selectCondition.substring(1) + " FROM " + GRAVE + schema + GRAVE + "." + GRAVE + tableName + GRAVE + ";";
	}
	
	public static String getQuery(String schema, String tableName, List<String> columns, List<String> conditionColumns, List<String> columnOperator, List<String> conditionOperator) {
		if(Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(conditionColumns)) return null;
		String query = getListQuery(schema, tableName, columns);
		String whereCondition = "";
		if(conditionColumns.size() == columnOperator.size() && (conditionColumns.size() - 1) == conditionOperator.size()) {
			int count = 0;
			for (String column : conditionColumns) {
				whereCondition += " (" + GRAVE + column + GRAVE + columnOperator.get(count) + " ?) ";
				if(count < conditionOperator.size()) {
					whereCondition += conditionOperator.get(count);
				}
				count++;
			}
			return query.substring(0, query.length() - 1) + " WHERE " + whereCondition + ";";
		}
		return null;
	}
	
	public static String getJoinQuery(String schema, List<String> tables, List<String> joinConditions) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT * FROM ");
		for (int i = 0; i < tables.size(); i++) {
			String table = tables.get(i);
			queryBuilder.append(GRAVE).append(schema).append(GRAVE + ".").append(GRAVE).append(table).append(GRAVE);
			if (i < tables.size() && i > 0) {
				queryBuilder.append(" ON " + joinConditions.get(i - 1));
			}
			if (i < tables.size() - 1) {
				queryBuilder.append(" JOIN ");
			}
		}
		queryBuilder.append(";");
		return queryBuilder.toString();
	}

}
