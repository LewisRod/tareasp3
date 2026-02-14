package tareasp3.TareaCap8y13;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        MetodosIncidencia metodos = new MetodosIncidencia();

        do {

            System.out.println("\n----SISTEMA DE INCIDENCIAS----\n");
            System.out.println("1. Registrar incidencia");
            System.out.println("2. Listar incidencias");
            System.out.println("3. Buscar por palabra clave");
            System.out.println("0. Salir");
            System.out.print("Seleccione opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            try {

                switch (opcion) {

                    case 1:
                        System.out.print("Ingrese Id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese descripcion: ");
                        String descripcion = scanner.nextLine();

                        System.out.print("Ingrese fecha (dd/MM/yyyy): ");
                        String fechaString = scanner.nextLine();
                        Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);

                        System.out.print("Ingrese nivel de prioridad (ALTA, MEDIA o BAJA): ");
                        String prioridad = scanner.nextLine();

                        metodos.registrarIncidencia(id, descripcion, fecha, prioridad);
                        break;

                    case 2:
                        metodos.listarIncidencias();
                        break;

                    case 3:
                        System.out.print("Ingrese palabra clave: ");
                        String palabra = scanner.nextLine();
                        metodos.buscarIncidenciasPorPalabra(palabra);
                        break;

                    case 0:
                        System.out.println("\nFIN DEL PROGRAMA");
                        break;

                    default:
                        System.out.println("Opcion invalida intente nuevamente.\n");
                }

            } catch (DescripcionInvalidaException | FechaInvalidaException | PrioridadInvalidaException e) {

                System.out.println("Error " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Hubo un error " + e.getMessage());
            }

        } while (opcion != 0);
    }
}
