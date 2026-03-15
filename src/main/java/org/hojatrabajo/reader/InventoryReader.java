package org.hojatrabajo.reader;

import org.hojatrabajo.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Lee el archivo {@code inventario.txt} y carga todos los productos en un
 */
public class InventoryReader {

    private static final String DELIMITER = "\\|";

    /**
     * Lee el archivo de inventario y retorna un mapa con todos los productos.
     * @param filePath Ruta al archivo
     * @return  con todos los productos del inventario.
     * @throws IOException Si el archivo no se encuentra o no puede leerse.
     */
    public static Map<String, Product> readInventory(String filePath) throws IOException {
        Map<String, Product> inventory = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || !line.contains("|")) continue;

                String[] parts = line.split(DELIMITER, 2);
                if (parts.length == 2) {
                    String category = parts[0].trim();
                    String productName = parts[1].trim();
                    if (category.equalsIgnoreCase("categoria") ||
                            category.equalsIgnoreCase("categoría")) continue;

                    inventory.put(productName.toLowerCase(), new Product(category, productName));
                }
            }
        }
        return inventory;
    }
}