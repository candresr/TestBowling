package com.test.bowling.bowling.service;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.bowling.bowling.dto.RequestCalculatorDTO;
import com.test.bowling.bowling.dto.ResponseGenericDTO;

@Service
public class CalculatorGameService {
	
	final Logger logger = Logger.getLogger(this.getClass());
    private int roll = 0;
    private int[] rolls = new int[21];
	
	
	public ResponseGenericDTO getScored(RequestCalculatorDTO dto) {

		try {
			String[] points = dto.getGame();
			for(String pin : points) {
				converGame(pin);
			}
			return new ResponseGenericDTO(calculateScore(),true,"OK",HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getScored ERROR: " + e.getMessage());
			return new ResponseGenericDTO(0000,false,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public void converGame(String game) {
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
	
    public int calculateScore() {
        int total = 0;
        int inc = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (calculateStrike(inc)) { 
            	total += 10 + rolls[inc+1] + rolls[inc+2];
            	inc ++;
            } else if (calculateSpare(inc)) { 
            	total += 10 + rolls[inc+2];
            	inc += 2;
            } else {
                total += rolls[inc] + rolls[inc+1];
                inc += 2;
            }
        }
        return total;
    }
    
    private boolean calculateStrike(int inc) {
        return rolls[inc] == 10;
    }

    private boolean calculateSpare(int inc) {
        return rolls[inc] + rolls[inc+1] == 10;
    }
	
	
}
