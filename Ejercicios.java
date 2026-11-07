import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicios {

    private static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }

    private static void comprobarEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("La edad debe ser igual o superior a 18 años.");
        }
        System.out.println("Acceso permitido.");
    }

    private static double calcularRaiz(double numero) {
        if (Double.isNaN(numero) || Double.isInfinite(numero) || numero < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo o no válido.");
        }
        return Math.sqrt(numero);
    }

    private static void validarNota(double nota) {
        if (Double.isNaN(nota) || Double.isInfinite(nota) || nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota debe estar comprendida entre 0 y 10.");
        }
        System.out.println("\nNota introducida correctamente: " + nota);
    }

    private static void limpiarBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private static void ejercicio1(Scanner scanner) {
        System.out.println("===========================================");
        System.out.println("Ejercicio 1");

        try {
            System.out.print("Introduce el primer número: ");
            int num1 = scanner.nextInt();
            limpiarBuffer(scanner);

            System.out.print("Introduce el segundo número: ");
            int num2 = scanner.nextInt();
            limpiarBuffer(scanner);

            int resultado = num1 / num2;
            System.out.println("Resultado: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("\nError: No se puede dividir entre cero.");
        } catch (InputMismatchException e) {
            System.out.println("\nError: Debes introducir números enteros.");
            limpiarBuffer(scanner);
        }

        System.out.println("El programa continúa ejecutándose.");
    }

    private static void ejercicio2(Scanner scanner) {
        System.out.println("===========================================");
        System.out.println("Ejercicio 2");

        try {
            System.out.print("Introduce tu edad: ");
            int edad = scanner.nextInt();
            limpiarBuffer(scanner);
            System.out.println("Tu edad es: " + edad);

        } catch (InputMismatchException e) {
            System.out.println("\nError: Debes introducir un número entero.");
            limpiarBuffer(scanner);
        }
    }

    private static void ejercicio3(Scanner scanner) {
        System.out.println("===========================================");
        System.out.println("Ejercicio 3");

        try {
            System.out.print("Introduce tu edad: ");
            int edad = scanner.nextInt();
            limpiarBuffer(scanner);
            comprobarEdad(edad);

        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("\nError: Debes introducir un número entero.");
            limpiarBuffer(scanner);
        }
    }

    private static void ejercicio4(Scanner scanner) {
        System.out.println("===========================================");
        System.out.println("Ejercicio 4");

        try {
            System.out.print("Introduce un número: ");
            double numero = scanner.nextDouble();
            limpiarBuffer(scanner);
            double raiz = calcularRaiz(numero);
            System.out.println("\nLa raíz cuadrada es: " + raiz);

        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("\nError: Debes introducir un número válido.");
            limpiarBuffer(scanner);
        }
    }

    private static void ejercicio5(Scanner scanner) {
        System.out.println("===========================================");
        System.out.println("Ejercicio 5");

        String titular = "Juan";
        double saldo = 500.0;

        System.out.println("Titular: " + titular);
        System.out.println("Saldo inicial: " + saldo + " €");

        try {
            System.out.print("\nCantidad que desea retirar: ");
            double cantidad = scanner.nextDouble();
            limpiarBuffer(scanner);
            saldo = retirarDinero(saldo, cantidad);
            System.out.println("\nRetirada realizada correctamente.");
            System.out.println("\nSaldo actual: " + saldo + " €");

        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
            System.out.println("\nSaldo actual: " + saldo + " €");
        } catch (SaldoInsuficienteException e) {
            System.out.println("\nError: " + e.getMessage());
            System.out.println("\nSaldo actual: " + saldo + " €");
        } catch (InputMismatchException e) {
            System.out.println("\nError: Debes introducir un número válido.");
            limpiarBuffer(scanner);
        }
    }

    private static void ejercicio6(Scanner scanner) {
        System.out.println("===========================================");
        System.out.println("Ejercicio 6");

        boolean notaValida = false;

        while (!notaValida) {
            try {
                System.out.print("Introduce una nota: ");
                double nota = scanner.nextDouble();
                limpiarBuffer(scanner);
                validarNota(nota);
                notaValida = true;

            } catch (IllegalArgumentException e) {
                System.out.println("\nError: " + e.getMessage() + "\n");
            } catch (InputMismatchException e) {
                System.out.println("\nError: Debes introducir un número válido.");
                limpiarBuffer(scanner);
                System.out.println();
            }
        }
    }

    private static double retirarDinero(double saldo, double cantidad)
            throws SaldoInsuficienteException {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a retirar no puede ser negativa.");
        }
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la operación.");
        }
        return saldo - cantidad;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ejercicio1(scanner);
        ejercicio2(scanner);
        ejercicio3(scanner);
        ejercicio4(scanner);
        ejercicio5(scanner);
        ejercicio6(scanner);

        scanner.close();
    }
}

