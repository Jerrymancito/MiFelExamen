package mx.com.mifel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;

import mx.com.mifel.entity.Afiliacion;

public interface AfiliacionesService {
	
	public List<Afiliacion> getAfilicaciones();
	public Afiliacion getAfilicacionesById(long idAfiliacion);
	public Page<Afiliacion> getAfilicacionesPag();
	public List<Afiliacion> findAfilicaciones(Afiliacion afiliacion);
}
