package com.test.bowling.bowling;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.test.bowling.bowling.dto.RequestCalculatorDTO;
import com.test.bowling.bowling.dto.ResponseGenericDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BowlingApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port+"/v1/calculator/scored";
	}
	
	
	@Test
	@DisplayName("Test for Calculator Scored")
	public void testCalculatorScored() {
        String[] game =  {"9","1","0","/","X","X","6","2","7","3","8","2","X","9","0","9","1","X"};
		RequestCalculatorDTO dto = new RequestCalculatorDTO();
		dto.setGame(game);
		
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<RequestCalculatorDTO> request = new HttpEntity<>(dto,headers);
		ResponseEntity<ResponseGenericDTO> response = this.restTemplate.postForEntity(getRootUrl(), request, ResponseGenericDTO.class);
		
		assertEquals(true, response.getBody().isSuccess());
		assertEquals(168, response.getBody().getData());
	}

}
