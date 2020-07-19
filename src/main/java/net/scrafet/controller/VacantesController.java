package net.scrafet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.scrafet.model.Vacante;
import net.scrafet.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService serviceVacantes; 
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante= serviceVacantes.buscarPorId(idVacante);
		
		System.out.println("vacante : " +  vacante);
		model.addAttribute("vacante", vacante);
		
		//Buscar los datos de la vacante en la base de datos
		
		
		return "detalle";
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id")int idVacante,Model model) {
		System.out.println("borrando vacante con id : " + idVacante );
		model.addAttribute("id", idVacante );
		return "mensaje";
	}

}
