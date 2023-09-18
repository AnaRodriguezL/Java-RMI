package client;

import java.rmi.Naming;
import java.util.Scanner;

import shared.CalculatorService;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Obtener una referencia al objeto remoto en el servidor
            CalculatorService calculator = (CalculatorService) Naming.lookup("rmi://localhost/CalculatorService");

            // Configurar un objeto Scanner para la entrada del usuario
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Solicitar al usuario que elija una operación
                System.out.println("Elija una operaci�n:");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicaci�n");
                System.out.println("4. Divisi�n");
                System.out.println("5. Salir");
                System.out.print("Ingrese el n�mero de la operaci�n deseada: ");
                int choice = scanner.nextInt();

                if (choice == 5) {
                    System.out.println("Saliendo del cliente.");
                    break;
                }

                // Solicitar al usuario que ingrese dos n�meros
                System.out.print("Ingrese el primer n�mero: ");
                int num1 = (int) scanner.nextDouble();
                System.out.print("Ingrese el segundo n�mero: ");
                int num2 = (int) scanner.nextDouble();

                int result = 0;

                // Realizar la operaci�n elegida por el usuario
                switch (choice) {
                    case 1:
                        result = calculator.add(num1, num2);
                        break;
                    case 2:
                        result = calculator.subtract(num1, num2);
                        break;
                    case 3:
                        result = calculator.multiply(num1, num2);
                        break;
                    case 4:
                        if (num2 != 0) {
                            result = calculator.divide(num1, num2);
                        } else {
                            System.out.println("No se puede dividir por cero.");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Opci�n no válida.");
                        continue;
                }

                // Mostrar el resultado al usuario
                System.out.println("Resultado: " + result);
            }

            // Cerrar el escaner
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
