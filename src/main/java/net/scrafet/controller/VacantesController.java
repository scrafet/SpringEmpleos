package net.scrafet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.scrafet.model.Vacante;
import net.scrafet.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacantesService serviceVacantes;

	@GetMapping("/create")
	public String crear(Vacante vacante) {
		return "vacantes/formVacante";
	}

	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError  error: result.getAllErrors()) {
				System.out.println("Ocurrio un Error : " + error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		serviceVacantes.guardar(vacante);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		System.out.println("vacante : " + vacante);
		return "redirect:/vacantes/index";
	}
	
	//probando ejercicios
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> lista=serviceVacantes.buscarTodas();
		model.addAttribute("vacantes",lista);
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
