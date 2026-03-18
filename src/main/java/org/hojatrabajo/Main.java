package org.hojatrabajo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.hojatrabajo.hashmaps.HashMapFactory;
import org.hojatrabajo.hashmaps.MapFactory;
import org.hojatrabajo.hashmaps.SelectFactory;
import org.hojatrabajo.model.Product;
import org.hojatrabajo.reader.InventoryReader;


public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Map<String,Product> inventory;

        try {
            inventory = InventoryReader.readInventory("inventario.txt");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
            return;
        }

        MapFactory factory = null;
        String producto;
        int menu = 0;
        int opcion = 0;

        System.out.println("Bienvenido al Programa");
        while (factory == null){
        System.out.println("Ingrese el tipo de Map");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        opcion = teclado.nextInt();
        try {factory = SelectFactory.select(opcion);}
        catch (Exception e){System.out.println("Seleccione una de las 3 opciones válidas");}}

        Store store = new Store(inventory,factory);

        while (menu!=7){
            System.out.println("\n===============================");
            System.out.println("              Menu");
            System.out.println("===============================");
            System.out.println("Seleccione una opción");
            System.out.println("1.Agregar producto al carrito");
            System.out.println("2.Mostrar categoría de producto");
            System.out.println("3. Mostrar carrito");
            System.out.println("4. Mostrar carrito ordenado");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Mostrar inventario Ordenado");
            System.out.println("7. Salir");

            menu = teclado.nextInt();
            teclado.nextLine();

            switch (menu){
                case 1:
                    System.out.println("\nIngresar el Producto");
                    producto = teclado.nextLine();
                    if (producto.isEmpty()) {
                        System.out.println("Ingrese un producto válido");
                        break;
                    }
                    store.addProductToCart(producto);
                    break;
                case 2:
                    System.out.println("\nIngrese el Producto del que desea ver la categoría");
                    producto = teclado.nextLine();

                    if (producto.isEmpty()) {
                        System.out.println("Ingrese un producto válido");
                        break;
                    }
                    store.showProductCategory(producto);
                    break;

                case 3:
                    store.showUserCart();
                    break;
                case 4:
                    store.showUserCartSortedByCategory();
                    break;
                case 5:
                    store.showFullInventory();
                    break;
                case 6:
                    store.showFullInventorySortedByCategory();
                    break;
                case 7:
                    System.out.println("Saliendo del programa.......");
                    break;
                default:
                    System.out.println("Seleccione una opción válida");
            }
        }
        teclado.close();

    }
}