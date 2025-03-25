import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                    -------Alquiler de Vehiculos-------
                    ---------------Menú----------------
                    1.Registrar Vehiculo
                    2.Registrar Cliente
                    3.Realizar Alquiler
                    4.Mostrar Vehiculos Disponibles
                    5.Registrar Devolucion
                    6.Salir
                    
                    Ingrese una opcion:""");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    registrarVehiculo(listaVehiculos, scanner);
                    break;
                case 2:
                    registrarCliente(listaClientes, scanner);
                    break;
                case 3:
                    realizarAlquiler(listaVehiculos, listaClientes, scanner);
                    break;
                case 4:
                    mostrarVehiculosDisponibles(listaVehiculos);
                    break;
                case 5:
                    registrarDevolucion(listaVehiculos, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void registrarVehiculo(List<Vehiculo> listaVehiculos, Scanner scanner) {
        System.out.println("Auto (A) o Camioneta (C): ");
        String tipo = scanner.nextLine();
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.println("Año: ");
        int anio = scanner.nextInt();
        System.out.println("Precio por Dia: ");
        double precioDia = scanner.nextDouble();
        scanner.nextLine();

        if (tipo.equalsIgnoreCase("A")) {
            System.out.println("Numero de Puertas: (4)");
            int numPuertas = scanner.nextInt();
            listaVehiculos.add(new Auto(marca, modelo, anio, precioDia, numPuertas));
        }else if (tipo.equalsIgnoreCase("C")) {
            System.out.println("Capacidad de Carga (Kg): ");
            double capacidadCarga = scanner.nextDouble();
            listaVehiculos.add(new Camioneta(marca, modelo, anio, precioDia, capacidadCarga));
        }else {
            System.out.println("Tipo de Vehiculo Invalido");
        }
    }

    private static void registrarCliente(List<Cliente> listaClientes, Scanner scanner) {
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Cedula: ");
        String cedula = scanner.nextLine();
        System.out.println("Numero de Licencia");
        String numLicencia = scanner.nextLine();
        listaClientes.add(new Cliente(nombre, cedula, numLicencia));
        System.out.println("Cliente Registrado");
    }

    private static void realizarAlquiler(List<Vehiculo> listaVehiculos,List<Cliente> listaClientes, Scanner scanner){
        System.out.println("Nombre del Cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.println("Vehiculo a Alquilar: ");
        String vehiculoAlquilar = scanner.nextLine();
        System.out.println("Numero de Dias: ");
        int dias = scanner.nextInt();

        Vehiculo vehiculo = buscarVehiculo(listaVehiculos, vehiculoAlquilar);
        Cliente cliente = buscarCliente(listaClientes, nombreCliente);

        if (vehiculo != null && cliente !=null && vehiculo.isDisponible()) {
            double costoTotal = vehiculo.getPrecioDia() * dias;
            if (dias > 7) {
                costoTotal *= 0.9;
            }
            System.out.println("Costo Total: " + costoTotal);
            vehiculo.setDisponible(false);
            System.out.println("Alquiler Realizado");
        }else {
            System.out.println("Vehiculo no Disponible o Cliente no Encontrado");
        }
    }

    private static void mostrarVehiculosDisponibles(List<Vehiculo> listaVehiculos) {
        System.out.println("Vehiculos Disponibles: ");
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.isDisponible()) {
                System.out.println(vehiculo.getTipo() + " - " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getAnio() + "  $" + vehiculo.getPrecioDia());
            }
        }
    }

    private static void registrarDevolucion(List<Vehiculo> listaVehiculos, Scanner scanner){
        System.out.println("Vehiculo a Devolver: ");
        String tituloVehiculo = scanner.nextLine();
        Vehiculo vehiculo = buscarVehiculo(listaVehiculos, tituloVehiculo);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
            System.out.println("Devolucion Registrada");
        }else {
            System.out.println("Vehiculo no Encontrado");
        }
    }

    private static Vehiculo buscarVehiculo(List<Vehiculo> listaVehiculos, String titulo) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getModelo().equalsIgnoreCase(titulo)) {
                return vehiculo;
            }
        }
        return null;
    }

    private static Cliente buscarCliente(List<Cliente> listaClientes,String nombre) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }
}