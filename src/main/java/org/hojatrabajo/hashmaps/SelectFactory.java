package org.hojatrabajo.hashmaps;
import org.hojatrabajo.model.Product;

import java.util.*;

public class SelectFactory {

    public static MapFactory select(int n) {
        MapFactory factory;
         switch (n) {
             case 1: {
                return new HashMapFactory();
            }
             case 2: {
                return new TreeMapFactory();
            }
             case 3: {
                return new LinkedHashMapFactory();
            }
             default: throw new IllegalArgumentException("Opción Inválida");
        }
    }
}
