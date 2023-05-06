<?php
    define('HOST','localhost');
    define('USER','id19982721_root');
    define('PASS','kR%s6hK|3U)Wd]pY');
    define('DB','id19982721_db_monitoring');

    $db_connect = mysqli_connect(HOST, USER, PASS, DB) or die ('Tidak dapat terkoneksi dengan database');

    header('content-Type: application/json');
?>