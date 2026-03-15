package org.hojatrabajo.hashmaps;

import org.hojatrabajo.model.Product;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementacion de LinkedHashMap
 */
public class LinkedHashMapFactory implements MapFactory {

    /**
     * Crea y retorna un nuevo LinkedHashMap.
     *
     * @return Nueva instancia de LinkedHashMap.
     */
    @Override
    public Map<String, Product> createMap() {
        return new LinkedHashMap<>();
    }
}
