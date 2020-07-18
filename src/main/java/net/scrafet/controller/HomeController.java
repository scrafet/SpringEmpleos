package net.scrafet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sun.el.parser.ParseException;

import net.scrafet.model.Vacante;

@Controller
public class HomeController {
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
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
		/*
		model.addAttribute("mensaje", "Bienvenidos a Empleos APP");
		model.addAttribute("fecha", new Date());
		*/
		String nombre = "Auxiliar de Contabilidad"; 
		Date fechaPub = new Date();
		Double salario=9000.0;
		boolean vigente=true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
		return "home";
		
	}
	
	private List<Vacante> getVacantes() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		
		try {
			
			//Oferta de Trabajo N° 1
			Vacante vacante1 = new  Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingenierio Civil"); //Titulo de la vacante 
			vacante1.setDescripcion("Solicitamos Ing. Civil para Puente Peatonal");
			vacante1.setFecha(sdf.parse("01-02-2020"));
			vacante1.setSalario(8100.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			//Oferta de Trabajo N° 2
			Vacante vacante2 = new  Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico"); //Titulo de la vacante 
			vacante2.setDescripcion("Solicitamos Contador publico");
			vacante2.setFecha(sdf.parse("02-02-2020"));
			vacante2.setSalario(8200.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			//Oferta de Trabajo N° 3
			Vacante vacante3 = new  Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingenierio Electrico"); //Titulo de la vacante 
			vacante3.setDescripcion("Solicitamos Ingenierio Electrico para grupo de musica electronica");
			vacante3.setFecha(sdf.parse("03-02-2020"));
			vacante3.setSalario(8300.0);
			vacante3.setDestacado(0);
			
			
			//Oferta de Trabajo N° 4
			Vacante vacante4 = new  Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Grafico"); //Titulo de la vacante
			vacante4.setDescripcion("Solicitamos Diseñador Grafico para publicidad de Empresa");
			vacante4.setFecha(sdf.parse("04-02-2020"));
			vacante4.setSalario(8400.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch (java.text.ParseException e) {
			System.out.println("Error : " + e.getMessage());
		}
		return lista;
	}
}
