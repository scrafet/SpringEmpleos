package net.scrafet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sun.el.parser.ParseException;

import net.scrafet.model.Vacante;
import net.scrafet.service.ICategoriasService;
import net.scrafet.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private ICategoriasService serviceCategorias;
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "tabla";		
	}
	
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante= new Vacante();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se solocita Ingeniero para dar soporte a Intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacante",vacante);
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingenierio de Sistemas");
		lista.add("auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		return "listado";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
//		List<Vacante> lista = serviceVacantes.buscarTodas();
//		model.addAttribute("vacantes", lista); - Ahora se carga desde el ,metodo setGenericos que nos
//      brinda u model para toda la clases gracias a la anotacion @ModelAttribute		
		return "home";
		
	}
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search")Vacante vacante, Model model) {
		System.out.println("Buscando por : " + vacante);
		/**
		 * La siguiente sentencia en sql seria:
		 * where Descripcion like %?%
		 */
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<Vacante> example = Example.of(vacante, matcher);
		List<Vacante> lista = serviceVacantes.buscarByExample(example);
		model.addAttribute("vacantes", lista);
		return "home";
	}
	
	/**
	 * 
	 * @param model
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
		
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		Vacante vacanteSearch= new Vacante();
		vacanteSearch.reset();
		model.addAttribute("vacantes", serviceVacantes.buscarDestacadas());
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
		model.addAttribute("search", vacanteSearch);
	}
	
	
}
