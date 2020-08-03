package net.scrafet.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.scrafet.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService {
	List<Categoria> lista = null;
	
	public CategoriasServiceImpl() {
		lista =new LinkedList<Categoria>();
		
		try {
			
			//Categoria 1
			Categoria categoria1 = new Categoria();
			categoria1.setId(1);
			categoria1.setNombre("Ventas");
			categoria1.setDescripcion("Sector de Ventas");
			
			//Categoria 2
			Categoria categoria2 = new Categoria();
			categoria2.setId(2);
			categoria2.setNombre("Contabilidad");
			categoria2.setDescripcion("Sector Bancario , manejo de Cuentas bancarias,transacciones y estados de cuenta");
			
			//Categoria 3
			Categoria categoria3 = new Categoria();
			categoria3.setId(3);
			categoria3.setNombre("Transporte");
			categoria3.setDescripcion("Sector de tranporte de diversos vehiculos aereos, terretres y marinos");
			
			//Categoria 4
			Categoria categoria4 = new Categoria();
			categoria4.setId(4);
			categoria4.setNombre("Informatica");
			categoria4.setDescripcion("Sector de Tecnologia de la Informacion");
			
			//Categoria 5
			Categoria categoria5 = new Categoria();
			categoria5.setId(5);
			categoria5.setNombre("Construccion");
			categoria5.setDescripcion("Sector de diseño planeacion y ejecucion de obras civiles y empresariales");		
			
			//Categoria 6
			Categoria categoria6 = new Categoria();
			categoria6.setId(6);
			categoria6.setNombre("Desarrollo de Software");
			categoria6.setDescripcion("trabajo para programadores");
			
			lista.add(categoria1);
			lista.add(categoria2);
			lista.add(categoria3);
			lista.add(categoria4);
			lista.add(categoria5);
			lista.add(categoria6);
			
			
			
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodas() {
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
	for (Categoria c : lista) {
		if (c.getId() == idCategoria) {
			return c;
		}
	}
		return null;
	}

}
