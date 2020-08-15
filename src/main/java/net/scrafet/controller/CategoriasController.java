package net.scrafet.controller;

import java.util.List;

import javax.smartcardio.ATR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.scrafet.model.Categoria;
import net.scrafet.model.Vacante;
import net.scrafet.service.ICategoriasService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	
	@Autowired
	//@Qualifier("categoriasServiceJpa")
	private ICategoriasService serviceCategorias;

	// @GetMapping("/index")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> lista=serviceCategorias.buscarTodas();
		model.addAttribute("categorias",lista);
	return "categorias/listCategorias";
	}
	// @GetMapping("/create")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear() {
	return "categorias/formCategoria";
	}
	// @PostMapping("/save")
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un Error : " + error.getDefaultMessage());
			}
			return "categorias/listCategorias";
		}
	serviceCategorias.guardar(categoria);
	attributes.addFlashAttribute("msg","se guardo Correctamente");
	System.out.println("Categoria : " + categoria);
	return "redirect:/categorias/index";
	}
	
}
