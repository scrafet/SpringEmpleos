package net.scrafet.service.db;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import net.scrafet.model.Categoria;
import net.scrafet.repository.CategoriasRepository;
import net.scrafet.service.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {
	
	@Autowired
	private CategoriasRepository categoriasRepo;

	public void guardar(Categoria categoria) {
		categoriasRepo.save(categoria);
	}

	public List<Categoria> buscarTodas() {		
		return categoriasRepo.findAll();
	}

	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;  
	}

	public void eliminar(Integer idCategoria) {
		categoriasRepo.deleteById(idCategoria);
	}

}
