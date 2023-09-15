package server;

import java.rmi.Remote;

import shared.CalculatorService;

public class ServerMain {
    public static void main(String[] args) {
        try {
            CalculatorService calculator = new CalculatorServer();
            java.rmi.registry.LocateRegistry.createRegistry(3000);
            java.rmi.Naming.rebind("CalculatorService", (Remote) calculator);
            System.out.println("Server started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
