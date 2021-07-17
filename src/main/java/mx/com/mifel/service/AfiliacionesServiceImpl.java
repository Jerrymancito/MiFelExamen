package mx.com.mifel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mx.com.mifel.entity.Afiliacion;

@Service
public class AfiliacionesServiceImpl implements AfiliacionesService {
	@Autowired
	private AfiliacionesRepository repo;

	@Override
	public List<Afiliacion> getAfilicaciones() {
		return repo.findAll();
	}

	@Override
	public Afiliacion getAfilicacionesById(long idAfiliacion) {
		Optional<Afiliacion> afiliacion = repo.findById(idAfiliacion);
		if (afiliacion.isPresent()) {
			return afiliacion.get();
		}
		return null;
		
	}

	@Override
	public Page<Afiliacion> getAfilicacionesPag() {
		PageRequest sortedByName = PageRequest.of(0, 100, Sort.by("idAfiliacion"));
		return repo.findAll(sortedByName);
	}

	@Override
	public List<Afiliacion> findAfilicaciones(Afiliacion a) {
		if (a.getUsuario().equals("")) {
			a.setUsuario(null);
		}
		return repo.findAfiliaciones(a.getUsuario(), a.getFechaSolicitud(), a.getFechaAutorizacion(),
				a.getIdAfiliacion());
	}

}
