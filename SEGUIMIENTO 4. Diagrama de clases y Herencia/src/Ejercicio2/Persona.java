package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

class Persona {
    private String nombre;
    private String identificacion;
    private String direccion;

    public Persona(String nombre, String identificacion, String direccion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    public String obtenerDireccion() {
        return direccion;
    }
}

//Clase cliente heredada de Persona
class Cliente extends Persona {
    private List<Reserva> historialReservas;

    public Cliente(String nombre, String identificacion, String direccion) {
        super(nombre, identificacion, direccion);
        this.historialReservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }

    public List<Reserva> obtenerHistorialReservas() {
        return historialReservas;
    }
}

class Pelicula {
    private String titulo;

    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    public String obtenerTitulo() {
        return titulo;
    }
}

class Funcion {
    private Pelicula pelicula;
    private String horaInicio;
    private int sala;
    private double precioEntrada;

    public Funcion(Pelicula pelicula, String horaInicio, int sala, double precioEntrada) {
        this.pelicula = pelicula;
        this.horaInicio = horaInicio;
        this.sala = sala;
        this.precioEntrada = precioEntrada;
    }

    public String obtenerPelicula() {
        return pelicula.obtenerTitulo();
    }

    public String obtenerHoraInicio() {
        return horaInicio;
    }

    public int obtenerSala() {
        return sala;
    }

    public double obtenerPrecioEntrada() {
        return precioEntrada;
    }
}

class Asiento {
    private int fila;
    private int columna;
    private String estado;

    public Asiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.estado = "disponible";
    }

    public int obtenerFila() {
        return fila;
    }

    public int obtenerColumna() {
        return columna;
    }

    public String obtenerEstado() {
        return estado;
    }

    public void reservar() {
        if (estado.equals("disponible")) {
            estado = "reservado";
        }
    }

    public void ocupar() {
        if (estado.equals("reservado")) {
            estado = "ocupado";
        }
    }
}

class Sala {
    private int numero;
    private int capacidad;
    private Asiento[][] listaAsientos;

    public Sala(int numero, int capacidad, int filas, int columnas) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.listaAsientos = new Asiento[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                listaAsientos[i][j] = new Asiento(i, j);
            }
        }
    }

    public int obtenerNumero() {
        return numero;
    }

    public int obtenerCapacidad() {
        return capacidad;
    }

    public Asiento obtenerAsiento(int fila, int columna) {
        return listaAsientos[fila][columna];
    }
}


class Reserva {
    private Cliente cliente;
    private Funcion funcion;
    private List<Asiento> listaAsientos;

    public Reserva(Cliente cliente, Funcion funcion) {
        this.cliente = cliente;
        this.funcion = funcion;
        this.listaAsientos = new ArrayList<>();
    }

    public void agregarAsiento(Asiento asiento) {
        if (asiento.obtenerEstado().equals("disponible")) {
            asiento.reservar();
            listaAsientos.add(asiento);
        }
    }

    public Cliente obtenerCliente() {
        return cliente;
    }

    public Funcion obtenerFuncion() {
        return funcion;
    }

    public List<Asiento> obtenerListaAsientos() {
        return listaAsientos;
    }
}

//Pruebas
class Main {
    public static void main(String[] args) {

        Pelicula pelicula = new Pelicula("Avatar");
        Funcion funcion = new Funcion(pelicula, "18:00", 1, 10.0);


        Sala sala = new Sala(1, 100, 10, 10);


        Cliente cliente = new Cliente("Ana Gómez", "87654321", "Calle Verdadera 456");


        Reserva reserva = new Reserva(cliente, funcion);
        reserva.agregarAsiento(sala.obtenerAsiento(0, 0));
        reserva.agregarAsiento(sala.obtenerAsiento(0, 1));


        cliente.agregarReserva(reserva);

        System.out.println("Cliente: " + reserva.obtenerCliente().obtenerNombre());
        System.out.println("Película: " + reserva.obtenerFuncion().obtenerPelicula());
        System.out.println("Hora de Inicio: " + reserva.obtenerFuncion().obtenerHoraInicio());
        System.out.println("Sala: " + reserva.obtenerFuncion().obtenerSala());
        System.out.println("Precio Entrada: " + reserva.obtenerFuncion().obtenerPrecioEntrada());
        System.out.println("Asientos Reservados:");
        for (Asiento asiento : reserva.obtenerListaAsientos()) {
            System.out.println("Fila: " + asiento.obtenerFila() + ", Columna: " + asiento.obtenerColumna());
        }
    }
}

