public class Maestro {
    private static int idCounter = 1;
    private int id;
    private String nombreCompleto;
    private String numeroTarjeta;

    public Maestro(String nombreCompleto, String numeroTarjeta) {
        this.id = idCounter++;
        this.nombreCompleto = nombreCompleto;
        this.numeroTarjeta = numeroTarjeta;
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

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public String toString() {
        return "Maestro: " + nombreCompleto + " (ID: " + id + ", Tarjeta: " + numeroTarjeta + ")";
    }
}
