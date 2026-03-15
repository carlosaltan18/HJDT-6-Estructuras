package org.hojatrabajo.hashmaps;

import org.hojatrabajo.model.Product;

import java.util.Map;
import java.util.TreeMap;

/**
 * Implementación del patrón Factory que crea un TreeMap
 */
public class TreeMapFactory implements MapFactory {

    /**
     * Crea y retorna un nuevo {TreeMap vacío.
     *
     * @return Nueva instancia de TreeMap.
     */
    @Override
    public Map<String, Product> createMap() {
        return new TreeMap<>();
    }
}