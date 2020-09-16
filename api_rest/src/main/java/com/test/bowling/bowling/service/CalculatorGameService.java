package com.test.bowling.bowling.service;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.bowling.bowling.dto.RequestCalculatorDTO;
import com.test.bowling.bowling.dto.ResponseGenericDTO;

@Service
public class CalculatorGameService {
	
	final Logger logger = Logger.getLogger(this.getClass());
	
	public ResponseGenericDTO getScored(RequestCalculatorDTO dto) {
		
		try {
			String[] points = dto.getGame();
			int scored = calculateScore(points);
			return new ResponseGenericDTO(scored,true,"OK",HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getScored ERROR: " + e.getMessage());
			return new ResponseGenericDTO(-0,false,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    public int calculateScore(String[] points) {
        int total = 0;
        int inc = 0;
        int roll = 0;
        int[] rolls = new int[21];

		for(String game : points) {
			for (int i=0; i<game.length(); i++) {
				switch (game.charAt(i)) {
				case 'X':
					rolls[roll++] = 10;
					break;
				case '/':
					rolls[roll++] = 10;
					break;
				case '-':
					rolls[roll--] = 1;
					break;
				default:
	                int x = game.charAt(i);
	                rolls[roll++] = x - '0';
	                break;
				}
			}
		}
		

        for (int j = 0; j < 10; j++) {
            if (rolls[inc] == 10) { 
            	total += 10 + rolls[inc+1] + rolls[inc+2];
            	inc ++;
            } else if (rolls[inc] + rolls[inc+1] == 10) { 
            	total += 10 + rolls[inc+2];
            	inc += 2;
            } else {
                total += rolls[inc] + rolls[inc+1];
                inc += 2;
            }
        }
        return total;
    }
    	
}
