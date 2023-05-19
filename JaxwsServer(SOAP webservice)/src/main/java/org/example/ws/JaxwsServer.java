package org.example.ws;


import jakarta.xml.ws.Endpoint;

public class JaxwsServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8089/",new BankService());
    }
}
