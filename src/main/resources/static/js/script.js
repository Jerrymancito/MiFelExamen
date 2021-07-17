function mostrarDetalle(idAfiliacion) {
	$.ajax({
		url: "/api/afiliaciones/" + idAfiliacion, success: function(result) {
			console.log(result)
			var detalle = "<div class='row'><div class='col'>Número de Afiliación: </div><div class='col'>" + result.idAfiliacion + "</div></div></div>";
			detalle = detalle + "<div class='row'><div class='col'>Fecha Alta: </div><div class='col'>" + result.fechaAlta + "</div></div></div>";
			detalle = detalle + "<div class='row'><div class='col'>Usuario: </div><div class='col'>" + result.usuario + "</div></div></div>";
			detalle = detalle + "<div class='row'><div class='col'>Fecha Autorización: </div><div class='col'>" + result.fechaAutorizacion + "</div></div></div>";
			detalle = detalle + "<div class='row'><div class='col'>Fecha Modificación: </div><div class='col'>" + result.fechaModificacion + "</div></div></div>";
			detalle = detalle + "<div class='row'><div class='col'>Fecha Solicitud: </div><div class='col'>" + result.fechaSolicitud + "</div></div></div>";
			detalle = detalle + "<div class='row'><div class='col'>Banco: </div><div class='col'>" + result.idBanco + "</div></div></div>";
			detalle = detalle + "<div class='row'><div class='col'>Estatus: </div><div class='col'>" + result.idEstatus + "</div></div></div>";
			detalle = detalle + "<div class='row'><div class='col'>Sobre Tasa: </div><div class='col'>" + result.idSobreTasa + "</div></div></div>";
			if (result.terminales.length > 0) {
				var terminales = "<div class='row'>";
				for (var i = 0; i < result.terminales.length; i++) {
					terminales = terminales + "<div class='row'><div class='col'>ID Terminal: </div><div class='col'>" + result.terminales[i].idTerminal + "</div></div>";
					terminales = terminales + "<div class='row'><div class='col'>Marca: </div><div class='col'>" + result.terminales[i].marca + "</div></div>";
					terminales = terminales + "<div class='row'><div class='col'>Modelo: </div><div class='col'>" + result.terminales[i].modelo + "</div></div>";
					terminales = terminales + "<div class='row'><div class='col'>Número Servicio: </div><div class='col'>" + result.terminales[i].numServicio + "</div></div>";
				}
				terminales = terminales + "</div>";
				detalle = detalle + "<div class='row mt-5'><div class='col text-success'>Terminales Asociadas: </div><div class='col'>" + terminales + "</div></div></div>";
			} else {
				detalle = detalle + "<div class='row mt-5'><div class='col text-danger'>Sin terminales Asociadas.</div></div></div>";
			}

			$("#detalle-afiliacion").html(detalle);
		}
	});
}
function buscarAfiliacion() {
	var afiliacion = {
		usuario: $("#usuario").val(),
		idAfiliacion: $("#idAfiliacion").val(),
		fechaSolicitud: $("#fechaSolicitud").val(),
		fechaAutorizacion: $("#fechaAutorizacion").val(),
	}
	if (afiliacion.usuario == "" && afiliacion.fechaAutorizacion == "" && afiliacion.fechaSolicitud == "" && afiliacion.idAfiliacion == "") {
		$("#detalle-afiliacion").html("<p class='text-warning'>Ingresa un criterio de búsqueda.</p>");
		return;
	}
	$.ajax({
		type: "POST",
		dataType: 'json',
		url: "/api/afiliaciones",
		contentType: "application/json",
		data: JSON.stringify(afiliacion),
		success: function(result) {
			console.log(result)
			var detalle = "";
			if (result.length > 0) {
				for (var i = 0; i < result.length; i++) {
					detalle = "<div class='row'><div class='col'>Número de Afiliación: </div><div class='col'>" + result[i].idAfiliacion + "</div></div></div>";
					detalle = detalle + "<div class='row'><div class='col'>Fecha Alta: </div><div class='col'>" + result[i].fechaAlta + "</div></div></div>";
					detalle = detalle + "<div class='row'><div class='col'>Usuario: </div><div class='col'>" + result[i].usuario + "</div></div></div>";
					detalle = detalle + "<div class='row'><div class='col'>Fecha Autorización: </div><div class='col'>" + result[i].fechaAutorizacion + "</div></div></div>";
					detalle = detalle + "<div class='row'><div class='col'>Fecha Modificación: </div><div class='col'>" + result[i].fechaModificacion + "</div></div></div>";
					detalle = detalle + "<div class='row'><div class='col'>Fecha Solicitud: </div><div class='col'>" + result[i].fechaSolicitud + "</div></div></div>";
					detalle = detalle + "<div class='row'><div class='col'>Banco: </div><div class='col'>" + result[i].idBanco + "</div></div></div>";
					detalle = detalle + "<div class='row'><div class='col'>Estatus: </div><div class='col'>" + result[i].idEstatus + "</div></div></div>";
					detalle = detalle + "<div class='row'><div class='col'>Sobre Tasa: </div><div class='col'>" + result[i].idSobreTasa + "</div></div></div>";
					if (result[i].terminales.length > 0) {
						var terminales = "<div class='row'>";
						for (var j = 0; j < result[i].terminales.length; j++) {
							terminales = terminales + "<div class='row'><div class='col'>ID Terminal: </div><div class='col'>" + result[i].terminales[j].idTerminal + "</div></div>";
							terminales = terminales + "<div class='row'><div class='col'>Marca: </div><div class='col'>" + result[i].terminales[j].marca + "</div></div>";
							terminales = terminales + "<div class='row'><div class='col'>Modelo: </div><div class='col'>" + result[i].terminales[j].modelo + "</div></div>";
							terminales = terminales + "<div class='row'><div class='col'>Número Servicio: </div><div class='col'>" + result[i].terminales[j].numServicio + "</div></div>";
						}
						terminales = terminales + "</div>";
						detalle = detalle + "<div class='row mt-5'><div class='col text-success'>Terminales Asociadas: </div><div class='col'>" + terminales + "</div></div></div>";
					} else {
						detalle = detalle + "<div class='row mt-5'><div class='col text-danger'>Sin terminales Asociadas.</div></div></div>";
					}
				}
			} else {
				detalle = "<p class='text-danger'>Sin resultados.</p>"
			}
			$("#detalle-afiliacion").html(detalle);
		}
	});
}