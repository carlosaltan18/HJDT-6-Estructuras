package org.hojatrabajo;

import org.hojatrabajo.hashmaps.MapFactory;
import org.hojatrabajo.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase que representa la tienda online y gestiona las operaciones sobre los
 * productos, tanto del inventario general como de la colección personal del usuario.
 *
 */
public class Store {

    private final Map<String, Product> inventory;
    private final Map<String, Integer> userCart;

    /**
     * Constructor que inicializa la tienda con el inventario y la implementación
     * de mapa elegida por el usuario.
     */
    public Store(Map<String, Product> inventory, MapFactory factory) {
        this.inventory = inventory;
        @SuppressWarnings("unchecked")
        Map<String, Integer> cart = (Map<String, Integer>) (Map<?, ?>) factory.createMap();
        this.userCart = cart;
    }

    /**
     * Agrega un producto a la colección del usuario buscándolo por nombre.
     * Si el producto no existe en el inventario, muestra un mensaje de error.
     * El usuario puede agregar el mismo producto más de una vez; la cantidad
     * se acumula.
     *
     * @param productName Nombre del producto que el usuario desea agregar.
     */
    public void addProductToCart(String productName) {
        String key = productName.toLowerCase();
        if (!inventory.containsKey(key)) {
            System.out.println("ERROR: El producto '" + productName +
                    "' no existe en el inventario.");
            return;
        }
        userCart.merge(inventory.get(key).getName(), 1, Integer::sum);
        System.out.println("Producto '" + inventory.get(key).getName() +
                "' agregado a su colección.");
    }

    /**
     * Muestra la categoría de un producto del inventario dado su nombre.
     * Si el producto no existe, muestra un mensaje de error.
     * @param productName Nombre del producto a buscar.
     */
    public void showProductCategory(String productName) {
        String key = productName.toLowerCase();
        if (!inventory.containsKey(key)) {
            System.out.println("ERROR: El producto '" + productName +
                    "' no se encuentra en el inventario.");
            return;
        }
        Product p = inventory.get(key);
        System.out.println("Producto: " + p.getName() +
                " → Categoría: " + p.getCategory());
    }
    /**
     * Muestra los productos de la colección del usuario con su categoría y
     * cantidad. No garantiza ningún orden particular.
     */
    public void showUserCart() {
        if (userCart.isEmpty()) {
            System.out.println("Su colección está vacía.");
            return;
        }
        System.out.println("\n====== Su Colección ======");
        System.out.printf("%-35s %-25s %s%n", "Producto", "Categoría", "Cantidad");
        System.out.println("-".repeat(70));

        for (Map.Entry<String, Integer> entry : userCart.entrySet()) {
            Product p = inventory.get(entry.getKey().toLowerCase());
            if (p != null) {
                System.out.printf("%-35s %-25s %d%n",
                        p.getName(), p.getCategory(), entry.getValue());
            }
        }
        System.out.println("=".repeat(70));
    }

    /**
     * Muestra los productos de la colección del usuario ordenados alfabéticamente
     * por categoría y, dentro de cada categoría, por nombre del producto.
     */
    public void showUserCartSortedByCategory() {
        if (userCart.isEmpty()) {
            System.out.println("Su colección está vacía.");
            return;
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(userCart.entrySet());
        entries.sort(Comparator.comparing(
                e -> {
                    Product p = inventory.get(e.getKey().toLowerCase());
                    return p != null ? p.getCategory() : "";
                },
                Comparator.naturalOrder()
        ));

        System.out.println("\n====== Su Colección (ordenada por categoría) ======");
        System.out.printf("%-35s %-25s %s%n", "Producto", "Categoría", "Cantidad");
        System.out.println("-".repeat(70));

        for (Map.Entry<String, Integer> entry : entries) {
            Product p = inventory.get(entry.getKey().toLowerCase());
            if (p != null) {
                System.out.printf("%-35s %-25s %d%n",
                        p.getName(), p.getCategory(), entry.getValue());
            }
        }
        System.out.println("=".repeat(70));
    }

    /**
     * Muestra todos los productos del inventario con su categoría.
     * No garantiza ningún orden particular (depende de la implementación interna).
     */
    public void showFullInventory() {
        System.out.println("\n====== Inventario Completo ======");
        System.out.printf("%-35s %-25s%n", "Producto", "Categoría");
        System.out.println("-".repeat(62));

        for (Product p : inventory.values()) {
            System.out.printf("%-35s %-25s%n", p.getName(), p.getCategory());
        }
        System.out.println("=".repeat(62));
    }


    /**
     * Muestra todos los productos del inventario ordenados alfabéticamente
     * por categoría y, dentro de cada categoría, por nombre del producto.
     */
    public void showFullInventorySortedByCategory() {
        TreeMap<String, Product> sorted = new TreeMap<>();
        for (Product p : inventory.values()) {
            sorted.put(p.getCategory() + "|" + p.getName(), p);
        }

        System.out.println("\n====== Inventario Completo (ordenado por categoría) ======");
        System.out.printf("%-35s %-25s%n", "Producto", "Categoría");
        System.out.println("-".repeat(62));

        for (Product p : sorted.values()) {
            System.out.printf("%-35s %-25s%n", p.getName(), p.getCategory());
        }
        System.out.println("=".repeat(62));
    }

    /**
     * Retorna el mapa del carrito del usuario
     * @return El mapa interno del carrito del usuario.
     */
    public Map<String, Integer> getUserCart() {
        return userCart;
    }

    /**
     * Retorna el inventario completo
     * @return El mapa del inventario completo.
     */
    public Map<String, Product> getInventory() {
        return inventory;
    }
}