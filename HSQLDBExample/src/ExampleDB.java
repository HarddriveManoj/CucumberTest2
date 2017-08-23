import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ExampleDB {
	Connection connection;

	private final static String projects = "CREATE TABLE IF NOT EXISTS projects ( projectId INT NOT NULL PRIMARY KEY,  projectName varchar(50) NOT NULL,  project_url varchar(100) NOT NULL,  project_manager varchar(100) NOT NULL,  project_is_Complete boolean,  projectCompletedOn varchar(100) NOT NULL);";
	private final static String milestones = "CREATE TABLE IF NOT EXISTS mileStones (  mileStoneId INT NOT NULL PRIMARY KEY,  projectId INT NOT NULL,  milestoneIsStarted boolean,  milestoneName varchar(100) NOT NULL,  milestoneDescription varchar(100) NOT NULL,  milestoneURL varchar(100) NOT NULL,  milestoneDueOn INT NOT NULL);";

	public ExampleDB() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		Class.forName("org.hsqldb.jdbcDriver");
		connection = DriverManager.getConnection("jdbc:hsqldb:file:" + "D:/Java/hsqldb-2.3.4/hsqldb/data/test", "SA",
				"");

	}

	public void insertIntoDB(String table, HashMap data) throws SQLException {
		Set s = data.keySet();
		Iterator it = s.iterator();
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO " + table + " values (");
		while (it.hasNext()) {

			Statement stmt = connection.createStatement();
			sb.append("'" + data.get(it.next()) + "',");

		}
		System.out.println(sb.substring(0, sb.lastIndexOf(",")) + ";");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new ExampleDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
