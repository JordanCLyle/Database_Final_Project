import java.sql.*;

/*
jdbc_insert_item.java    // java program that is called by php that just does the insert; calls jdbc_db.java to connect and do the actual insert
jdbc_db.java // class (no main program) that has useful methods
*/

public class view_applications {
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
            query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId";
            break;
        }
        case "B":
        {
            query1 = "SELECT DISTINCT Major FROM Applications, Students WHERE Applications.StudentId = Students.StudentId";
            break;
        }
        case "C":
        {
            query1 = "SELECT DISTINCT Students.StudentId, StudentName FROM Applications, Students WHERE Applications.StudentId = Students.StudentId";
            break;
        }
        case "D":
        {
            query1 = "SELECT DISTINCT Jobs.JobId, JobTitle FROM Applications, Jobs WHERE Applications.JobId = Jobs.JobId";
            break;
        }
        case "E":
        {
            query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId";
            break;
        }
        case "F":
        {
            if (searchQualifier.matches("[a-zA-Z]+"))
            {
                query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId AND Students.Major = '" + searchQualifier + "'";
            }
            else
            {
                query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId";
            }
            break;
        }
        case "G":
        {
            if (searchQualifier.matches("\\d+"))
            {
                query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId AND Applications.StudentId = '" + searchQualifier + "'";
            }
            else
            {
                query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId";
            }
            break;
        }
        case "H":
        {
            if (searchQualifier.matches("\\d+"))
            {
                query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId AND Applications.JobId = '" + searchQualifier + "'";
            }
            else
            {
                query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId";
            }
            break;
        }
        default:
        {
            query1 = "SELECT StudentName, CompanyName, Salary, Major FROM Applications, Students, Jobs WHERE Applications.StudentId = Students.StudentId AND Applications.JobId = Jobs.JobId";
        }
      }
      builder.append(myDB.query(query1));
      System.out.println(builder.toString());
      myDB.disConnect();
   }
}
