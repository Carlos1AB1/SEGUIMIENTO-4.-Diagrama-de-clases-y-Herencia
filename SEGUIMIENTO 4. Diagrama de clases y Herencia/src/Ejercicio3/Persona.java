package Ejercicio3;

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

class Cliente extends Persona {
    private List<String> historialCompras;

    public Cliente(String nombre, String identificacion, String direccion) {
        super(nombre, identificacion, direccion);
        this.historialCompras = new ArrayList<>();
    }

    public List<String> obtenerHistorialCompras() {
        return historialCompras;
    }

    public void agregarCompra(String compra) {
        historialCompras.add(compra);
    }
}


class Asiento {
    private int numero;
    private String estado;

    public Asiento(int numero) {
        this.numero = numero;
        this.estado = "disponible";
    }

    public int obtenerNumero() {
        return numero;
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


class Vagon {
    private String tipo; // "económica", "turista", etc.
    private int capacidad;
    private List<Asiento> listaAsientos;

    public Vagon(String tipo, int capacidad) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.listaAsientos = new ArrayList<>();
        for (int i = 1; i <= capacidad; i++) {
            listaAsientos.add(new Asiento(i));
        }
    }

    public String obtenerTipo() {
        return tipo;
    }

    public int obtenerCapacidad() {
        return capacidad;
    }

    public Asiento obtenerAsiento(int numero) {
        for (Asiento asiento : listaAsientos) {
            if (asiento.obtenerNumero() == numero) {
                return asiento;
            }
        }
        return null;
    }
}

class Tren {
    private String numero;
    private String ruta;
    private List<Vagon> listaVagones;

    public Tren(String numero, String ruta) {
        this.numero = numero;
        this.ruta = ruta;
        this.listaVagones = new ArrayList<>();
    }

    public String obtenerNumero() {
        return numero;
    }

    public String obtenerRuta() {
        return ruta;
    }

    public void agregarVagon(Vagon vagon) {
        listaVagones.add(vagon);
    }

    public Vagon obtenerVagon(String tipo) {
        for (Vagon vagon : listaVagones) {
            if (vagon.obtenerTipo().equals(tipo)) {
                return vagon;
            }
        }
        return null;
    }
}

class Viaje {
    private String fecha;
    private String horaSalida;
    private String horaLlegada;
    private Tren tren;

    public Viaje(String fecha, String horaSalida, String horaLlegada, Tren tren) {
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.tren = tren;
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

    public Tren obtenerTren() {
        return tren;
    }
}


class Boleto {
    private Cliente cliente;
    private Viaje viaje;
    private Asiento asiento;

    public Boleto(Cliente cliente, Viaje viaje, Asiento asiento) {
        this.cliente = cliente;
        this.viaje = viaje;
        this.asiento = asiento;
    }

    public Cliente obtenerCliente() {
        return cliente;
    }

    public Viaje obtenerViaje() {
        return viaje;
    }

    public Asiento obtenerAsiento() {
        return asiento;
    }
}


class SistemaCompraBoletos {
    public static void main(String[] args) {

        Tren tren = new Tren("123", "Ruta A-B");


        Vagon vagonEconómico = new Vagon("económica", 50);
        Vagon vagonTurista = new Vagon("turista", 30);
        tren.agregarVagon(vagonEconómico);
        tren.agregarVagon(vagonTurista);


        Viaje viaje = new Viaje("2024-08-30", "08:00", "12:00", tren);


        Cliente cliente = new Cliente("Ana Gómez", "987654321", "Avenida Siempre Viva");


        Asiento asiento = vagonEconómico.obtenerAsiento(10);
        asiento.reservar();

        Boleto boleto = new Boleto(cliente, viaje, asiento);


        System.out.println("Boleto comprado:");
        System.out.println("Cliente: " + boleto.obtenerCliente().obtenerNombre());
        System.out.println("Fecha del viaje: " + boleto.obtenerViaje().obtenerFecha());
        System.out.println("Tren número: " + boleto.obtenerViaje().obtenerTren().obtenerNumero());
        System.out.println("Asiento número: " + boleto.obtenerAsiento().obtenerNumero());
        System.out.println("Estado del asiento: " + boleto.obtenerAsiento().obtenerEstado());
    }
}
