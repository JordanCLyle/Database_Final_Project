import java.sql.*;

/*
jdbc_insert_item.java    // java program that is called by php that just does the insert; calls jdbc_db.java to connect and do the actual insert
jdbc_db.java // class (no main program) that has useful methods
*/

public class view_job_age {
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
        case "E":
        {
            query1 = "SELECT JobCreationYear, Applications.StudentId FROM Students RIGHT JOIN Applications ON Students.StudentId = Applications.StudentId RIGHT JOIN Jobs ON Applications.JobId = Jobs.JobId WHERE Jobs.JobCreationYear=" + searchQualifier;
            break;
        }
        case "F":
        {
          query1 = "SELECT JobCreationYear, StudentName FROM Students RIGHT JOIN Applications ON Students.StudentId = Applications.StudentId RIGHT JOIN Jobs ON Applications.JobId = Jobs.JobId WHERE Jobs.JobCreationYear=" + searchQualifier;
          break;
        }
        case "G":
        {
          query1 = "SELECT JobCreationYear, Major FROM Students RIGHT JOIN Applications ON Students.StudentId = Applications.StudentId RIGHT JOIN Jobs ON Applications.JobId = Jobs.JobId WHERE Jobs.JobCreationYear=" + searchQualifier;
          break;
        }
        case "H":
        {
          query1 = "SELECT JobCreationYear, DesiredMajor FROM Students RIGHT JOIN Applications ON Students.StudentId = Applications.StudentId RIGHT JOIN Jobs ON Applications.JobId = Jobs.JobId WHERE Jobs.JobCreationYear=" + searchQualifier;
          break;
        }
        default:
        {
            query1 = "SELECT DISTINCT JobCreationYear, JobId, JobTitle FROM Jobs";
            break;
        }
      }
      builder.append(myDB.query(query1));
      System.out.println(builder.toString());
      myDB.disConnect();
   }
}
