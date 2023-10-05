import java.sql.*;

/*
jdbc_insert_item.java    // java program that is called by php that just does the insert; calls jdbc_db.java to connect and do the actual insert
jdbc_db.java // class (no main program) that has useful methods
*/

public class view_jobs {
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

      // Read command line arguments
      // args[0] is the first parameter
      String selectionChoice = args[0];
      String searchQualifier = args[1];
      String query1 = "";
      switch(selectionChoice)
      {
         case "A":
         {
             //query1 = "SELECT DISTINCT Major FROM Students";
             break;
         }
         case "B":
         {
             //query2 = "SELECT StudentName, Major FROM Students";
             query1 = "SELECT DISTINCT DesiredMajor FROM Jobs";
             break;
         }
         case "F":
         {
           //query1 = "SELECT StudentName, Major FROM Students WHERE Students.Major = 'ELEG'";
           if (searchQualifier.matches("[a-zA-Z]+"))
           {
            query1 = "SELECT JobID, JobTitle, Salary, CompanyName, DesiredMajor FROM Jobs WHERE Jobs.DesiredMajor = '" + searchQualifier + "'";
           }
           else
           {
            query1 = "SELECT JobID, JobTitle, Salary, CompanyName, DesiredMajor FROM Jobs";
           }
           break;
         }
         default:
         {
             query1 = "SELECT JobID, DesiredMajor FROM Jobs";
         }
       }
      // builder.append(myDB.query(query2));
      // System.out.println(builder.toString());

      builder.append(myDB.query(query1));
      System.out.println(builder.toString());
      myDB.disConnect();
   }
}
