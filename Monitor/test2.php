<?php


$data = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/read_alertas"), true);

if(!empty($data))
{
	?>
	
	<table class="table alert alert-danger" role="alert">
		<thead class="thead-dark">
			<tr>
				<th scope="col"></th>
				<th scope="col" style="padding-left: 20%; font-size: 25px;"> <label style="color: #e02d2d;" >ALERTA</label>: Los siguientes pacientes necesitan asistencia medica urgente! </th>
				<th scope="col"></th>
			</tr>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Paciente</th>
				<th scope="col">Ubicacion</th>
			</tr>
		</thead>
		<tbody>
			<?php
			foreach($data as $datas)
			{
				?>
				<tr class="bg-danger">
					<th scope="row"> <label style="font-size: 30px; color: black;"> <?php echo $datas['idvemec'] ?> </label> </th>
					<td> <label style="font-size: 30px; color: black;"> <?php echo $datas['paciente'] ?> </label>  </td>
					<td> <label style="font-size: 30px; color: black;"> <?php echo $datas['ubicacion'] ?> </label> </td>
				</tr>
				<?php
			}
			?>
		</tbody>
	</table>
	<?php
}
?>

