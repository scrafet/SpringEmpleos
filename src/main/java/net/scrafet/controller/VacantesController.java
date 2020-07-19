package net.scrafet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		System.out.println("IdVacante : " +  idVacante);
		model.addAttribute("idVacante", idVacante);
		
		//Buscar los datos de la vacante en la base de datos
		
		
		return "vacantes/detalle";
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id")int idVacante,Model model) {
		System.out.println("borrando vacante con id : " + idVacante );
		model.addAttribute("id", idVacante );
		return "mensaje";
	}

}
