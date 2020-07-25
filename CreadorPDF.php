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
    
$this->SetFillColor(255,0,0);
$this->SetTextColor(255);
$this->SetDrawColor(128,0,0);
$this->SetLineWidth(.3);
$this->SetFont('','B');  
$pdf->Cell(90, 10, "Nombre", 1, 0, 'C', 0);
$this->SetFillColor(224,235,255);
$this->SetTextColor(0);
$this->SetFont('');
$pdf->Cell(30, 10, $data['nombre'], 1, 0, 'C', 0);

$pdf->Cell(12);
    
$this->SetFillColor(255,0,0);
$this->SetTextColor(255);
$this->SetDrawColor(128,0,0);
$this->SetLineWidth(.3);
$this->SetFont('','B');
$pdf->Cell(30, 10, "Apellido", 1, 1, 'C', 0);
$this->SetFillColor(224,235,255);
$this->SetTextColor(0);
$this->SetFont('');
$pdf->Cell(30, 10, $data['apellido'], 1, 0, 'C', 0);
  
//grafico
$this->Image($graficaURL,10,6,30);
    
}
$pdf->Output();
}
?>
