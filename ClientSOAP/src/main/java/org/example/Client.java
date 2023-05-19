package org.example;
import proxy.*;

public class Client {
    public static void main(String[] args) {
        BankService stub = new BankWs().getBankServicePort();
        System.out.println(stub.conversion(50));
        Compte compte= stub.getCompte(2);
        /*
        System.out.println("compteId : "+compte.getId()+"\n" +
                "compteId"+compte.);
         */
        System.out.println(compte);
    }
}