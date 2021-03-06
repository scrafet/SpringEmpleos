package net.scrafet.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.scrafet.model.Vacante;

@Service
public class VacanteServiceImpl implements IVacantesService {
	List<Vacante> lista = null;
	
	public VacanteServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		
		try {
			
			//Oferta de Trabajo N° 1
			Vacante vacante1 = new  Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingenierio Civil"); //Titulo de la vacante 
			vacante1.setDescripcion("Solicitamos Ing. Civil para Puente Peatonal");
			vacante1.setFecha(sdf.parse("01-02-2020"));
			vacante1.setSalario(14000.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("logo2.png");
			
			//Oferta de Trabajo N° 2
			Vacante vacante2 = new  Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico"); //Titulo de la vacante 
			vacante2.setDescripcion("Solicitamos Contador publico");
			vacante2.setFecha(sdf.parse("02-02-2020"));
			vacante2.setSalario(8200.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("logo3.png");
			
			//Oferta de Trabajo N° 3
			Vacante vacante3 = new  Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingenierio Electrico"); //Titulo de la vacante 
			vacante3.setDescripcion("Solicitamos Ingenierio Electrico para grupo de musica electronica");
			vacante3.setFecha(sdf.parse("03-02-2020"));
			vacante3.setSalario(8300.0);
			vacante3.setDestacado(0);
			vacante3.setImagen("no-image.png");
			
			
			//Oferta de Trabajo N° 4
			Vacante vacante4 = new  Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Grafico"); //Titulo de la vacante
			vacante4.setDescripcion("Solicitamos Diseñador Grafico para publicidad de Empresa");
			vacante4.setFecha(sdf.parse("04-02-2020"));
			vacante4.setSalario(8400.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("logo4.png");
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch (java.text.ParseException e) {
			System.out.println("Error : " + e.getMessage());
		}
		
	}

	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		
		for (Vacante v : lista) {
			if (v.getId()== idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
		
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
