package org.hojatrabajo.model;

/**
 * Representa un producto del inventario de la tienda online.
 * Contiene información sobre la categoría y el nombre del producto.
 */
public class Product {

    private String category;
    private String name;

    /**
     * Constructor que inicializa un producto con su categoría y nombre.
     *
     * @param category Categoría del producto
     * @param name     Nombre del producto
     */
    public Product(String category, String name) {
        this.category = category;
        this.name = name;
    }

    /**
     * Retorna la categoría del producto.
     * @return La categoría del producto.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Retorna el nombre del producto.
     * @return El nombre del producto.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna una representación en cadena del producto.
     * @return Cadena con formato "Categoría | Nombre".
     */
    @Override
    public String toString() {
        return category + " | " + name;
    }
}