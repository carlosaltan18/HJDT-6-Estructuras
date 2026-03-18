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
    public <K,V>Map<K, V> createMap() {return new HashMap<>();}
}