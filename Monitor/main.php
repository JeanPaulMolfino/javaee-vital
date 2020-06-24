<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
	<script src="jquery.js" type="text/javascript"></script>
	<script src="./bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="grafica.js" type="text/javascript"></script>
	<link rel="stylesheet" href="./main.css">

	<title>VeMec</title>
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
					<a class="nav-link" href="./administrarVeMec.php">Administrar VeMec</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./agregarVeMec.php">Agregar VeMec</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./agregarPaciente.php">Agregar Paciente</a>
				</li>
			</ul>
		</div>
	</nav>
</header>
<body>
	<script type="text/javascript">
					var auto_refresh = setInterval(
						function ()
						{
							$('#overlay').load('test2.php');
					    }, 2000); // refresh every 1000 milliseconds
					</script>

	<div class="" id="overlay" style="width: 90%; margin-left: 5%; margin-top: 5%;">
		
	</div>
	
	<!-- VeMec - Inicio -->
	<?php
	$data = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/listallvemecs"), true);
	$id = 'vacio';
	$marca = 'vacio';
	$modelo = 'vacio';
	$ubicacion = 'vacio';
	$paciente = '';
	$condicion = 0;
	foreach($data as $datas)
	{
		foreach($datas as $key => $val)
		{
			if($key == 'id')
			{
				$id = $val;
			}

			if($key == 'marca')
			{
				$marca = $val;
			}
			if($key == 'modelo')
			{
				$modelo = $val;
			}
			if($key == 'ubicacion')
			{
				$ubicacion = $val;
			}
			if($key == 'paciente')
			{
				$paciente = $val;
			}

			if($key == 'paciente')
			{
				?>


				<div class="" style="margin: 5%; width: 90%; background-color: white; border-radius: 10px; padding: 20px; border-style: solid; border-width: 0.5px; -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);
				-moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);
				box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75); ">
				<div class="row">
					<div class="col-xl-12" style=" height: 50px;">
						<div class="row">
							<div class="col-xl-3">
								<label >Paciente: <?php echo implode(' ', explode(' ', $paciente, -1)); ?> </label>
							</div>
							<div class="col-xl-3">
								<label>C.I. : <?php $tmp = explode(' ',$paciente); $final = end($tmp); echo $final; ?> </label>
							</div>
							<div class="col-xl-3">
								<label>Sector VeMec : <?php echo $ubicacion; ?> </label>
							</div>
							<div class="col-xl-3">
								<label>ID VeMec : <?php echo $id; ?> </label>
							</div>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					var auto_refresh = setInterval(
						function ()
						{
							$('#cuadroblanco<?php echo $id ?>').load('test.php?id=<?php echo $id ?>');
					    }, 2000); // refresh every 1000 milliseconds
					</script>
					<div class="row" id="cuadroblanco<?php echo $id ?>">

			</div>
		</div>
		<?php
		$paciente = null;
	}
}
}
?>
<!-- VeMec - Fin -->	
</body>
</html>