package net.scrafet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.scrafet.model.Vacante;
import net.scrafet.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacantesService serviceVacantes;

	@GetMapping("/create")
	public String crear() {
		return "vacantes/formVacante";
	}

	@PostMapping("/save")
	public String guardar(Vacante vacante) {
		serviceVacantes.guardar(vacante);
		System.out.println("vacante : " + vacante);
		return "vacantes/listVacantes";
	}
//	
//	@PostMapping("/save")
//	public String guardar(@RequestParam("nombre") String nombre,
//			@RequestParam("descripcion") String descripcion,
//			@RequestParam("estatus") String estatus,
//			@RequestParam("fecha") String fecha,
//			@RequestParam("destacado") int destacado,
//			@RequestParam("salario") double salario,
//			@RequestParam("detalles") String detalles) {
//		System.out.println("Nombre vacante : " + nombre);
//		System.out.println("Descripcion : " + descripcion);
//		System.out.println("Estatus : " + estatus);
//		System.out.println("Fecha Publicacion : " + fecha);
//		System.out.println("Destacado : " + destacado);
//		System.out.println("Salario Ofrecido : " + salario);
//		System.out.println("detalles : " + detalles);		
//		return "vacantes/listVacantes";
//	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);

		System.out.println("vacante : " + vacante);
		model.addAttribute("vacante", vacante);

		// Buscar los datos de la vacante en la base de datos

		return "detalle";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("borrando vacante con id : " + idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
