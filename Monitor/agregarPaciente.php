<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
	<script src="jquery.js" type="text/javascript"></script>
	<script src="./bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="grafica.js" type="text/javascript"></script>
	<link rel="stylesheet" href="./administrarVeMec.css">
	<title>Agregar Paciente</title>
	<meta charset="utf-8">
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
					<a class="nav-link" href="./administrarVeMec.php">Administrar VeMec</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./agregarVeMec.php">Agregar VeMec</a>
				</li>
			</ul>
		</div>
	</nav>
</header>
<body>
	<!-- VeMec - Inicio -->
	<div class="" style="margin: 5%; width: 25%; position: relative; left: 30%; background-color: white; border-radius: 10px; padding: 20px; border-style: solid; border-width: 0.5px; -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);
	-moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);
	box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75); ">
	<form action="insertarPaciente.php" method="POST">
	<div class="row" style="margin-left: 20%;">
		<div class="col-xl-12">
			<label> C.I. </label>
		</div>
		<div class="col-xl-12">
			<input type="text" name="ci">
		</div>
		<div class="col-xl-12" style="margin-top: 10px;">
			<label> Nombre </label>
		</div>
		<div class="col-xl-12">
			<input type="text" name="nombre">
		</div>
		<div class="col-xl-12" style="margin-top: 10px;">
			<label> Apellido </label>
		</div>
		<div class="col-xl-12">
			<input type="text" name="apellido">
		</div>
		<div class="col-xl-12" style="margin-top: 10px;">
			<label> Edad </label>
		</div>
		<div class="col-xl-12">
			<input type="text" name="edad">
		</div>
		<div class="col-xl-12" style="margin-top: 30px; margin-left: 50px;">
			<button type="submit" class="btn btn-success">INGRESAR</button>
		</div>
	</div>
	</form>
</div>
<!-- VeMec - Fin -->	
</body>
</html>