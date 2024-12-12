public class Alumno {

private static int idCounter = 1;
private int id;
private String nombreCompleto;
private int semestre;
private Double[] calificaciones;
private double promedio;
private String estado;

public Alumno(String nombreCompleto, int semestre, int unidades) {
    this.id = idCounter++;
    this.nombreCompleto = nombreCompleto;
    this.semestre = semestre;
    this.calificaciones = new Double[unidades];
    this.promedio = 0.0;
    this.estado = "";
}

public int getId() {
    return id;
}

public String getNombreCompleto() {
    return nombreCompleto;
}

public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
}

public int getSemestre() {
    return semestre;
}

public void setSemestre(int semestre) {
    this.semestre = semestre;
}

public Double[] getCalificaciones() {
    return calificaciones;
}

public void setCalificaciones(Double[] calificaciones) {
    this.calificaciones = calificaciones;
    calcularPromedio();
}

public double getPromedio() {
    return promedio;
}

public String getEstado() {
    return estado;
}

private void calcularPromedio() {
    double suma = 0;
    for (Double calificacion : calificaciones) {
        suma += calificacion;
    }
    this.promedio = suma / calificaciones.length;
    this.estado = (promedio >= 70) ? "APROBADO" : "REPROBADO";
}

@Override
public String toString() {
    return "Alumno: " + nombreCompleto + " (ID: " + id + ", Semestre: " + semestre + ", Promedio: " + promedio + ", Estado: " + estado + ")";
}
}