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
<h3>Enter information about an Jobs to add to the database:</h3>


<form action="insertJobs.php" method="post">
    Company Name: <input type="text" name="CompanyName"><br>
    Job Title: <input type="text" name="JobTitle"><br>
    Job Creation Year: <input type="text" name="JobCreationYear"><br>
    Salary: <input type="text" name="Salary"><br>
    DesiredMajor: <input type="text" name="DesiredMajor"><br>
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
    $CompanyName = escapeshellarg($_POST[CompanyName]);
    $JobTitle = escapeshellarg($_POST[JobTitle]);
    $JobCreationYear = escapeshellarg($_POST[JobCreationYear]);
    $Salary = escapeshellarg($_POST[Salary]);
    $DesiredMajor = escapeshellarg($_POST[DesiredMajor]);

    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar insertJobs ' . $CompanyName . ' ' . $JobTitle . ' ' . $JobCreationYear . ' ' .  $Salary . ' ' . $DesiredMajor;

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