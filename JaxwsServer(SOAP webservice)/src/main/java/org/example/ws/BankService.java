package org.example.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

//POJO: Plain Old Java Object
@WebService(serviceName = "BankWs")
public class BankService {
    @WebMethod(operationName = "Conversion")
    public double conversion(@WebParam(name = "montant") double mt){
        return mt*50;
    }

    @WebMethod(operationName = "GetCompte")

    public Compte GetCompte(@WebParam(name = "id") int id){
        return new Compte(id,50+Math.random()*1000,new Date());
    }

    @WebMethod(operationName = "CompteList")

    public List<Compte> compteList(){
        return List.of(new Compte(1,50+Math.random()*1000,new Date()),
        new Compte(2,50+Math.random()*1000,new Date()),
        new Compte(3,50+Math.random()*1000,new Date())
        );
    }

}