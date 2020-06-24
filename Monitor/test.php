<?php
$id = $_GET['id'];
						$datab = json_decode( file_get_contents("http://localhost:8080/WebService/resources/javaee8/read_vemecdata_3minutes?id=$id"), true);
						?>
						<?php
						if(!empty($datab))
						{
							$presiondeentrada = '[';
							$presiondesalida = '[';
							$i=0;
							foreach($datab as $varb){
							$presiondeentrada.= '['.$i.','.$varb['presentrada'].'] ';
							$presiondesalida.= '['.$i.','.$varb['pressalida'].'] ';
							if($varb != end($datab)){
							$presiondeentrada.=',';
							$presiondesalida.=',';
							$i = $i + 2;
						}
					}
					$presiondeentrada.=']';
					$presiondesalida.=']';
					?>
					<div class="col-xl-6" style="height: 400px; ">
						<div class="row" style=" height: 200px;">
							<div class="col-xl-12" id="chart_div<?php echo $id ?>">

							</div>
						</div>
						<div class="row" style=" height: 200px;">
							<div class="col-xl-12" id="chart_div1<?php echo $id ?>">

							</div>
						</div>
					</div>

					<script type="text/javascript">

						google.charts.load('current', {packages: ['corechart', 'line']});
						google.charts.setOnLoadCallback(drawBasic<?php echo $id ?>);
						google.charts.setOnLoadCallback(drawBasic1<?php echo $id ?>);


						function drawBasic<?php echo $id ?>() {

							var data = new google.visualization.DataTable();
							data.addColumn('number', 'X');
							data.addColumn('number', 'Presion Entrada');


							data.addRows(<?php echo $presiondeentrada ?>);

							var options = {
								hAxis: {
									title: 'Tiempo (seg)'
								},
								vAxis: {
									title: 'Presion (mmHg)'
								}
							};

							var chart = new google.visualization.LineChart(document.getElementById('chart_div<?php echo $id ?>'));

							chart.draw(data, options);
						}

						function drawBasic1<?php echo $id ?>() {

							var data = new google.visualization.DataTable();
							data.addColumn('number', 'X');
							data.addColumn('number', 'Presion Salida');

							data.addRows(<?php echo $presiondesalida ?>);

							var options = {
								hAxis: {
									title: 'Tiempo (seg)'
								},
								vAxis: {
									title: 'Presion (mmHg)'
								}
							};

							var chart = new google.visualization.LineChart(document.getElementById('chart_div1<?php echo $id ?>'));

							chart.draw(data, options);
						}


					</script>
					<div class="col-xl-6" style="height: auto; ">

						<table class="table">
							<thead>
								<tr>
									<td>Presion Maxima</td>
									<td> <?php echo end($datab)['presionmaxima'] ?> mmHg</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Presion Minima</td>
									<td> <?php echo end($datab)['presionminima'] ?> mmHg</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Volumen de Gas</td>
									<td> <?php echo end($datab)['volgasaporta'] ?> cc</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Frecuencia de Aporte</td>
									<td> <?php echo end($datab)['frecaporte'] ?> /min</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Mezcla en %O2</td>
									<td> <?php echo end($datab)['compomezcla'] ?> %</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Humedad de aire</td>
									<td> <?php echo end($datab)['humedadaire'] ?> %</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Temp. entrada</td>
									<td> <?php echo end($datab)['tempentrada'] ?> °C</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Temp. salida</td>
									<td> <?php echo end($datab)['tempsalida'] ?> °C</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Presion de Entrada</td>
									<td> <?php echo end($datab)['presentrada'] ?> mmHg</td>
								</tr>
							</thead>
							<thead>
								<tr>
									<td>Presion de Salida</td>
									<td> <?php echo end($datab)['pressalida'] ?> mmHg</td>
								</tr>
							</thead>

						</table>

					</div>
					<?php
				}
				?>