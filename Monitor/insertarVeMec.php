<?php  

$marca = $_POST['marca'];
$modelo = $_POST['modelo'];
$ubicacion = $_POST['ubicacion'];

$marca = str_replace(' ','+',$marca);
$modelo = str_replace(' ','+',$modelo);
$ubicacion = str_replace(' ','+',$ubicacion);

$data = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/createvemec?marca=$marca&modelo=$modelo&ubicacion=$ubicacion"), true);

header('Location: ./administrarVeMec.php');

?>