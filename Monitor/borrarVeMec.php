<?php  

$idVeMec = ($_GET['variable']);

$data = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/deletevemec?idVemec=$idVeMec"), true);

header('Location: ./administrarVeMec.php');

?>