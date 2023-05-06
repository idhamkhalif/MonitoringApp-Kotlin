<?php
 
    //Variabel database
    $servername = "localhost";
    $username = "id19982721_root";
    $password = "kR%s6hK|3U)Wd]pY";
    $dbname = "id19982721_db_monitoring";
    
 
    $conn = mysqli_connect("$servername", "$username", "$password","$dbname");
 
    // Prepare the SQL statement
    
    $result = mysqli_query ($conn,"INSERT INTO tbl_sensor (temperature,humidity,light) VALUES ('".$_GET["temperature"]."','".$_GET["humidity"]."','".$_GET["light"]."')");    
    
    if (!$result) 
        {
            die ('Invalid query: '.mysqli_error($conn));
        }  
    else
    {
        echo "berhasil disimpan";
    }
?>