package com.kamal.Personal.service;

import org.springframework.stereotype.Service;

@Service
public class BellService {
	
	int finalPrice = 0;

	public static String SERVER_A = "SERVER_A";
	public static String SERVER_B = "SERVER_B";
	public static int SERVER_A_PRICE = 10000;
	public static int SERVER_B_PRICE = 5000;
	
	public int submitOrder(String firstServer, String secondServer) {
		
		if (SERVER_A.equals(firstServer) && SERVER_B.equals(secondServer)) {
			
			finalPrice = SERVER_A_PRICE + SERVER_B_PRICE;
		
		} else if (SERVER_A.equals(firstServer) && SERVER_A.equals(secondServer)) {
		
			finalPrice = SERVER_A_PRICE * 2;
		
		} else if (SERVER_B.equals(firstServer) && SERVER_B.equals(secondServer)) {
		
			finalPrice = SERVER_B_PRICE * 2;
		}
		
		return finalPrice;
	}
}