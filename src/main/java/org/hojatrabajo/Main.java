package org.hojatrabajo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.hojatrabajo.hashmaps.HashMapFactory;
import org.hojatrabajo.hashmaps.MapFactory;
import org.hojatrabajo.hashmaps.SelectFactory;
import org.hojatrabajo.model.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Map<String,Product> inventory = new HashMap<>();
        Store store;
        int menu = 0;
        int opcion = 0;

        while (menu!=4){
            System.out.println("Bienvenido al programa");
            System.out.println("Seleccione una opción");
            System.out.println("1.Seleccionar Tipo de Map");
            menu = teclado.nextInt();
            switch (menu){
                case 1:
                    System.out.println("Ingrese el tipo de Map");
                    System.out.println("1. HashMap");
                    System.out.println("2. TreeMap");
                    System.out.println("3. LinkedHashMap");
                    opcion = teclado.nextInt();
                    MapFactory factory = SelectFactory.select(opcion);
                    store = new Store(inventory,factory);

            }
        }

    }
}