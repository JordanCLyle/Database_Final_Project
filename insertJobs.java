import java.sql.*;

/*
jdbc_insert_item.java    // java program that is called by php that just does the insert; calls jdbc_db.java to connect and do the actual insert
jdbc_db.java // class (no main program) that has useful methods
*/

public class insertJobs {
   // The main program that inserts a restaurant
   public static void main(String[] args) throws SQLException {
      String Username = "jclyle"; // Change to your own username
      String mysqlPassword = "phieHiu4"; // Change to your own mysql Password

      // Connect to the database
      jdbc_db myDB = new jdbc_db();
      myDB.connect(Username, mysqlPassword);
      myDB.initDatabase();

      // For debugging purposes: Show the database before the insert
      StringBuilder builder = new StringBuilder();
      String query1 = "SELECT * from Jobs";
      builder.append("<br> Table Jobs before:" + myDB.query(query1) + "<br>");

      // Parse input string to get restauranrestaurant Name and Address
      String CompanyName;
      String JobTitle;
      String Salary;
      String DesiredMajor;
      String JobCreationYear;

      // Read command line arguments
      // args[0] is the first parameter
      CompanyName = args[0];
      JobTitle = args[1];
      JobCreationYear = args[2];
      Salary = args[3];
      DesiredMajor = args[4];

      // Get the next id
      String q = "select IFNULL(max(JobID), 0) as job_id from Jobs";
      ResultSet result = myDB.rawQuery(q);
      int next_id = 1;
      if (result.next()) // get first row of result set
         next_id += result.getInt("job_id");

      // Insert the new restaurant
      String input = "'" + next_id + "','" + CompanyName + "','" + JobTitle + "','" + JobCreationYear + "','" + Salary + "','" + DesiredMajor + "'";
      myDB.insert("Jobs", input); // insert new restaurant

      // For debugging purposes: Show the database after the insert
      builder.append("<br><br><br> Table Jobs after:" + myDB.query(query1));
      System.out.println(builder.toString());

      myDB.disConnect();
   }
}
