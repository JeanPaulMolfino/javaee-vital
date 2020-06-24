<?php  

$ci = $_POST['ci'];
$nombre = $_POST['nombre'];
$apellido = $_POST['apellido'];
$edad = $_POST['edad'];

$nombre = str_replace(' ','+',$nombre);
$apellido = str_replace(' ','+',$apellido);

$data = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/createpaciente?ci=$ci&nombre=$nombre&apellido=$apellido&edad=$edad"), true);

header('Location: ./administrarVeMec.php');

?>