import java.util.Scanner;

public class EjercicioFinal {

    // ---------- VALIDACIÓN ----------
    public static void validarReserva(String nombre, int habitacion, int noches, double precioNoche)
            throws IllegalArgumentException {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        if (habitacion <= 0) {
            throw new IllegalArgumentException("El número de habitación debe ser mayor que cero.");
        }
        if (noches <= 0) {
            throw new IllegalArgumentException("El número de noches debe ser mayor que cero.");
        }
        if (!Double.isFinite(precioNoche) || precioNoche <= 0) {
            throw new IllegalArgumentException("El precio por noche debe ser superior a cero.");
        }
    }

    // ---------- CÁLCULO ----------
    public static double calcularPrecio(int noches, double precioNoche) {
        double total = noches * precioNoche;
        if (!Double.isFinite(total)) {
            throw new IllegalArgumentException("El precio total no es válido.");
        }
        return total;
    }

    // ---------- PRESENTACIÓN ----------
    public static void mostrarReserva(String nombre, int habitacion, int noches,
                                      double precioNoche, double total) {
        System.out.println();
        System.out.println("RESERVA REALIZADA CORRECTAMENTE");
        System.out.println();
        System.out.println("Cliente: " + nombre);
        System.out.println("Habitación: " + habitacion);
        System.out.println("Noches: " + noches);
        System.out.println("Precio por noche: " + precioNoche + " €");
        System.out.println("Precio total: " + total + " €");
    }

    // ---------- PROGRAMA PRINCIPAL ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== SISTEMA DE RESERVAS DE HOTEL =====");
        System.out.println();

        try {
            System.out.print("Nombre del cliente: ");
            String nombre = sc.nextLine();

            System.out.print("Número de habitación: ");
            int habitacion = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Número de noches: ");
            int noches = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Precio por noche: ");
            double precioNoche = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));

            validarReserva(nombre, habitacion, noches, precioNoche);

            double total = calcularPrecio(noches, precioNoche);
            mostrarReserva(nombre, habitacion, noches, precioNoche, total);

        } catch (IllegalArgumentException e) {
            // Captura tanto los errores de validarReserva() como
            // NumberFormatException (que hereda de IllegalArgumentException)
            System.out.println();
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
