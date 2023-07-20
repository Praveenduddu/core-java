package de.zeroco.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.zeroco.util.Utility;

public class DBUtil {
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/";
	public static final String USER = "admin";
	public static final String PASSWORD = "Pr@veen12";
	public static final String AUTOINCREAMENT_COLUMN = "pk_id";
	public static final String ASSIGNMENT_OPERATOR = "=";

	public static void main(String[] args) throws Exception {
		String schema = "zerocode";
		String[] columnOperator = {">", "<"};
		String[] conditionOperator = {"OR"};
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("brand_name", "Dell");
		map.put("model", "G18");
		map.put("price", 70000);
		map.put("ram_capacity", "4GB");
		map.put("storage_capacity", "1000GB");
		String[] columns = {"brand_name", "model", "price", "ram_capacity", "storage_capacity"};
		String[] conditionColumns = {"price", "price"};
		Object[] values = {"Dell", "G17", 70000, "8GB", "500GB"};
//		
		String[] tableNames = {"state", "district", "city", "pincode"};
		String[] stateColumns = {"state_name", "state_code"};
		String[] districtColumns = {"district_name", "district_code"};
		String[] cityColumns = {"city_name", "city_code"};
		String[] pincodeColumns = {"pincode"};
		List<List<String>> allColumns = new ArrayList<List<String>>();
		allColumns.add(Arrays.asList(stateColumns));
		allColumns.add(Arrays.asList(districtColumns));
		allColumns.add(Arrays.asList(cityColumns));
		allColumns.add(Arrays.asList(pincodeColumns));
		String[] foreignColumns = {"state_id", "district_id", "city_id"};
//		System.out.println(allColumns);
//		Connection connection = DriverManager.getConnection((DBUtil.URL + "zerocode"), DBUtil.USER, DBUtil.PASSWORD);
		Connection connection = Utility.getConnection(URL, USER, PASSWORD, schema);
//		System.out.println(getGeneratedKey("zerocode", "laptops", Arrays.asList(columns), Arrays.asList(values), connection));
//		System.out.println(list("zerocode", "laptops", Arrays.asList(columns), connection));
//		System.out.println(update("zerocode", "laptops", map, "pk_id", 1001, connection));
//		System.out.println(delete("zerocode", "laptops", "pk_id", 1012, connection));
//		System.out.println(get("zerocode", "laptops", Arrays.asList(columns), Arrays.asList(conditionColumns), Arrays.asList(columnOperator), Arrays.asList(conditionOperator), Arrays.asList(values), connection));
//		System.out.println(get(schema, "laptops", Arrays.asList(columns), "pk_id", "<", 1015, connection));
//		System.out.println(dataMigrationFromCsvToDataBase(connection, "zerocode", Arrays.asList(tableNames), allColumns, "C:\\Users\\91834\\Downloads\\Master_Pincode_data.csv", Arrays.asList(foreignColumns)));
		Utility.closeConnection(connection);
	}

	public static int getGeneratedKey(String schema, String tableName, List<String> columns, List<Object> values, Connection connection) {
		if (Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(columns)) return 0;
		int count = 0;
		ResultSet generatedKeys = null;
		int autoIncrementId = 0;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(QueryBuilder.getInsertQuery(schema, tableName, columns), PreparedStatement.RETURN_GENERATED_KEYS);
			for (Object value : values) {
				statement.setObject(++count, value);
			}
			statement.executeUpdate();
			generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				autoIncrementId = generatedKeys.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaDataBaseConnection.closeStatement(statement);
			JavaDataBaseConnection.closeResultSet(generatedKeys);
		}
		return autoIncrementId;
	}
	
	public static List<Map<String, Object>> list(String schema, String tableName, List<String> columns, Connection connection) {
		if (Utility.isBlank(schema) || Utility.isBlank(tableName)) return null;
		List<Map<String, Object>> resultList = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = JavaDataBaseConnection.getPreparedStatement(connection, QueryBuilder.getListQuery(schema, tableName, columns));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Map<String, Object> rowMap = new LinkedHashMap<>();
				int columnCount = resultSet.getMetaData().getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = resultSet.getMetaData().getColumnName(i);
					Object columnValue = resultSet.getObject(i);
					rowMap.put(columnName, columnValue);
				}
				resultList.add(rowMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaDataBaseConnection.closeStatement(statement);
			JavaDataBaseConnection.closeResultSet(resultSet);
		}
		return resultList;
	}
	
	public static int update(String schema, String tableName, List<String> columns, List<Object> values, String conditionColumn, Object conditionValue, Connection connection) {
		if (Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(columns) || Utility.isBlank(conditionColumn) || Utility.isBlank(conditionValue)) return 0;
		int count = 0;
		int numOfRowsUpdated = 0;
		PreparedStatement statement = null;
			try {
				statement = JavaDataBaseConnection.getPreparedStatement(connection, QueryBuilder.getUpdateQuery(schema, tableName, columns, conditionColumn));
				for (Object value : values) {
					statement.setObject(++count, value);
				}
				statement.setObject(++count, conditionValue);
				numOfRowsUpdated = statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JavaDataBaseConnection.closeStatement(statement);
			}
		return numOfRowsUpdated;
	}
	
	public static int update(String schema, String tableName, List<String> columns, List<Object> values, Connection connection) {
		if (Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(columns)) return 0;
		int count = 0;
		int numOfRowsUpdated = 0;
		PreparedStatement statement = null;
			try {
				statement = JavaDataBaseConnection.getPreparedStatement(connection, QueryBuilder.getUpdateQuery(schema, tableName, columns));
				for (Object value : values) {
					statement.setObject(++count, value);
				}
				numOfRowsUpdated = statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JavaDataBaseConnection.closeStatement(statement);
			}
		return numOfRowsUpdated;
	}
	
	public static int delete(String schema, String tableName, String conditionColumn, Object conditionValue, Connection connection) {
		if (Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(conditionColumn) || Utility.isBlank(conditionValue)) return 0;
		int numOfRowsUpdated = 0;
		PreparedStatement statement = null;
		try {
			statement = JavaDataBaseConnection.getPreparedStatement(connection, QueryBuilder.getDeleteQuery(schema, tableName, conditionColumn));
			statement.setObject(1, conditionValue);
			numOfRowsUpdated = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaDataBaseConnection.closeStatement(statement);
		}
		return numOfRowsUpdated;
	}
	
	public static List<Map<String, Object>> gets(String schema, String tableName, List<String> columns, String conditionColumn, String conditionOperator, Object conditionValue, Connection connection) {
		if (Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(conditionColumn) || Utility.isBlank(conditionOperator) || Utility.isBlank(conditionValue)) return null;
		List<Map<String, Object>> result = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = JavaDataBaseConnection.getPreparedStatement(connection, QueryBuilder.getQuery(schema, tableName, columns, conditionColumn, conditionOperator));
			statement.setObject(1, conditionValue);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Map<String, Object> rowMap = new LinkedHashMap<>();
				int columnCount = resultSet.getMetaData().getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = resultSet.getMetaData().getColumnName(i);
					Object columnValue = resultSet.getObject(i);
					rowMap.put(columnName, columnValue);
				}
				result.add(rowMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaDataBaseConnection.closeStatement(statement);
			JavaDataBaseConnection.closeResultSet(resultSet);
		}
		return result;
	}
	
	public static Map<String, Object> get(String schema, String tableName, List<String> columns, String conditionColumn, String conditionOperator, Object conditionValue, Connection connection) {
		if (Utility.isBlank(schema) || Utility.isBlank(tableName) || Utility.isBlank(conditionColumn) || Utility.isBlank(conditionOperator) || Utility.isBlank(conditionValue)) return null;
		Map<String, Object> result = new LinkedHashMap<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = JavaDataBaseConnection.getPreparedStatement(connection, QueryBuilder.getQuery(schema, tableName, columns, conditionColumn, conditionOperator));
			statement.setObject(1, conditionValue);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int columnCount = resultSet.getMetaData().getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = resultSet.getMetaData().getColumnName(i);
					Object columnValue = resultSet.getObject(i);
					result.put(columnName, columnValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JavaDataBaseConnection.closeStatement(statement);
			JavaDataBaseConnection.closeResultSet(resultSet);
		}
		return result;
	}
	
	public static String dataMigrationFromCsvToDataBase(Connection connection, String schema, List<String> tableNames, List<List<String>> columns, String filePath, List<String> foreignKeyColumns) {
		if (Utility.isBlank(schema) || Utility.isBlank(tableNames) || Utility.isBlank(filePath) || Utility.isBlank(foreignKeyColumns)) return null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
            String lines;
            reader.readLine();
            List<Object> foreignKeys = new ArrayList<Object>();
            while ((lines = reader.readLine()) != null) {
            	int count = 0;
            	Object[] line = lines.split(",");
                List<Object> data = new ArrayList<Object>(Arrays.asList(line));
                for (List<String> list : columns) {
                    String tableName = tableNames.get(count);
                    List<Object> values = new ArrayList<Object>();
                    for(int i = 0; i < list.size(); i++) {
                    	values.add(data.remove(0));
                    }
                    if (Utility.isBlank(gets(schema, tableName, Arrays.asList(), list.get(0), ASSIGNMENT_OPERATOR, values.get(0), connection))) {
                		foreignKeys.add(count, getGeneratedKey(schema, tableName, list, values, connection));
                		if(count > 0) {
                			int keyIndex = count;
                			update(schema, tableName, Arrays.asList(foreignKeyColumns.get(--keyIndex)), Arrays.asList(foreignKeys.get(keyIndex)), AUTOINCREAMENT_COLUMN, foreignKeys.get(count), connection);
                		}
                    }
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		return filePath;
	}
}
