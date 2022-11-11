import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehiculo {
    // Separador de CSV para lectura
    public static final String SEPARATOR = ";";
    // Estos son los atributos de nuestra clase de clase Vehiculo
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static int idActual = 1;
    private int id;
    private int modelo;
    private ArrayList<Sensor> sensores = new ArrayList<>(); 
    private String marca;
    private double valorComercial;
    private String color;

    /**
     * * Constructores
     */
    public Vehiculo() {
        this.id = Vehiculo.idActual;
        Vehiculo.idActual++;

        Vehiculo.vehiculos.add(this);
    }

    public Vehiculo(int mo, String ma, double va) {
        this(mo, ma, va, "verde");
    }

    public Vehiculo(int mo, String ma, double va, String co) {
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;
        this.id = Vehiculo.idActual;
        
        Vehiculo.idActual++;
        Vehiculo.vehiculos.add(this);
    }

/**
     * * Imprime la cantidad de vehículos 
     * 
     * @return int
     */
    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }

    /**
     * * Imprime la info de un solo vehículo
     * 
     * @return String
     */
    public String getInfo() {
        String str = "Vehiculo de marca: " + this.marca + " con id de:" + this.id + ", con modelo: " + this.modelo + ", color: " + this.color
                + " y con valor: " + this.valorComercial;
        for (Sensor sensor : this.sensores) {
            str += sensor.getInfo() + "\n";
        }
        return str;
    }

    /**
     * * Metodo que retorna la información de todos los vehiculos registrados
     * 
     * @return String
     */
    public static String toStringVehiculos() {
        String str = "";
        boolean existe = false;
        for (Vehiculo vehiculos : Vehiculo.vehiculos){
            existe = true;
            str += vehiculos.getInfo() + "\n";
        }
        if (!existe) {
            return "No existen vehículos creados hasta el momento compañero.";
        }
        return str;
 
    }
    
    /**
     * * Concatena la info de todos los vehículos verdes
     * 
     * @return String
     */
    public static String toStringVerdes() {
        String str = "";
        boolean existe = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.color.toLowerCase().equals("verde")) {
                existe = true;
                str += vehiculo.getInfo() + "\n";
            }
        }
        if (existe) {
            return str;
        } else {
            return "No hay vehículos para mostrar";
        }
    }

    /**
     * * Devuelve el vehículo con más sensores
     * 
     * @param Vehiculo
     */
    public static String toStringMasSensores() {
        Vehiculo vehiculoMayor = null;
        int tamañoMayor = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.sensores.size() > tamañoMayor) {
                vehiculoMayor = vehiculo;
            }
        }
        if (vehiculoMayor != null) {
            return vehiculoMayor.getInfo();
        }
        return "No hay vehículos con sensores.";
    }

    /**
     * * Devuelve el vehículo seleccionado
     * 
     * @param id
     * @return Vehiculo
     */
    public static Vehiculo findById(int id) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getId() == id) {
                return vehiculo;
            }
        }
        return null;
    }

    /**
     * * Retorna la cantidad de sensores del objeto
     * 
     * @return Integer
     */
    public int cantidadSensores() {
        return this.sensores.size();
    }

    /**
     * * Permite añadir sensores
     *
     * @param Sensor
     */
    public void anadirSensor(Sensor s){
        this.sensores.add(s);
    }

    /**
     * * Devuelve la información de todos los sensores tipo temperatura
     * 
     * @return String
     */
    public static String sensoresTemperatura() {
        String str = "";
        boolean existe = false;
        for (Vehiculo vehiculo : vehiculos) {
            for (Sensor sensor : vehiculo.sensores) {
                if (sensor.getTipo().toLowerCase().equals("temperatura")) {
                    existe = true;
                    str += sensor.getInfo() + "\n";
                }
            }
        }
        if (!existe) {
            str = "No hay sensores de tipo temperatura en ningún vehículo.";
        }
        return str;
    }

    public static String sensoresTemperaturaOrdenados() {
        ArrayList<Sensor> sensores = new ArrayList<>();
        String str = "";
        boolean existe = false;
        for (Vehiculo vehiculo : vehiculos) {
            for (Sensor sensor : vehiculo.sensores) {
                if (sensor.getTipo().toLowerCase().equals("temperatura")) {
                    existe = true;
                    sensores.add(sensor);
                }
            }
        }
        if (!existe) {
            return "No hay sensores de tipo temperatura en ningún vehículo.";
        }
        sensores.sort((s1, s2) -> Double.compare(s1.getValor(), s2.getValor()));
        for (Sensor sensor : sensores) {
            str += sensor.getInfo() + "\n";
        }
        return str;   
    }

    /**
     * * Lee el CSV de vehículos
     */
    public static void readCsv() {
        try {
            File file = new File("vehiculos.csv");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] fields = str.split(";");
                new Vehiculo(Integer.parseInt(fields[0]), fields[1], Double.parseDouble(fields[2]), fields[3]);
            }
            sc.close();
        } catch (Exception e) {}
    }

    /**
     * * SETTERS Y GETTERS
     */
    public void setModelo(int mo) {
        this.modelo = mo;
    }

    public void setMarca(String ma) {
        this.marca = ma;
    }

    public void setValor(double val) {
        this.valorComercial = val;
    }

    public void setColor(String col) {
        this.color = col;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setSensores(ArrayList<Sensor> sensores) {
        this.sensores = sensores;
    }
    
    public ArrayList<Sensor> getSensores() {
        return sensores;
    }

    public int getId(){
        return this.id;
    }

    public int getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public double getValor() {
        return this.valorComercial;
    }

    public String getColor() {
        return this.color;
    }
}