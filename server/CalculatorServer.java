package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.CalculatorService;

public class CalculatorServer extends UnicastRemoteObject implements CalculatorService {
    public CalculatorServer() throws RemoteException {
        super();
    }

    /**
     * Adds two numbers.
     * 
     * @param a The first number to add
     * @param b The second number to add
     * @return The result of the addition
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts two numbers.
     * 
     * @param a The minuend
     * @param b The subtrahend
     * @return The result of the subtraction
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     * @param a The first factor
     * @param b The second factor
     * @return The product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides two numbers.
     * @param a The dividend
     * @param b The divisor
     * @return The result of the division
     * @throws RemoteException If the divisor is zero
     */
    public int divide(int a, int b) throws RemoteException {
        if (b == 0) { // Check that the divisor is not zero
            throw new RemoteException("Cannot divide by zero"); // Raise an exception if it is
        }
        return a / b; // Perform the division
    }


    /**
     * Main method of the server. It creates the registry in the specified port
     * (3000) and binds the remote object to the registry with the given name
     * ("CalculatorService").
     *
     * @param args
     *            not used
     */
    public static void main(String[] args) {
        try {
            // Iniciar el servidor RMI
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
