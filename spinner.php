<?php
$host='arfo8ynm6olw6vpn.cbetxkdyhwsb.us-east-1.rds.amazonaws.com';
$username='xw52px19w9l8h2de';
$password='h05d52sz0zr44qgd';
$db='crud';
$con= mysqli_connect($host,$username,$password) or die("Connection failed");
mysqli_select_db($con,$db) or die("db selection failed");

$result=mysqli_query($con,"SELECT leavetypes FROM leave1");
while($row=mysqli_fetch_assoc($result)){
$tmp[]=$row;
}
echo json_encode($tmp);
mysqli_close($con);
?>
