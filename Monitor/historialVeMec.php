<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
	<script src="jquery.js" type="text/javascript"></script>
	<script src="./bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="grafica.js" type="text/javascript"></script>
	<link rel="stylesheet" href="./administrarVeMec.css">
	<title>Historial VeMec</title>
	<meta charset="utf-8">
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable();
		} );
	</script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
</head>
<header style="height: auto; width: 100%;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item">
					<a class="nav-link" href="./main.php">Monitores Pacientes</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./agregarVeMec.php">Agregar VeMec</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./agregarPaciente.php">Agregar Paciente</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./administrarVeMec.php">Administrar VeMec</a>
				</li>
			</ul>
		</div>
	</nav>
</header>
<body style="background-color: #29e1e2">

	<!-- VeMec - Inicio -->
	<div class="" style="margin: 5%; width: 90%;  background-color: white; border-radius: 10px; padding: 20px; border-style: solid; border-width: 0.5px; -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);
	-moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);
	box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75); ">
	<table id="example" class="table table-striped table-bordered" style="width:90%">
		<thead>
			<tr>
				<th>Fecha</th>
				<th>Presion Maxima</th>
				<th>Presion Minima</th>
				<th>Volumen de Gas Aportado</th>
				<th>Frecuencia de Aporte</th>
				<th>Composicion de la Mezcla</th>
				<th>Humedad del Aire</th>
				<th>Temperatura de Entrada</th>
				<th>Temperatura de Salida</th>
				<th>Presion de Entrada</th>
				<th>Presion de Salida</th>
			</tr>
		</thead>
		<tbody>
			<?php
			$idVeMec = ($_GET['variable2']);

			$data = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/read_vemecdata?id=$idVeMec"), true);
			$fecha;
			$presmax;
			$presmin;
			$volgas;
			$frecapo;
			$compmez;
			$humedadaire;
			$tempin;
			$tempout;
			$presin;
			$presout;

			foreach($data as $datas)
			{
				foreach($datas as $key => $val)
				{
				if($key == 'timestap')
				{
					$fecha = $val;
				}
				if($key == 'presionmaxima')
				{
					$presmax = $val;
				}
				if($key == 'presionminima')
				{
					$presmin = $val;
				}
				if($key == 'volgasaporta')
				{
					$volgas = $val;
				}
				if($key == 'frecaporte')
				{
					$frecapo = $val;
				}
				if($key == 'compomezcla')
				{
					$compmez = $val;
				}
				if($key == 'humedadaire')
				{
					$humedadaire = $val;
				}
				if($key == 'tempentrada')
				{
					$tempin = $val;
				}
				if($key == 'tempsalida')
				{
					$tempout = $val;
				}
				if($key == 'presentrada')
				{
					$presin = $val;
				}
				if($key == 'pressalida')
				{
					$presout = $val;
				}
				if($key == 'pressalida')
				{
					?>
			<tr>
				<td> <?php echo $fecha ?> </td>
				<td> <?php echo $presmax ?> </td>
				<td> <?php echo $presmin ?> </td>
				<td> <?php echo $volgas ?> </td>
				<td> <?php echo $frecapo ?> </td>
				<td> <?php echo $compmez ?> </td>
				<td> <?php echo $humedadaire ?> </td>
				<td> <?php echo $tempin ?> </td>
				<td> <?php echo $tempout ?> </td>
				<td> <?php echo $presin ?> </td>
				<td> <?php echo $presout ?> </td>
			</tr>
			<?php
				}
				}
			}
			?>
		</tbody>
		<tfoot>
			<tr>
				<th>Fecha</th>
				<th>Presion Maxima</th>
				<th>Presion Minima</th>
				<th>Volumen de Gas Aportado</th>
				<th>Frecuencia de Aporte</th>
				<th>Composicion de la Mezcla</th>
				<th>Humedad del Aire</th>
				<th>Temperatura de Entrada</th>
				<th>Temperatura de Salida</th>
				<th>Presion de Entrada</th>
				<th>Presion de Salida</th>
			</tr>
		</tfoot>
	</table>
</div>
</div>
<!-- VeMec - Fin -->	
</body>
</html>