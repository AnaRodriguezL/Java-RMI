package server;

import java.rmi.Remote;

import shared.CalculatorService;

public class ServerMain {
    /**
     * Main method of the server. It creates the registry in the specified port
     * and binds the remote object to the registry.
     *
     * @param args
     *            not used
     */
    public static void main(String[] args) {
        try {
            // Create the remote object that will handle the requests
            CalculatorService calculator = new CalculatorServer();

            // Create the RMI registry in the specified port (3000)
            java.rmi.registry.LocateRegistry.createRegistry(3000);

            // Bind the remote object to the registry with the given name
            java.rmi.Naming.rebind("CalculatorService", (Remote) calculator);

            System.out.println("Server started...");
        } catch (Exception e) {
            // Print the stack trace if something goes wrong
            e.printStackTrace();
        }
    }

}
