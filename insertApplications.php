<html>
<style>
div {
  width: 300px;
  margin: auto;
  border: 3px solid #4287f5;
}
a,
form,
th {
    text-align: center;
}
td {
    text-align: center;
}
h3 {
  text-align: center;
  color: #4287f5;
}
table
{
  margin-left:auto;
  margin-right:auto;
}
</style>
<body style="background-color:Bisque;">
<body>
<h3>Enter information about an Applications to add to the database:</h3>

<form action="insertApplications.php" method="post">
    StudentID: <input type="text" name="StudentID"><br>
    JobID: <input type="text" name="JobID"><br>
    <input name="submit" type="submit" >
</form>
<br><br>

</body>
</html>
<p style="text-align:center">

<?php
if (isset($_POST['submit']))
{
    // replace ' ' with '\ ' in the strings so they are treated as single command line args
    $StudentID = escapeshellarg($_POST[StudentID]);
    $JobID = escapeshellarg($_POST[JobID]);

    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar insertApplications ' . $StudentID . ' ' . $JobID;

    // remove dangerous characters from command to protect web server
    $escaped_command = escapeshellcmd($command);
    // run jdbc_insert_item.exe
    system($escaped_command);
}
?>

<br></br>
<p style="text-align:center">
<a href="http://www.csce.uark.edu/~jclyle/project_java/homepage.php">Return to Homepage</a>
</p>