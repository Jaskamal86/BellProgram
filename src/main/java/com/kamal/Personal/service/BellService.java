package com.kamal.Personal.service;

import org.springframework.stereotype.Service;

@Service
public class BellService {
	
	int finalPrice = 0;

	public static String SERVER_A = "SERVER_A";
	public static String SERVER_B = "SERVER_B";
	public static int SERVER_A_PRICE = 10000;
	public static int SERVER_B_PRICE = 5000;
	
	public Integer submitOrder(int countA, int countB) {
		
		if (countA == 0 && countB != 0) {
			
			finalPrice = SERVER_B_PRICE * countB;
		
		} else if (countA != 0 && countB == 0) {
		
			finalPrice = SERVER_A_PRICE * countA;
		
		} else if (countA != 0 && countB != 0) {
		
			finalPrice = SERVER_A_PRICE * countA + SERVER_B_PRICE * countB;
		}
		
		return finalPrice;
	}
}