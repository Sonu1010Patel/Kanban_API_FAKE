package sql_API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SQL_API {
	  public static void main(String args[]) {
	    try {
	      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      
	      String url = "jdbc:sqlserver://192.168.231.128:1433;database=KANBAN_CREW_DB;user=JavaReader;password=JavaReader_100";
	      Connection conn = DriverManager.getConnection(url);
	      Statement stmt = conn.createStatement();
	      ResultSet resultSet;
	      
	      resultSet = stmt.executeQuery("SELECT * FROM USERS;");
	      
	      ResultSetMetaData rsmd = resultSet.getMetaData();
	      int columnsNumber = rsmd.getColumnCount();
	      while (resultSet.next()) {
	          for (int i = 1; i <= columnsNumber; i++) {
	              if (i > 1) System.out.print(",  ");
	              String columnValue = resultSet.getString(i);
	              System.out.print(columnValue + " " + rsmd.getColumnName(i));
	          }
	          System.out.println("");
	      }
	      conn.close();
	  } catch (Exception e) {
	      System.err.println("Got an exception! ");
	      e.printStackTrace();
	      
	  }
	  }

}
