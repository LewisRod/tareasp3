package tareasp3.TareaCap8y13;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Incidencia {
    private int id;
    private String descripcion;
    private Date fecha;
    private String nivelPrioridad;

    public Incidencia(int id, String descripcion, Date fecha, String nivelPrioridad)
            throws DescripcionInvalidaException, FechaInvalidaException, PrioridadInvalidaException {
        this.id = id;

        validarDescripcion(descripcion);
        this.descripcion = descripcion.trim();
        validarFecha(fecha);
        this.fecha = fecha;
        validarPrioridad(nivelPrioridad);
        this.nivelPrioridad = nivelPrioridad;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNivelPrioridad() {
        return nivelPrioridad;
    }

    private void validarDescripcion(String descripcion)
            throws DescripcionInvalidaException {
        if (descripcion.equalsIgnoreCase(null) || descripcion.trim().isEmpty()) {
            throw new DescripcionInvalidaException("La descripcion no puede ser nula o vacia.");
        }

        if (descripcion.trim().length() < 10) {
            throw new DescripcionInvalidaException("La descripcion debe tener al menos 10 caracteres.");

        }
    }

    private void validarPrioridad(String prioridad)
            throws PrioridadInvalidaException {
        if (prioridad.equalsIgnoreCase(null) || prioridad.trim().isEmpty()) {
            throw new PrioridadInvalidaException("La prioridad no puede ser nula o vacia.");
        }

        if (!prioridad.toUpperCase().equals("ALTA") && !prioridad.toUpperCase().equals("MEDIA")
                && !prioridad.toUpperCase().equals("BAJA")) {
            throw new PrioridadInvalidaException("La prioridad debe ser ALTA, MEDIA o BAJA.");
        }
    }

    private void validarFecha(Date fechaString)
            throws FechaInvalidaException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        if (fechaString == null) {
        throw new FechaInvalidaException("La fecha no puede ser nula.");
    }

    if (fechaString.after(new Date())) {
        throw new FechaInvalidaException("La fecha no puede ser futura.");
    }

        try {
            simpleDateFormat.parse(simpleDateFormat.format(fechaString));
        } catch (Exception e) {
            throw new FechaInvalidaException("La fecha debe tener el formato dd/MM/yyyy.");
        }
    }

    @Override
    public String toString() {
        return "id = " + id + " | descripcion = " + descripcion + " | fecha = "
                + new SimpleDateFormat("dd/MM/yyyy").format(fecha) + " | nivelPrioridad = " + nivelPrioridad;
    };
}
