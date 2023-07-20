package de.zeroco.jdbc;

import java.sql.*;

import de.zeroco.util.Utility;

public class JavaDataBaseConnection {
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/";
	public static final String USER = "admin";
	public static final String PASSWORD = "Pr@veen12";
	
	public static void main(String[] args) {
		PreparedStatement statement = null;
//		System.out.println(isDataInsertedInDataBase(QueryBuilder.getInsertQuery("zerocode", "staff", "idnumber, name", "207719, 'praveen'"), "zerocode"));
//		System.out.println(isDataDeletedFromDataBase(QueryBuilder.getDeleteQuery("zerocode", "staff", "idnumber = 207718"), "zerocode"));
//		System.out.println(getDataFromDataBase(QueryBuilder.getListQuery("zerocode", "staff", "*"), "zerocode"));
//		System.out.println(isDataUpdatedInDataBase("UPDATE staff SET idnumber = ?, name = ? WHERE idnumber = 207701", "zerocode", 207716, "ramo"));
//		System.out.println(isDataInsertedInDataBase(QueryBuilder.getUpdatedQuery("zerocode", "staff", "name = 'raju'", "idnumber = 207708"), "zerocode"));
	}

	public static boolean isDataInsertedInDataBase(String query, String schema) {
		if (Utility.isBlank(schema) || Utility.isBlank(query)) return false;
//		Connection connect = null;
		Connection connect = Utility.getConnection(URL, USER, PASSWORD, schema);
		Statement statement = getStatement(connect);
		int numOfRowsUpdated = executeQuery(statement, query);
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			connect = DriverManager.getConnection(url, user, password);
//			statement = connect.createStatement();
//			int numOfRowsUpdated = statement.executeUpdate(query);
			if (numOfRowsUpdated > 0) {
	            result = true;
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.closeConnection(connect);
			closeStatement(statement);
		}
		return result;
	}

	public static String getDataFromDataBase(String query, String schema) {
		if (Utility.isBlank(schema) || Utility.isBlank(query)) return null;
		Connection connect = Utility.getConnection(URL, USER, PASSWORD, schema);
//		Statement statement = null;
		CallableStatement statement = null;
		ResultSet resultSet = null;
		String result = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			statement = connect.createStatement();
//			statement = connect.prepareCall(query);
			statement = getCallableStatement(connect, query);
			resultSet = executeStatementAndReturnData(statement);
			while (resultSet.next()) {
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					result = result + resultSet.getString(i) + "\t";
				}
				result = result + "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connect.close();
				statement.close();
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static boolean isDataDeletedFromDataBase(String query, String schema) {
		return isDataInsertedInDataBase(query, schema);
	}
	
	public static boolean isDataUpdatedInDataBase(String query, String schema, int idNumber, String name) {
		Connection connect = Utility.getConnection(URL, USER, PASSWORD, schema);
		PreparedStatement statement = null;
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			statement = connect.prepareStatement(query);
			statement.setInt(1, idNumber);
			statement.setString(2, name);
			int numOfRowsUpdated = statement.executeUpdate();
			if (numOfRowsUpdated > 0) {
	            result = true;
	        }
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			Utility.closeConnection(connect);
			closeStatement(statement);
		}
//		return isDataInsertedInDataBase(query, schema);
		return result;
	}
	
	public static Statement getStatement(Connection connect) {
		Statement statement = null;
		try {
			statement = connect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	
	public static PreparedStatement getPreparedStatement(Connection connect, String query) {
		PreparedStatement statement = null;
		try {
			statement = connect.prepareStatement(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}
	
	public static CallableStatement getCallableStatement(Connection connect, String query) {
		CallableStatement statement = null;
		try {
			statement = connect.prepareCall(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}
	
	public static Object closeStatement(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static Object closeResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static int executeQuery(Statement statement, String query) {
		int result = 0;
		try {
			result = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static int executeStatement(PreparedStatement statement) {
		int result = 0;
		try {
			result = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet executeStatementAndReturnData(PreparedStatement statement) {
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet executeQueryAndReturnData(Statement statement, String query) {
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
}
