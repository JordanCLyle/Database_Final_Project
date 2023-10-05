<html>
<style>
div {
  width: 350px;
  margin: auto;
  border: 3px solid #4287f5;
}
a,
form,
th
{
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
<body>
<h3>View students by major:</h3>

How would you like to view the students?
<form action="view_students.php" method="post">
    <div>
        <select name="formSearch">
            <option value="'B'">Click the submit button to search by Majors----></option>
            <input name="formSubmit" type="submit" >
        </select>
    <div>
<form>

</body>
</html>

<?php
$flag = false;
if(isset($_POST['formSubmit']))
{
    $selectionChoice = ($_POST['formSearch']);
    $input = "''";
    $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar view_students ' . $selectionChoice . ' ' . $input;
    // remove dangerous characters from command to protect web server
    $escaped_command = escapeshellcmd($command);
    // run jdbc_insert_item.exe
    if ($selectionChoice != "'A'")
    {
        $flag = true;
    }
    system($escaped_command);
}
    if($flag)
    {
        if($selectionChoice == "'B'")
        {
            ?>

            <html>
            <body>

            <br>
            Above are the majors in the table, enter one to search by.
            <form action="view_students.php" method="post">
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
        else if ($selectionChoice == "'C'")
        {
            ?>

            <html>
            <body>

            <br>
            Above are the students in the table, enter one of their ids to search applications from them.
            <form action="view_students.php" method="post">
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
        else if ($selectionChoice == "'D'")
        {
            ?>

            <html>
            <body>

            <br>
            Above are the jobs in the table, enter one of their ids to search applications to them.
            <form action="view_students.php" method="post">
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
    }
    ?>
    <?php
    $selectionChoice = $_POST['previous'];
    if(isset($_POST['submit']) && $selectionChoice != "'A'")
    {
        switch ($selectionChoice)
        {
            case "'B'":
            {
                $selectionChoice = "'F'";
                break;
            }
            case "'C'":
            {
                $selectionChoice = "'G'";
                break;
            }
            case "'D'":
            {
                $selectionChoice = "'H'";
                break;
            }
            default:
            {
                $selectionChoice = "'E'";
                break;
            }
        }
        $input = escapeshellarg($_POST[input]);
        $command = 'java -cp .:mysql-connector-java-5.1.40-bin.jar view_students ' . $selectionChoice . ' ' . $input;
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