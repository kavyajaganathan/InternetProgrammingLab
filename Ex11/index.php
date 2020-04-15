<!DOCTYPE HTML>  
<html>
<head>
<title>Feedback Form</title>
<style>
    .error {
    color: #FF0000;
    }
</style>
</head>
<body>

<?php
    $nameErr = $emailErr = $mobileErr = $commentErr = $genderErr = "";
    $name = $email = $mobile = $comment = $gender = "";
    $flag = 0;
    
    if($_SERVER["REQUEST_METHOD"] == "POST") {
        if(empty($_POST["name"])) {
            $nameErr = "Name is required!"; $flag = 1;
        } else {
            $name = reformat_input($_POST["name"]);
            if(!preg_match("/^[a-zA-Z ]*$/", $name)) {
                $nameErr = "Invalid Name!"; $flag = 1;
            }
        }
        
        if (empty($_POST["email"])) {
            $emailErr = "Email is required"; $flag = 1;
        } else {
            $email = reformat_input($_POST["email"]);
            if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
                $emailErr = "Invalid Email!"; $flag = 1;
            }
        }
        
        if (empty($_POST["mobile"])) {
            $mobileErr = "Mobile is required!"; $flag = 1;
        } else {
            $mobile = reformat_input($_POST["mobile"]);
            if(!preg_match("/[0-9]{10}/", $mobile)) {
                $mobileErr = "Invalid Mobile!"; $flag = 1;
            }
        }
        
        if (empty($_POST["comment"])) {
            $commentErr = "Comment is required!"; $flag = 1;
        } else {
            $comment = reformat_input($_POST["comment"]);
        }
        
        if (empty($_POST["gender"])) {
            $genderErr = "Gender is required"; $flag = 1;
        } else {
            $gender = reformat_input($_POST["gender"]);
        }
        
        if($flag == 0) {
            $conn = new mysqli("localhost", "root", "", "iplab");
            if($conn->connect_error) {
                die("Connection failed: ". $conn->connect_error);
            }
            $sql = "INSERT INTO feedback VALUES('" . $name . "', '" . $email . "', '" . $mobile . "', '" . $comment . "', '" . $gender . "');";
            if($conn->query($sql) === TRUE) {
                echo "Successfully submitted!";
            } else {
                echo "Unsuccessful submission!";
            }
        }
    }
    
    function reformat_input($data) {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }
?>

<h2>Details Form</h2>
<p style="color: #F00">* required field</p>
<form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
    Name: <input type="text" name="name">
    <span class="error">* <?php echo $nameErr;?></span>
    <br><br>
    E-mail: <input type="text" name="email">
    <span class="error">* <?php echo $emailErr;?></span>
    <br><br>
    Mobile: <input type="text" name="mobile">
    <span class="error">* <?php echo $mobileErr;?></span>
    <br><br>
    Comment: <textarea name="comment" rows="5" cols="40"></textarea>
    <span class="error">* <?php echo $commentErr;?></span>
    <br><br>
    Gender:
    <input type="radio" name="gender" value="female">Female
    <input type="radio" name="gender" value="male">Male
    <input type="radio" name="gender" value="other">Other
    <span class="error">* <?php echo $genderErr;?></span>
    <br><br>
    <input type="submit" name="submit" value="Submit">
</form>

<?php
    echo "<h2>Your Input</h2>";
    if($flag == 0) {
        echo "Name: $name";
        echo "<br>";
        echo "Email: $email";
        echo "<br>";
        echo "Mobile: $mobile";
        echo "<br>";
        echo "Comment: $comment";
        echo "<br>";
        echo "Gender: $gender";
    }
    else {
        echo "Errors in input!";
    }
?>

</body>
</html>
