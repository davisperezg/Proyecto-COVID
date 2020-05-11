package com.proyecto.apis;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.entity.Ciudadanos;
import com.proyecto.entity.Triaje;
import com.proyecto.service.CiudadanosService;

@Controller
@RequestMapping(value = "api")
public class ApiController {
	/*
	 * @RestController
		@RequestMapping(CountryRestController.COUNTRY_RESOURCE)
		public class CountryRestController {
     
    		public static final String COUNTRY_RESOURCE = "/api/country";
    		@GetMapping(value = "/{id}/")
			public ResponseEntity<Country> getById(@PathVariable("id") Long id) {
			    Optional<Country> country = countryService.findById(id);
			    if (country.isPresent()) {
			        return new ResponseEntity<>(country.get(), HttpStatus.OK);
			    }
			    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
	 * */
	@Autowired
	CiudadanosService ciudadanosService;
	
	@GetMapping("/listTriaje")
	public @ResponseBody Map<String, Object> listaCiudadanos(){
		Map<String, Object> map=new HashMap<String,Object>();
		List<Triaje> lista=ciudadanosService.listaCiudadanos();
		map.put("dataCiudadano", lista);
		return map;
	}
	
	@PostMapping("/saveCiudadano")
	public ResponseEntity<Ciudadanos> addCiudadano(@RequestBody Ciudadanos ciuda) {
		Ciudadanos obj = ciudadanosService.registrarActualizaCiudadano(ciuda);
		return new ResponseEntity<Ciudadanos>(obj, HttpStatus.OK);
	}
	
	@PostMapping("/saveTriajeCiudadano")
	public ResponseEntity<Triaje> addTriajeCiudadano(@RequestBody Triaje ciuda) {
		Triaje obj = ciudadanosService.registrarTriaje(ciuda);
		return new ResponseEntity<Triaje>(obj, HttpStatus.OK);
	}
}
