<?php

$data = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/read_alertas"), true);

print_r($data);

?>