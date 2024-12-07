package com.teamai.hackitall.instorepicking;

import java.io.IOException;
import java.util.List;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ConfirmationHandler implements HttpHandler {
    private int currentIndex = 0; // Track the current item

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            // Read confirmation from Node-RED
            String response = new String(exchange.getRequestBody().readAllBytes());
            System.out.println("Received confirmation from Node-RED: " + response);

            // Get the optimized list from CalcPath
            List<String> inputs = CalcPath.getOptimizedOrder();

            if ("next".equalsIgnoreCase(response.trim())) {
                if (currentIndex < inputs.size()) {
                    // Process the current item in the list
                    String currentInput = inputs.get(currentIndex);
                    System.out.println("Optimized Pick Order: " + currentInput);
                    currentIndex++;

                    // Send a response back to Node-RED
                    exchange.sendResponseHeaders(200, currentInput.length());
                    exchange.getResponseBody().write(currentInput.getBytes());
                } else {
                    // No more items to process
                    String reply = "Toate produsele au fost adaugate.";
                    exchange.sendResponseHeaders(200, reply.length());
                    exchange.getResponseBody().write(reply.getBytes());
                }
            }
            exchange.getResponseBody().close();
        }
    }
}
