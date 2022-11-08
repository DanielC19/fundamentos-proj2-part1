public class Sensor {

    private String tipo;
    private double valor;
    /**
     * * Constructor vacío
     */
    public Sensor() {}

    /**
     * * Constructor con parámetros
     * Asigna los valores y añade sensor a la lista
     * 
     * @param t
     * @param v
     */
    public Sensor(String t, double v) {
        this.tipo = t;
        this.valor = v;
    }

    /**
     * * SETTERS Y GETTERS
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    /**
     * * Información del sensor
     * 
     * @return String
     */
    public String getInfo() {
        return "Sensor de tipo " + this.tipo + " con valor " + this.valor;
    }
}
