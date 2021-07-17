package mx.com.mifel.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.mifel.entity.Afiliacion;

@Repository
public interface AfiliacionesRepository extends JpaRepository<Afiliacion, Long> {
	
	@Query("SELECT a from Afiliacion a WHERE (:usuario IS NULL OR :usuario = a.usuario) and (:fechaSolicitud IS NULL OR a.fechaSolicitud=:fechaSolicitud)"
			+ " AND (:idAfiliacion IS NULL OR a.idAfiliacion = :idAfiliacion) AND (:fechaAutorizacion IS NULL OR a.fechaAutorizacion = :fechaAutorizacion)")
	public List<Afiliacion> findAfiliaciones(String usuario, Date fechaSolicitud, Date fechaAutorizacion, Long idAfiliacion);

}
