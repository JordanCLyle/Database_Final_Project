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
    color:aquamarine;
}
td {
    text-align: center;
    color:violet;
}
h3 {
  text-align: center;
  color: #4287f5;
}
</style>
<body style="background-color:black;">
<body>
<h3>Viewing Database Job and Application Info in Relation to Creation Age:</h3>

What attribute would you like to see in comparison to the creation year of the job?
<form action="view_job_age.php" method="post">
    <div>
        <select name="formSearch">
            <option value="'A'">ApplicantId</option>
            <option value="'B'">ApplicantName</option>
            <option value="'C'">ApplicantMajor</option>
            <option value="'D'">DesiredMajor</option>
            <input name="formSubmit" type="submit" >
        </select>
    <div>
<form>

</body>
</html>

<?php
if(isset($_POST['formSubmit']))
{
    $selectionChoice = ($_POST['formSearch']);
    $input = "''";
    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar view_job_age ' . $selectionChoice . ' ' . $input;
    // remove dangerous characters from command to protect web server
    $escaped_command = escapeshellcmd($command);
    // run jdbc_insert_item.exe
    system($escaped_command); 
    ?>
    <html>
    <body>
        <br>
        Above are the jobs in the table with their ages, enter the job age you want to search by.
        <form action="view_job_age.php" method="post">
            <br>
            Input: <input type="text" name="input"><br>
            <input name="submit" type="submit">
            <input name="previous" type="hidden" value="<?php echo $selectionChoice; ?>">
        </form>
        <br><br>
    </body>
    </html>
    <?php
}
if(isset($_POST['submit']))
{
    $selectionChoice = ($_POST['previous']);
    switch ($selectionChoice)
    {
        case "'A'":
        {
            ?>
            <html>
            <body>
            Here is the job age in relation to the applicant ids (StudentId):
            </body>
            </html>
            <?php
            $selectionChoice = "'E'";
            break;
        }
        case "'B'":
        {
            ?>
            <html>
            <body>
            Here is the job age in relation to the applicant names (StudentName):
            </body>
            </html>
            <?php
            $selectionChoice = "'F'";
            break;
        }
        case "'C'":
        {
            ?>
            <html>
            <body>
            Here is the job age in relation to the applicant majors (Major):
            </body>
            </html>
            <?php
            $selectionChoice = "'G'";
            break;
        }
        case "'D'":
        {
            ?>
            <html>
            <body>
            Here is the job age in relation to the desired major for the jobs (DesiredMajor):
            </body>
            </html>
            <?php
            $selectionChoice = "'H'";
            break;
        }
        default:
        {
            $selectionChoice = "'A'";
            break;
        }
    }
    $input = ($_POST['input']);
    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar view_job_age ' . $selectionChoice . ' ' . $input;
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