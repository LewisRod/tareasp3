package tareasp3.TareaCap8y13;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class MetodosIncidencia {
    private List<Incidencia> incidencias;

    public MetodosIncidencia() {
        this.incidencias = new ArrayList<>();
    }

    public void registrarIncidencia(int id, String descripcion, Date fecha, String nivelPrioridad)
            throws DescripcionInvalidaException, FechaInvalidaException, PrioridadInvalidaException {
        Incidencia nuevIncidencia = new Incidencia(id, descripcion, fecha, nivelPrioridad);
        incidencias.add(nuevIncidencia);
        System.out.println("Incidencia registrada exitosamente.\n");
    }

    public void listarIncidencias() {
        for (Incidencia incidencia : incidencias) {
            System.out.println("Id: " + incidencia.getId());
            System.out.println("Descripcion: " + incidencia.getDescripcion());
            System.out.println("Fecha: " + incidencia.getFecha());
            System.out.println("Nivel de Prioridad: " + incidencia.getNivelPrioridad() + "\n");
        }
    }

    public boolean buscarIncidenciasPorPalabra(String palabraClave) {
        if (palabraClave.equalsIgnoreCase(null) || palabraClave.trim().isEmpty()) {
            throw new IllegalArgumentException("La palabra clave no puede ser nula o vacia.");
        }

        for (Incidencia incidencia : incidencias) {
            if (incidencia.getDescripcion().toLowerCase().contains(palabraClave.toLowerCase())) {
                System.out.println("\nId: " + incidencia.getId());
                System.out.println("Descripcion: " + incidencia.getDescripcion());
                System.out.println("Fecha: " + incidencia.getFecha());
                System.out.println("Nivel de Prioridad: " + incidencia.getNivelPrioridad() + "\n");
                return true;
            }
        }
        System.out.println("No se encontraron incidencias con la palabra clave");
        return false;

    }
}
