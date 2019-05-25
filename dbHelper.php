<?php
//Defining Constants

define('HOST','arfo8ynm6olw6vpn.cbetxkdyhwsb.us-east-1.rds.amazonaws.com');// hostname/machineip/serverip is localhost

define('USER','xw52px19w9l8h2de');// user in our case is root

define('PASS','h05d52sz0zr44qgd');//password here is null or blank that is no password

define('DB','leave');

//Connecting to Database

$con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
//this query is used to connect PHP files to MySQL database
?>
