package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

class Persona {
    private String nombre;
    private String identificacion;
    private String contacto;

    public Persona(String nombre, String identificacion, String contacto) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.contacto = contacto;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    public String obtenerContacto() {
        return contacto;
    }
}

class Pasajero extends Persona {
    private List<Reserva> historialReservas;

    public Pasajero(String nombre, String identificacion, String contacto) {
        super(nombre, identificacion, contacto);
        this.historialReservas = new ArrayList<>();
    }

    public List<Reserva> obtenerHistorialReservas() {
        return historialReservas;
    }

    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }
}


class Asiento {
    private String numero;
    private String clase;
    private String estado;

    public Asiento(String numero, String clase) {
        this.numero = numero;
        this.clase = clase;
        this.estado = "disponible";
    }

    public String obtenerNumero() {
        return numero;
    }

    public String obtenerClase() {
        return clase;
    }

    public String obtenerEstado() {
        return estado;
    }

    public void reservar() {
        if (estado.equals("disponible")) {
            estado = "reservado";
        } else {
            System.out.println("El asiento ya está " + estado);
        }
    }

    public void ocupar() {
        if (estado.equals("reservado")) {
            estado = "ocupado";
        } else {
            System.out.println("El asiento no está reservado");
        }
    }
}

class Avion {
    private String modelo;
    private int capacidad;
    private List<Asiento> listaAsientos;

    public Avion(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.listaAsientos = new ArrayList<>();
        // Inicializamos los asientos
        for (int i = 1; i <= capacidad; i++) {
            String clase = (i <= capacidad / 2) ? "económica" : "turista";
            listaAsientos.add(new Asiento("A" + i, clase));
        }
    }

    public String obtenerModelo() {
        return modelo;
    }

    public int obtenerCapacidad() {
        return capacidad;
    }

    public Asiento obtenerAsiento(String numero) {
        for (Asiento asiento : listaAsientos) {
            if (asiento.obtenerNumero().equals(numero)) {
                return asiento;
            }
        }
        return null;
    }
}

class Vuelo {
    private String numero;
    private String ruta;
    private String fecha;
    private String horaSalida;
    private String horaLlegada;
    private Avion avion;

    public Vuelo(String numero, String ruta, String fecha, String horaSalida, String horaLlegada, Avion avion) {
        this.numero = numero;
        this.ruta = ruta;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.avion = avion;
    }

    public String obtenerNumero() {
        return numero;
    }

    public String obtenerRuta() {
        return ruta;
    }

    public String obtenerFecha() {
        return fecha;
    }

    public String obtenerHoraSalida() {
        return horaSalida;
    }

    public String obtenerHoraLlegada() {
        return horaLlegada;
    }

    public Avion obtenerAvion() {
        return avion;
    }
}

class Reserva {
    private Pasajero pasajero;
    private Vuelo vuelo;
    private Asiento asiento;

    public Reserva(Pasajero pasajero, Vuelo vuelo, Asiento asiento) {
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
    }

    public Pasajero obtenerPasajero() {
        return pasajero;
    }

    public Vuelo obtenerVuelo() {
        return vuelo;
    }

    public Asiento obtenerAsiento() {
        return asiento;
    }
}

class SistemaReservasVuelos {
    public static void main(String[] args) {
        Avion avion = new Avion("Boeing 737", 100);


        Vuelo vuelo = new Vuelo("AA123", "NYC-LAX", "2024-08-30", "10:00", "13:00", avion);

        Pasajero pasajero1 = new Pasajero("Juan Pérez", "123456789", "555-1234");
        Pasajero pasajero2 = new Pasajero("Ana Gómez", "987654321", "555-5678");


        Asiento asiento1 = avion.obtenerAsiento("A1");
        Asiento asiento2 = avion.obtenerAsiento("A2");

        asiento1.reservar();
        Reserva reserva1 = new Reserva(pasajero1, vuelo, asiento1);
        pasajero1.agregarReserva(reserva1);

        asiento2.reservar();
        Reserva reserva2 = new Reserva(pasajero2, vuelo, asiento2);
        pasajero2.agregarReserva(reserva2);


        System.out.println("Historial de reservas de " + pasajero1.obtenerNombre() + ":");
        for (Reserva reserva : pasajero1.obtenerHistorialReservas()) {
            System.out.println("Vuelo: " + reserva.obtenerVuelo().obtenerNumero() +
                    ", Asiento: " + reserva.obtenerAsiento().obtenerNumero() +
                    ", Estado: " + reserva.obtenerAsiento().obtenerEstado());
        }

        System.out.println("\nHistorial de reservas de " + pasajero2.obtenerNombre() + ":");
        for (Reserva reserva : pasajero2.obtenerHistorialReservas()) {
            System.out.println("Vuelo: " + reserva.obtenerVuelo().obtenerNumero() +
                    ", Asiento: " + reserva.obtenerAsiento().obtenerNumero() +
                    ", Estado: " + reserva.obtenerAsiento().obtenerEstado());
        }
    }
}

