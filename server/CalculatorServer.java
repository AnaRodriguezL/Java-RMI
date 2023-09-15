package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.CalculatorService;

public class CalculatorServer extends UnicastRemoteObject implements CalculatorService {
    public CalculatorServer() throws RemoteException {
        super();
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            // Iniciar el servidor RMI
            CalculatorService calculator = new CalculatorServer();
            java.rmi.registry.LocateRegistry.createRegistry(3000);
            java.rmi.Naming.rebind("CalculatorService", (Remote) calculator);
            System.out.println("Server started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
