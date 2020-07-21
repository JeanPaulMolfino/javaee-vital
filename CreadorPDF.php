<?php
require('fpdf.php');
$id = $_GET['id'];
$datab = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/read_vemecdata_3minutes?id=$id"), true);
class PDF extends FPDF
{
// Page header
function Header()
{
    // Logo
    $this->Image('logoutec.png',10,6,30);
    // Arial bold 15
    $this->SetFont('Arial','B',15);
    // Move to the right
    $this->Cell(80);
    // Title
    $this->Cell(30,10,'Reporte Vemec Numero '.$id,1,0,'C');
    // Line break
    $this->Ln(20);

    //Aca van los nombres de las columnas
    $this->Cell(50, 10, 'Fecha', 1, 0, 'C', 0);
    $this->Cell(30, 10, 'Precion Max', 1, 0, 'C', 0);
    $this->Cell(30, 10, 'Precion Min', 1, 1, 'C', 0);
    $this->Cell(30, 10, 'Volumen de Gas', 1, 1, 'C', 0);
    $this->Cell(30, 10, 'Frecuencia de Aporte', 1, 1, 'C', 0);
    $this->Cell(30, 10, 'Composicion de la Mezcla', 1, 1, 'C', 0);
    $this->Cell(30, 10, 'Humedad del Aire', 1, 1, 'C', 0);
    $this->Cell(30, 10, 'Temperatura de Entrada', 1, 1, 'C', 0);
    $this->Cell(30, 10, 'Temperatura de Salida', 1, 1, 'C', 0);
    $this->Cell(30, 10, 'Presion de Entrada', 1, 1, 'C', 0);
    $this->Cell(30, 10, 'Presion de Salida', 1, 1, 'C', 0);
}

// Page footer
function Footer()
{
    // Position at 1.5 cm from bottom
    $this->SetY(-15);
    // Arial italic 8
    $this->SetFont('Arial','I',8);
    // Page number
    $this->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,0,'C');
}

//Aca consigo los datos usando el json que usa jean y ni puta idea de como se maneja xd
$idVeMec = ($_GET['variable2']);
$data = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/read_vemecdata?id=$idVeMec"), true);

    
// Creación del objeto de la clase heredada
$pdf = new PDF();
$pdf->AliasNbPages();
$pdf->AddPage();
$pdf->SetFont('Arial','',12);

//aca recorremos los datos y generamos las tablas
while($row = $data->fetch_assoc()){
  $pdf->Cell(90, 10, $row['timestap'], 1, 0, 'C', 0);
  $pdf->Cell(30, 10, $row['presionmaxima'], 1, 0, 'C', 0);
  $pdf->Cell(30, 10, $row['presionminima'], 1, 1, 'C', 0);
  $pdf->Cell(30, 10, $row['volgasaporta'], 1, 0, 'C', 0);
  $pdf->Cell(30, 10, $row['frecaporte'], 1, 1, 'C', 0);
  $pdf->Cell(30, 10, $row['compomezcla'], 1, 0, 'C', 0);
  $pdf->Cell(30, 10, $row['humedadaire'], 1, 1, 'C', 0);
  $pdf->Cell(30, 10, $row['tempentrada'], 1, 0, 'C', 0);
  $pdf->Cell(30, 10, $row['tempsalida'], 1, 1, 'C', 0);
  $pdf->Cell(30, 10, $row['presentrada'], 1, 0, 'C', 0);
  $pdf->Cell(30, 10, $row['pressalida'], 1, 1, 'C', 0);
}

$pdf->Output();
}
?>
