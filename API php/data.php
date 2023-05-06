<?php
    require_once('helper.php');
    $query = "SELECT *FROM tbl_sensor";
    $sql = mysqli_query($db_connect, $query);

    if($sql)
    {
        $result = array();
        while($row = mysqli_fetch_array($sql))
        {
            array_push($result, array(
                'id' => $row['id'],
                'temperature' => $row['temperature'],
                'humidity' => $row['humidity'],
                'light' => $row['light']
            ));
        }

        echo json_encode(array('sensor'=>$result));
    }
?>