package com.test.bowling.bowling.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.bowling.bowling.dto.RequestCalculatorDTO;
import com.test.bowling.bowling.dto.ResponseGenericDTO;
import com.test.bowling.bowling.service.CalculatorGameService;

/**
 * Creado por Cesar Ramirez candresramirez@gmail.com  12/08/2020.
 * Clase controlador donde se especifican los endpoint del api rest
 *
 */

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/v1/calculator")
public class CalculatorGameController {

	final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private CalculatorGameService service;
	
	/**
	 * Este método se encarga de recibir los datos (puntos) del juego de bowling
	 * @author Cesar Ramirez
	 * @param JSON {"game":[]}
	 * @return DTO {"data": int, "success": boolean,"message": String,"status": HttpStatus}
	*/
	@PostMapping("/scored")
	public ResponseGenericDTO scored(@RequestBody RequestCalculatorDTO dto) {
		logger.info("CalculatorGameController - scored " + dto);
		return service.getScored(dto);

	}
}
