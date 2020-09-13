package net.scrafet.service;

import java.util.List;

import net.scrafet.model.Usuario;

public interface IUsuariosService {
	List<Usuario> buscarTodos();
//	Usuario buscarPorId(Integer idVacante);
	void guardar(Usuario vacante);
//	List<Usuario> buscarDestacadas();
	void eliminar(Integer idVacante);
	
	Usuario buscarPorUsername(String username);
}
