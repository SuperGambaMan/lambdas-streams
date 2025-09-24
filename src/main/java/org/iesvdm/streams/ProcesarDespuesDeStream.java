package org.iesvdm.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ProcesarDespuesDeStream {
    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        // Quieres extraer los platos bajos en calorias a la coleccion de
        // lowCaloricDishes

        Predicate<Dish> dishBajaCalories = x -> x.getCalories() < 300;

        // Estilo de procesamiento Java 8+
        List<String> listLowCalories = menu.stream()
                .filter(dishBajaCalories)// Despues de este metodo en el flujo que sigue solo hay platos con
                                                   // menos de 400 calorias
                .sorted(Comparator.comparing(x -> x.getCalories()))// Ordena los platos del flujo por calorias
                .map(x -> x.getName())// Extrae el nombre de los platos del flujo
                .toList();// Recoge los elementos del flujo en una lista 
        /* List<String> listLowCalories = menu.stream()
                .filter(x -> x.getCalories() < 400)// Despues de este metodo en el flujo que sigue solo hay platos con
                                                   // menos de 400 calorias
                .sorted(Comparator.comparing(x -> x.getCalories()))// Ordena los platos del flujo por calorias
                .map(x -> x.getName())// Extrae el nombre de los platos del flujo
                .toList();// Recoge los elementos del flujo en una lista */

        System.out.println(listLowCalories);
    }

}
