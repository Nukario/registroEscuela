// Clase Materia para almacenar datos de la materia
public class Materia {
    private static int idCounter = 1;
    private int id;
    private String clave;
    private String nombre;
    private int unidades;

    public Materia(String clave, String nombre, int unidades) {
        this.id = idCounter++;
        this.clave = clave;
        this.nombre = nombre;
        this.unidades = unidades;
    }

    public int getId() {
        return id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Materia: " + nombre + " (ID: " + id + ", Clave: " + clave + ", Unidades: " + unidades + ")";
    }
}
