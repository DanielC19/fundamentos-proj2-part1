import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                Thread.sleep(1500);
            } catch (Exception e) {}
            // Todas las opciones del menú
            System.out.println("\n\n ***** MENÚ DE OPCIONES *****");
            System.out.println("-----------------------------------------");
            System.out.println("0: Finaliza el programa");
            System.out.println("1: Creará un nuevo vehículo");
            System.out.println("2: Mostrará la información de todos los vehículos");
            System.out.println("3: Mostrará la cantidad total de vehículos actualmente");
            System.out.println("4: Mostrará la información de los vehículos cuyo color sea verde");
            System.out.println("5: Mostrará la información del vehículo que selecciones con su ID");
            System.out.println("6: Selecciona un vehículo y crea un sensor para él");
            System.out.println("7: Selecciona un vehículo y obtén toda la información de sus sensores");
            System.out.println("8: Mostrará la información de todos los sensores cuyo tipo sea temperatura");
            System.out.println("9: Mostrará la información del vehículo con más sensores");
            System.out.println("10: Carga vehículos desde un archivo de texto");
            System.out.println("666: Mostrará todos los sensores cuyo tipo sea temperatura, ordenándolos por valor");
            System.out.println("------------------------------------------");
            System.out.print("Su opción: ");
            // Opción que toma el usuario
            opcion = sc.nextInt();
            System.out.println("\n");
            if (opcion == 0) {

                System.out.println("Ingresaste el número 0, por lo tanto se termina la ejecución\n");     
                    
            } else if (opcion == 1) {
                
                System.out.println("Ingresaste el número 1, por lo tanto ingresa la siguiente información:");
                System.out.print("Modelo del vehículo: ");
                int modelo = sc.nextInt();
                System.out.print("Marca del vehículo: ");
                String marca = sc.next();
                System.out.print("Valor comercial del vehículo: ");
                Double valorComercial = sc.nextDouble();
                System.out.print("Color del vehículo: ");
                String color = sc.next();
                // Crea el vehículo
                new Vehiculo(modelo, marca, valorComercial, color);
                System.out.println("\n¡Se ha creado su vehículo!");

            } else if (opcion == 2) {

                System.out.println("Ingresaste el número 2, por lo tanto aquí está la información de todos los vehículos ");
                System.out.println(Vehiculo.toStringVehiculos());

            } else if (opcion == 3) {

                System.out.print("Ingresaste el número 3, la cantidad de vehículos que hay actualmente es de: ");
                System.out.println(Vehiculo.cantidadVehiculos());

            } else if (opcion == 4) {
                
                System.out.println("Ingresaste el número 4, la información de los vehículos de color verde es: ");
                System.out.println(Vehiculo.toStringVerdes());  

            } else if (opcion == 5) {

                System.out.println("Ingresaste el número 5, ingresa por pantalla un ID de un vehículo: ");
                int id = sc.nextInt();
                Vehiculo vehiculo = Vehiculo.findById(id);
                if (vehiculo != null) {
                    System.out.println(vehiculo.getInfo());  
                } else {
                    System.out.println("No existe un vehículo con ese ID.");
                }

            } else if (opcion == 6) {

               System.out.println("Ingresaste el número 6, ingrese por pantalla un ID de un vehículo:");
                int id = sc.nextInt();
                Vehiculo vehiculo = Vehiculo.findById(id);
                if (vehiculo != null) {
                    // Pedir val
                    System.out.print("Tipo sensor: ");
                    String type = sc.next();
                    System.out.print("Valor sensor: ");
                    double valor = sc.nextDouble();
                    // Crea el sensor
                    Sensor sensorsito = new Sensor(type, valor);
                    // Añade el sensor
                    vehiculo.anadirSensor(sensorsito);
                    
                    System.out.println("¡Sensor creado y agregado!");
                } else {
                    System.out.println("No existe un vehículo con ese ID.");
                }

            } else if (opcion == 7) {

                System.out.println("Ingresaste el número 7, por lo tanto a continuación deberás ingresar por pantalla un ID");
                int id = sc.nextInt();
                System.out.println("A continuación tendrá la información de los sensores correspondientes al vehículo de ese ID");
                Vehiculo vehiculo = Vehiculo.findById(id);
                System.out.println(vehiculo.getId());
                if (vehiculo != null) {
                    if (vehiculo.getSensores().size() == 0) {
                        System.out.println("Este vehículo no tiene sensores");
                    }
                    for (Sensor sensor : vehiculo.getSensores()) {
                        System.out.println(sensor.getInfo());
                    }
                } else {
                    System.out.println("No existe un vehículo con ese ID.");
                }

            } else if (opcion == 8) {

                System.out.print("Ingresaste el número 8, la información de los sensores que hay actualmente del tipo 'temperatura' es: ");
                System.out.println(Vehiculo.sensoresTemperatura());

            } else if (opcion == 9) {

                System.out.println("Ingresaste el número 9, a continuación tendrás la información del vehículo que cuenta con más sensores");
                System.out.println(Vehiculo.toStringMasSensores());
            
            } else if (opcion == 10) {

                try {
                    Vehiculo.readCsv();
                    System.out.println("Se importaron los vehículos correctamente");                    
                } catch (Exception e) {
                    System.out.println("Error al cargar los datos");
                }

            } else if (opcion == 666) {

                System.out.println("Ingresaste el número 666, a continuación tendrás la información de los sensores de tipo 'Temperatura' ordenados por valor");
                System.out.println(Vehiculo.sensoresTemperaturaOrdenados());

            } else {
                System.out.println("Por favor, escoja un número válido");
            }
        } while (opcion != 0);

        sc.close();
    }
}
