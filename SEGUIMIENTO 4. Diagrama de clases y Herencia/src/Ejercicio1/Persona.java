package Ejercicio1;

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

//clase cliente heredada de persona
class Cliente extends Persona {
    private String historialCrediticio;
    private double ingresos;

    public Cliente(String nombre, String identificacion, String direccion, String historialCrediticio, double ingresos) {
        super(nombre, identificacion, direccion);
        this.historialCrediticio = historialCrediticio;
        this.ingresos = ingresos;
    }

    public String obtenerHistorialCrediticio() {
        return historialCrediticio;
    }

    public double obtenerIngresos() {
        return ingresos;
    }
}


class Propiedad {
    private String direccion;
    private double valor;

    public Propiedad(String direccion, double valor) {
        this.direccion = direccion;
        this.valor = valor;
    }

    public String obtenerDireccion() {
        return direccion;
    }

    public double obtenerValor() {
        return valor;
    }
}

class SolicitudCredito {
    private Cliente cliente;
    private String tipoCredito;
    private double monto;
    private int plazo;
    private double tasaInteres;

    public SolicitudCredito(Cliente cliente, String tipoCredito, double monto, int plazo, double tasaInteres) {
        this.cliente = cliente;
        this.tipoCredito = tipoCredito;
        this.monto = monto;
        this.plazo = plazo;
        this.tasaInteres = tasaInteres;
    }

    public Cliente obtenerCliente() {
        return cliente;
    }

    public String obtenerTipoCredito() {
        return tipoCredito;
    }

    public double obtenerMonto() {
        return monto;
    }

    public int obtenerPlazo() {
        return plazo;
    }

    public double obtenerTasaInteres() {
        return tasaInteres;
    }
}


class Credito {
    private SolicitudCredito solicitudCredito;
    private String estado; // "aprobado", "rechazado", "pendiente"

    public Credito(SolicitudCredito solicitudCredito) {
        this.solicitudCredito = solicitudCredito;
        this.estado = "pendiente";
    }

    public SolicitudCredito obtenerSolicitudCredito() {
        return solicitudCredito;
    }

    public String obtenerEstado() {
        return estado;
    }

    public void aprobar() {
        estado = "aprobado";
    }

    public void rechazar() {
        estado = "rechazado";
    }
}

class CreditoHipotecario extends Credito {
    private Propiedad propiedad;

    public CreditoHipotecario(SolicitudCredito solicitudCredito, Propiedad propiedad) {
        super(solicitudCredito);
        this.propiedad = propiedad;
    }

    public Propiedad obtenerPropiedad() {
        return propiedad;
    }
}

//Pruebas
class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Carlos Arturo Baron", "1092454986", "Armeniaaa", "Buen historial", 5000);

        SolicitudCredito solicitud = new SolicitudCredito(cliente, "hipotecario", 200000, 20, 3.5);

        Propiedad propiedad = new Propiedad("Avenida Principal 456", 250000);

        CreditoHipotecario creditoHipotecario = new CreditoHipotecario(solicitud, propiedad);

        creditoHipotecario.aprobar();

        System.out.println("Cliente: " + creditoHipotecario.obtenerSolicitudCredito().obtenerCliente().obtenerNombre());
        System.out.println("Tipo de Crédito: " + creditoHipotecario.obtenerSolicitudCredito().obtenerTipoCredito());
        System.out.println("Monto: " + creditoHipotecario.obtenerSolicitudCredito().obtenerMonto());
        System.out.println("Estado: " + creditoHipotecario.obtenerEstado());
        System.out.println("Propiedad: " + creditoHipotecario.obtenerPropiedad().obtenerDireccion());
    }
}
