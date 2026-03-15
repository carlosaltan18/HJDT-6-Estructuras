package org.hojatrabajo.hashmaps;

import org.hojatrabajo.model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementación del patrón Factory que crea unHashMap.

 *

 */
public class HashMapFactory implements MapFactory {

    /**
     * Crea y retorna un nuevo HashMap vacío.
     *
     * @return Nueva instancia
     */
    @Override
    public Map<String, Product> createMap() {
        return new HashMap<>();
    }
}