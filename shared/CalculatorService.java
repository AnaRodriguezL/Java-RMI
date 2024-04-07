package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for the Calculator service.
 */
public interface CalculatorService extends Remote {
    /**
     * Adds two numbers.
     * @throws RemoteException If a communication problem occurs
     */
    int add(int a, int b) throws RemoteException;

    /**
     * Subtracts two numbers.
     * @throws RemoteException If a communication problem occurs
     */
    int subtract(int a, int b) throws RemoteException;

    /**
     * Multiplies two numbers.
     * @throws RemoteException If a remote communication problem occurs
     */
    int multiply(int a, int b) throws RemoteException;

    /**
     * Divides two numbers.
     * @throws RemoteException If a remote communication problem occurs
     */
    int divide(int a, int b) throws RemoteException;
