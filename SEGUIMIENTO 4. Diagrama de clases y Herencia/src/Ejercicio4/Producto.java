package Ejercicio4;

import java.util.ArrayList;
import java.util.List;

class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    public Producto(String nombre, String descripcion, double precio, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public int obtenerStock() {
        return stock;
    }

    public void modificarStock(int nuevoStock) {
        this.stock = nuevoStock;
    }

    public void modificarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Descripción: " + descripcion +
                ", Precio: $" + precio + ", Stock: " + stock;
    }
}

class ProductoPerecedero extends Producto {
    private String fechaVencimiento;

    public ProductoPerecedero(String nombre, String descripcion, double precio, int stock, String fechaVencimiento) {
        super(nombre, descripcion, precio, stock);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String obtenerFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fecha de Vencimiento: " + fechaVencimiento;
    }
}

class GestionProductos {
    private List<Producto> productos;

    public GestionProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(p -> p.obtenerNombre().equals(nombre));
    }

    public void modificarProducto(String nombre, double nuevoPrecio, int nuevoStock) {
        for (Producto producto : productos) {
            if (producto.obtenerNombre().equals(nombre)) {
                producto.modificarPrecio(nuevoPrecio);
                producto.modificarStock(nuevoStock);
                break;
            }
        }
    }

    public void listarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}

class SistemaGestionProductos {
    public static void main(String[] args) {
        // Crear algunos productos
        Producto producto1 = new Producto("Laptop", "Laptop de 15 pulgadas", 1000.00, 10);
        ProductoPerecedero producto2 = new ProductoPerecedero("Leche", "Leche de 1 litro", 1.50, 50, "2024-09-30");


        GestionProductos gestion = new GestionProductos();
        gestion.agregarProducto(producto1);
        gestion.agregarProducto(producto2);


        System.out.println("Lista de productos:");
        gestion.listarProductos();


        gestion.modificarProducto("Laptop", 950.00, 8);
        System.out.println("\nLista de productos después de la modificación:");
        gestion.listarProductos();

        gestion.eliminarProducto("Leche");
        System.out.println("\nLista de productos después de eliminar la leche:");
        gestion.listarProductos();
    }
}

