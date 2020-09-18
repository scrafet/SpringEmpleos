package net.scrafet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.scrafet.model.Solicitud;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
