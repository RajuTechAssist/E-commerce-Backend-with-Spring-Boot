package com.ecom.ECom.Services;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RazorpayService {

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;

	private RazorpayClient razorpayClient;

    public RazorpayService() throws RazorpayException {
    	
    	 System.out.println("Razorpay API Key: " + apiKey);
    	    System.out.println("Razorpay API Secret: " + apiSecret);
        // Initialize Razorpay client with API key and secret
        razorpayClient = new RazorpayClient("rzp_test_Ouzx4OoJEiND5Z", "hKI7pbTgesxzgOPIh4bZ4Azb");
    }

    public Order createRazorpayOrder(String string, Double double1, Double amount, String currency) throws RazorpayException {
        // Convert amount to the lowest denomination (e.g., paise for INR)
        Map<String, Object> orderRequest = new HashMap<>();
     // Convert amount from double to the lowest denomination (e.g., paise for INR)
        orderRequest.put("amount", (int) (amount * 100));
        orderRequest.put("currency", currency);

        // Create the order in Razorpay
        return razorpayClient.orders.create(new JSONObject(orderRequest));
    }

    // Additional Razorpay-related methods as needed
}
