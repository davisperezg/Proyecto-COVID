package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Ciudadanos;
import com.proyecto.entity.Triaje;
import com.proyecto.entity.Usuarios;

public interface CiudadanosService {
	Ciudadanos registrarActualizaCiudadano(Ciudadanos c);
	Triaje registrarTriaje(Triaje c);
	List<Triaje> listaCiudadanos();
	Triaje findCiudadanos(int cod);
	//acceso admin
	Usuarios loginSistema(String pLogin, String pContrasenia);
}