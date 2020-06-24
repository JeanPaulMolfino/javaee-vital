<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
	<script src="jquery.js" type="text/javascript"></script>
	<script src="./bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="grafica.js" type="text/javascript"></script>
	<link rel="stylesheet" href="./administrarVeMec.css">
	<link rel="stylesheet" href="hint.css">
	<title>Administrar VeMec</title>
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

<!-- VeMec - Inicio -->
<div class="" style="margin: 5%; width: 90%;  background-color: white; border-radius: 10px; padding: 20px; border-style: solid; border-width: 0.5px; -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);
-moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);
box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75); ">
<div class="table-wrapper-scroll-y my-custom-scrollbar">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">ID</th>
				<th scope="col">Marca</th>
				<th scope="col">Modelo</th>
				<th scope="col">Sector Hospital</th>
				<th scope="col">Paciente</th>
				<th scope="col">Funciones</th>
			</tr>
		</thead>
		<tbody>
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

					if($key == 'ubicacion')
					{
						?>
						<form action="modificarVeMec.php" method="POST">
						<tr>
							<th scope="row"> <?php echo $id ?> </th>
							<td> <input type="text" name="id" value="<?php echo $id ?>" readonly > </td>
							<td> <input type="text" name="marca" value="<?php echo $marca ?>"> </td>
							<td> <input type="text" name="modelo" value="<?php echo $modelo ?>"> </td>
							<td> <input type="text" name="ubicacion" value="<?php echo $ubicacion ?>"> </td>
							<td> <?php echo $paciente ?> </td>
							<td width="23%;"> 
								<span class="hint--top" data-hint="Remplace los valores deseados y luego haz click en Modificar Datos VeMec">
									<button style="margin-top: 5px;" type="submit" onclick="location.reload()" class="btn btn-primary">Modificar Datos VeMec</button> 
								</span>
								<a style="text-decoration: none;" href="borrarVeMec.php?variable=<?php echo $id; ?>"> <button style="margin-top: 5px;" type="button" onclick="location.reload()" class="btn btn-danger">Eliminar VeMec</button> </a>

								<a style="text-decoration: none;" href="historialVeMec.php?variable2=<?php echo $id; ?>"> <button type="button" class="btn btn-info" style="margin-top: 5px;">Historial VeMec</button> </a>
							</td>
						</tr>
						</form>
						<?php
						$paciente = null;
					}
				}
			}
			?>
		</tbody>
	</table>
</div>
</div>
<!-- VeMec - Fin -->	
</body>
</html>