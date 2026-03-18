package org.hojatrabajo.hashmaps;

import org.hojatrabajo.model.Product;

import java.util.Map;

/**
 * Interfaz que define el contrato para la fábrica de mapas.
 */
public interface MapFactory {

    /**
     * Crea y retorna una nueva instancia de Map
     * @return Una implementación concreta de Map.
     */
    <K, V> Map<K, V> createMap();
}