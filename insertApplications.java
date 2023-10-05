import java.sql.*;

/*
jdbc_insert_item.java    // java program that is called by php that just does the insert; calls jdbc_db.java to connect and do the actual insert
jdbc_db.java // class (no main program) that has useful methods
*/

public class insertApplications {
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
      String query1 = "SELECT * from Applications";
      builder.append("<br> Table Applications before:" + myDB.query(query1) + "<br>");

      // Parse input string to get restauranrestaurant Name and Address
      String StudentID;
      String JobID;

      // Read command line arguments
      // args[0] is the first parameter
      StudentID = args[0];
      JobID = args[1];

      // Insert the new restaurant
      String input = "'" + StudentID + "','" + JobID + "'";
      myDB.insert("Applications", input); // insert new restaurant

      // For debugging purposes: Show the database after the insert
      builder.append("<br><br><br> Table Applications after:" + myDB.query(query1));
      System.out.println(builder.toString());

      myDB.disConnect();
   }
}
