package net.scrafet.service.db;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.scrafet.model.Usuario;
import net.scrafet.repository.UsuariosRepository;
import net.scrafet.service.IUsuariosService;

@Service
public class UsuariosServiceJpa implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	public void eliminar(Integer idUsuario) {
		usuariosRepo.deleteById(idUsuario);
	}

	public List<Usuario> buscarTodos() {
		return usuariosRepo.findAll();
	}

}
