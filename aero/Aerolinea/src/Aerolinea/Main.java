package Aerolinea;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase principal que contiene el punto de entrada del programa y los métodos para mostrar los menús de administrador y cliente.
 */
public class Main {
    /**
     * Método principal que inicia el programa.
     * @param args los argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        int opcion;

        ArrayList<Avion> listaAviones = crearAviones();
        ArrayList<Piloto> listaDePilotos = crearPilotos();
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();

        do {
            comoQuieresAcceder();
            try {
                opcion = Integer.parseInt(Teclat.llegirString());
                switch (opcion) {
                    case 1:
                        mostrarMenuAdmin(listaAviones, listaDePilotos, listaVuelos);
                        break;
                    case 2:
                        mostrarMenuCliente(listaAviones, listaDePilotos, listaVuelos);
                        break;
                    case 3:
                        System.out.println("\033[35mHasta la próxima\033[0m");
                        break;
                    default:
                        System.out.println("\033[31mError, selecciona una opción válida (1 - 2 - 3)\033[0m");
                }
            } catch (Exception e) {
                System.out.println("\033[31mError, selecciona una opción válida (1 - 2 - 3)\033[0m");
                opcion = 0;
            }
        } while (opcion != 3);
    }

    /**
     * Muestra el menú de selección para acceder a la aplicación como administrador o cliente.
     */
    private static void comoQuieresAcceder() {
        System.out.println("¿Cómo quieres acceder a la aplicación?");
        System.out.println("1 - Administrador");
        System.out.println("2 - Cliente");
        System.out.println("3- Salir de la aplicación ");
    }

    /**
     * Muestra el menú principal para el administrador y gestiona las diferentes opciones.
     * @param listaAviones la lista de aviones disponibles
     * @param listaPilotos la lista de pilotos disponibles
     * @param listaVuelos la lista de vuelos
     */
    private static void mostrarMenuAdmin(ArrayList<Avion> listaAviones, ArrayList<Piloto> listaPilotos, ArrayList<Vuelo> listaVuelos) {
        int opcion;
        boolean salirMenuPrincipal = true;
        if (contrasenaAdmin()) {

            do {
                System.out.println("1 - Crear vuelo");
                System.out.println("2 - Visualizar datos de vuelo");
                System.out.println("3 - Modificar datos de vuelo");
                System.out.println("4 - Borrar vuelos");
                System.out.println("5 - Mostrar aviones");
                System.out.println("6 - Mostrar pilotos");
                System.out.println("7 - Salir al menú principal");

                opcion = Teclat.llegirInt();

                switch (opcion) {
                    case 1:
                        crearVuelo(listaAviones, listaPilotos, listaVuelos);
                        break;
                    case 2:
                        visualizarDatosVuelo(listaVuelos);
                        break;
                    case 3:
                        modificarVuelo(listaVuelos, listaAviones, listaPilotos);
                        break;
                    case 4:
                        borrarVuelo(listaVuelos);
                        break;
                    case 5:
                        mostrarAviones(listaAviones);
                        break;
                    case 6:
                        mostrarPilotos(listaPilotos);
                        break;
                    case 7:
                        System.out.println("\033[35mHasta la próxima\033[0m");
                        regresarMenuPrincipal(listaAviones, listaPilotos, listaVuelos);
                        salirMenuPrincipal = false;
                        break;
                    default:
                        System.out.println("\033[31mError, selecciona una opción válida (1-7)\033[0m");
                }

            }while (salirMenuPrincipal);
        }
    }

    /**
     * Muestra el menú principal para el cliente y gestiona las diferentes opciones.
     * @param listaAviones la lista de aviones disponibles
     * @param listaPilotos la lista de pilotos disponibles
     * @param listaVuelos la lista de vuelos
     */
    private static void mostrarMenuCliente(ArrayList<Avion> listaAviones, ArrayList<Piloto> listaPilotos, ArrayList<Vuelo> listaVuelos) {
        int opcion;
        boolean salirMenuPrincipal = true;
        System.out.println("\033[35mBienvenido, ¿qué quieres hacer ahora?\033[0m");
        do {
            System.out.println("1 - Visualizar datos de vuelo");
            System.out.println("2 - Comprar billetes");
            System.out.println("3 - Anular billetes");
            System.out.println("4 - Salir al menú principal");

            opcion = Teclat.llegirInt();

            switch (opcion) {
                case 1:
                    visualizarDatosVueloCliente(listaVuelos);
                    break;
                case 2:
                    comprarBilletes(listaVuelos);
                    break;
                case 3:
                    anularBilletes(listaVuelos);
                    break;
                case 4:
                    System.out.println("\033[35mHasta la próxima\033[0m");
                    regresarMenuPrincipal(listaAviones, listaPilotos, listaVuelos);
                    salirMenuPrincipal = false;
                    break;
                default:
                    System.out.println("\033[31mError, selecciona una opción válida (1-4)\033[0m");
            }
        } while (salirMenuPrincipal);
    }

    /**
     * Regresa al menú principal después de que el administrador o cliente haya realizado una acción.
     * @param listaAviones la lista de aviones disponibles
     * @param listaPilotos la lista de pilotos disponibles
     * @param listaVuelos la lista de vuelos
     */
    private static void regresarMenuPrincipal(ArrayList<Avion> listaAviones, ArrayList<Piloto> listaPilotos, ArrayList<Vuelo> listaVuelos) {
        int opcion;

        boolean regresar = true;
        do {
            comoQuieresAcceder();
            try {
                opcion = Integer.parseInt(Teclat.llegirString());
                switch (opcion) {
                    case 1:
                        mostrarMenuAdmin(listaAviones, listaPilotos, listaVuelos);
                        regresar = false;
                        break;
                    case 2:
                        mostrarMenuCliente(listaAviones, listaPilotos, listaVuelos);
                        regresar = false;
                        break;
                    case 3:
                        System.out.println("\033[35mHasta la próxima\033[0m");
                        regresar = false;
                        break;
                    default:
                        System.out.println("\033[31mError, selecciona una opción válida (1 - 2 - 3)\033[0m");
                        regresar = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("\033[31mError, selecciona una opción válida (1 - 2 - 3)\033[0m");
                opcion = 0;
                regresar = true;
            }
        } while (regresar);
    }


    /**
     * Obtiene el código de avión seleccionado por el usuario.
     * @param listaAviones la lista de aviones disponibles
     * @return el avión seleccionado
     */
    private static Avion conseguirCodigoAvion(ArrayList<Avion> listaAviones) {
        int codiAvio;
        int i;

        do {

            System.out.println("Elige el código del avión");

            for (i = 0; i < listaAviones.size(); i++) {
                System.out.println(i + 1 + " - " + listaAviones.get(i));

            }
            codiAvio = Teclat.llegirInt();

            if (codiAvio > i) {
                System.out.println("\033[31mCódigo incorrecto\033[0m");
            }

        } while (codiAvio > i);


        return listaAviones.get(codiAvio - 1);
    }

    /**
     * Obtiene el código de piloto seleccionado por el usuario.
     * @param listaDePilotos la lista de pilotos disponibles
     * @return el piloto seleccionado
     */
    private static Piloto conseguirCodigoPiloto(ArrayList<Piloto> listaDePilotos) {
        int codiPilot;
        int i;

        do {
            System.out.println("Elige el código del piloto");

            for (i = 0; i < listaDePilotos.size(); i++) {
                System.out.println(i + 1 + " - " + listaDePilotos.get(i));

            }

            codiPilot = Teclat.llegirInt();

            if (codiPilot > i) {
                System.out.println("\033[31mCódigo incorrecto\033[0m");
            }

        } while (codiPilot > i);


        return listaDePilotos.get(codiPilot - 1);

    }

    /**
     * Valida la contraseña del administrador.
     * @return true si la contraseña es correcta, false en caso contrario
     */
    private static boolean contrasenaAdmin() {
        String usuario;
        String contrasena;

        do {
            System.out.println("Introduce tu nombre de usuario:");
            usuario = Teclat.llegirString();
            if (usuario.equalsIgnoreCase("filip")) {
                System.out.println("Introduce la contraseña:");
                contrasena = Teclat.llegirString();
                if (contrasena.equals("filip")) {
                    System.out.println("\033[35mBienvenido, ¿qué quieres hacer ahora?\033[0m");
                    return true;
                } else
                    System.out.println("\033[31mContraseña incorrecta, vuelve a intentarlo.\033[0m");
            } else
                System.out.println("\033[31mUsuario incorrecto, vuelve a intentarlo.\033[0m");
        } while (true);
    }

    /**
     * Crea un nuevo vuelo y lo agrega a la lista de vuelos.
     * @param listaAviones la lista de aviones disponibles
     * @param listaDePilotos la lista de pilotos disponibles
     * @param listaVuelos la lista.
     */
    private static void crearVuelo(ArrayList<Avion> listaAviones, ArrayList<Piloto> listaDePilotos, ArrayList<Vuelo> listaVuelos) {

        int codigoVuelo;
        Avion codigoAvion;
        Piloto codigoPiloto;

        String origen;
        String desti;
        LocalTime sortida;
        int durada;
        double precio;

        codigoAvion = conseguirCodigoAvion(listaAviones);
        codigoPiloto = conseguirCodigoPiloto(listaDePilotos);

        System.out.println("Código del vuelo: ");
        codigoVuelo = Teclat.llegirInt();
        System.out.println("Origen del vuelo: ");
        origen = Teclat.llegirString();
        System.out.println("Destino: ");
        desti = Teclat.llegirString();
        System.out.println("Hora de salida: ");
        sortida = LocalTime.parse(Teclat.llegirString());
        System.out.println("Pon la duración del vuelo (en minutos): ");
        durada = Teclat.llegirInt();
        System.out.println("Precio del billete:");
        precio = Teclat.llegirInt();


        Vuelo nuevoVuelo = new Vuelo(codigoAvion, codigoPiloto, codigoVuelo, origen, desti, sortida, durada, precio);

        listaVuelos.add(nuevoVuelo);


        System.out.println("\033[33mVuelo creado con exito\033[0m");


    }

    /**
     * Visualiza los datos de los vuelos creados
     * @param listaVuelos la lista
     * @return el número del vuelo
     */
    private static int visualizarDatosVuelo(ArrayList<Vuelo> listaVuelos) {

        int numeroDeVuelos;

        if (listaVuelos.size() == 0) {
            System.out.println("\033[31mNo hay vuelos creados\033[0m");

        }

        for (numeroDeVuelos = 0; numeroDeVuelos < listaVuelos.size(); numeroDeVuelos++) {
            Vuelo v = listaVuelos.get(numeroDeVuelos);
            System.out.println("Código del vuelo: " + v.getCodigoVuelo());
            System.out.println("Nombre del avión: " + v.getAvion().getNombreAvion());
            System.out.println("Código del piloto: " + v.getPiloto().getIdentificacion());
            System.out.println("Hora de salida: " + v.getHoraSalida());
            System.out.println("Hora de llegada: " + v.getHoraLlegada());
            System.out.println("Origen: " + v.getOrigen());
            System.out.println("Destino: " + v.getDestino());
            System.out.println("Duración del vuelo: " + v.getDuracionVuelo()+" minutos");
            System.out.println("Precio: " + v.getPrecioBillete()+"€");
            System.out.println("-------------------------------");
        }

        return numeroDeVuelos;
    }


    /**
     * Modifica los detalles de un vuelo en la lista de vuelos
     * @param listaVuelos la lista de vuelos disponibles
     * @param listaAviones la lista de aviones disponibles
     * @param listaDePilotos la lista de pilotos disponibles
     */
    private static void modificarVuelo(ArrayList<Vuelo> listaVuelos, ArrayList<Avion> listaAviones, ArrayList<Piloto> listaDePilotos) {
        int codiVol;
        int maximsVols = visualizarDatosVuelo(listaVuelos);
        Avion codigoAvion;
        Piloto codigoPiloto;

        String origen;
        String destino;
        LocalTime salida;
        int duracion;

        System.out.println("Introduce el código del vuelo que quieres modificar: ");
        codiVol = Teclat.llegirInt();
        codiVol--;

        if (codiVol > maximsVols) {
            System.out.println("\033[31mEl número de vuelo no existe\033[0m");
            return;
        }

        codigoAvion = conseguirCodigoAvion(listaAviones);
        codigoPiloto = conseguirCodigoPiloto(listaDePilotos);

        System.out.println("Nuevo origen: ");
        origen = Teclat.llegirString();
        System.out.println("Nuevo destino: ");
        destino = Teclat.llegirString();
        System.out.println("Nueva hora de salida: ");
        salida = LocalTime.parse(Teclat.llegirString());
        System.out.println("Cuanto dura el vuelo (en minutos): ");
        duracion = Teclat.llegirInt();

        LocalTime llegada = salida.plusMinutes(duracion);

        listaVuelos.get(codiVol).setAvion(codigoAvion);
        listaVuelos.get(codiVol).setPiloto(codigoPiloto);
        listaVuelos.get(codiVol).setOrigen(origen);
        listaVuelos.get(codiVol).setDestino(destino);
        listaVuelos.get(codiVol).setHoraSalida(salida);
        listaVuelos.get(codiVol).setHoraLlegada(llegada);

        System.out.println("Vuelo modificado con éxito.");
    }


    /**
     * Elimina un vuelo de la lista de vuelos.
     * @param listaVuelos la lista de vuelos disponibles
     */
    private static void borrarVuelo(ArrayList<Vuelo> listaVuelos) {

        int codigoVuelo;
        int maximsVols = visualizarDatosVuelo(listaVuelos);


        System.out.println("Introduce el código del vuelo: ");
        codigoVuelo = Teclat.llegirInt();

        if (codigoVuelo > maximsVols)
            System.out.println("\033[31mEl código del vuelo no existe\033[0m");


        listaVuelos.remove(codigoVuelo - 1);

        System.out.println("\033[33mVuelo eliminado correctamente\033[0m");
    }

    /**
     * Muestra los aviones disponibles
     * @param listaAviones la lista de aviones
     */
    private static void mostrarAviones(ArrayList<Avion> listaAviones) {
        System.out.println("\n\033[33mAviones disponibles.\033[0m");
        for (Avion avion : listaAviones) {
            System.out.println(avion.toString());
        }
    }

    /**
     * Muestra los pilotos disponibles
     * @param listaDePilotos la lista de pilotos
     */
    private static void mostrarPilotos(ArrayList<Piloto> listaDePilotos) {
        System.out.println("\n\033[33mPilotos disponibles.\033[0m");
        for (Piloto piloto : listaDePilotos) {
            System.out.println(piloto.toString());
        }
    }

    /**
     * Muestra los datos de los vuelos desde el switch del cliente
     * @param listaVuelos la lista de vuelos
     */
    private static void visualizarDatosVueloCliente(ArrayList<Vuelo> listaVuelos) {

        for (int i = 0; i < listaVuelos.size(); i++) {
            Vuelo v = listaVuelos.get(i);
            System.out.println("Código del vuelo: " + v.getCodigoVuelo());
            System.out.println("Nombre del avión: " + v.getAvion().getNombreAvion());
            System.out.println("Nombre del piloto: " + v.getPiloto().getIdentificacion());
            System.out.println("Hora de salida: " + v.getHoraSalida());
            System.out.println("Hora de lelgada: " + v.getHoraLlegada());
            System.out.println("Origen: " + v.getOrigen());
            System.out.println("Destino: " + v.getDestino());
            System.out.println("Duración del vuelo: " + v.getDuracionVuelo());
            System.out.println("-------------------------------");
        }
    }

    /**
     * Comprueba si un vuelo existe en la lista de vuelos
     * @param volEscollit el código del vuelo a comprobar
     * @param listaVuelos la lista de vuelos disponibles
     * @return true si el vuelo existe, false de lo contrario
     */
    private static boolean comprobarSiElVueloExiste(int volEscollit, ArrayList<Vuelo> listaVuelos){



        if (volEscollit > listaVuelos.size()) {
            System.out.println("\033[31mCódigo de vuelo incorrecto\033[0m");
            return false;
        }
        return true;
    }

    /**
     * Permite al usuario comprar billetes para un vuelo específico
     * @param listaVuelos la lista de vuelos disponibles
     */
    private static void comprarBilletes(ArrayList<Vuelo> listaVuelos) {

        int codigoVuelo, numeroBilletes;
        double precioTotal;
        boolean comprobacionDeVuelo;

        do {

            System.out.println("Introduce el código del vuelo: ");
            codigoVuelo = Teclat.llegirInt() - 1;
            comprobacionDeVuelo = comprobarSiElVueloExiste(codigoVuelo, listaVuelos);

        }while (!comprobacionDeVuelo);

        System.out.println("Cuantos billetes quieres comprar?");
        numeroBilletes = Teclat.llegirInt();


        Vuelo vueloSeleccionado = listaVuelos.get(codigoVuelo);
        double precioVuelo = vueloSeleccionado.getPrecioBillete();
        precioTotal = numeroBilletes * precioVuelo;

        System.out.println("El precio total es de: " + precioTotal + "€");

    }

    /**
     * Permite al usuario anular un número determinado de billetes para un vuelo específico
     * @param listaVuelos la lista de vuelos disponibles
     */
    private static void anularBilletes(ArrayList<Vuelo> listaVuelos) {

        int codiVol;
        int numeroBitllets;
        boolean comprobacioVol;


        do {

            System.out.println("Introduce el código del vuelo: ");
            codiVol = Teclat.llegirInt() - 1;
            comprobacioVol = comprobarSiElVueloExiste(codiVol, listaVuelos);

        }while (!comprobacioVol);


        System.out.println("Cuantos billetes quieres anular para este vuelo?");
        numeroBitllets = Teclat.llegirInt();

    }

    /**
     * Crea y devuelve una lista de aviones predefinidos
     * @return la lista de aviones creada
     */
    private static ArrayList<Avion> crearAviones() {
        ArrayList<Avion> listaDeAviones = new ArrayList<>();
        listaDeAviones.add(new Avion("Boeing 747-8", "01-07-2011", 241140, 467));
        listaDeAviones.add(new Avion("Airbus A380", "25-10-2007", 310000, 853));
        listaDeAviones.add(new Avion("Boeing 787 Dreamliner", "25-10-2011", 126090, 330));
        listaDeAviones.add(new Avion("Airbus A320neo", "25-01-2016", 23850, 195));
        listaDeAviones.add(new Avion("Embraer E195-E2", "12-04-2018", 14640, 146));
        return listaDeAviones;
    }


    /**
     * Crea y devuelve una lista de pilotos predefinidos
     * @return la lista de pilotos creada
     */
    private static ArrayList<Piloto> crearPilotos() {
        ArrayList<Piloto> listaDePilotos = new ArrayList<>();
        listaDePilotos.add(new Piloto(1, "Juan", "Pérez", "12345678A", 610318801, "12-05-1985"));
        listaDePilotos.add(new Piloto(2, "Mario", "García", "23456789B", 622218801, "15-10-1987"));
        listaDePilotos.add(new Piloto(3, "Alberto", "López", "34567890C", 611814801, "06-03-1992"));
        listaDePilotos.add(new Piloto(4, "Roberto", "Ramírez", "45678901D", 619331801, "08-12-1990"));
        listaDePilotos.add(new Piloto(5, "José", "Fernández", "56789012E", 644218801, "23-07-1988"));
        return listaDePilotos;
    }


}