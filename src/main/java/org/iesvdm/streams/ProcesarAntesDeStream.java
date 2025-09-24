package org.iesvdm.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProcesarAntesDeStream {
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
				 new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		//Quieres extraer los platos bajos en calorias a la coleccion de lowCaloricDishes
		
        List<Dish> lowCaloricDishes = new ArrayList<>();
		
		//Estilo de procesamiento Java <=7

		// for-each
		for (Dish dish : menu) {
			if (dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			public int compare(Dish dish1, Dish dish2) {
				return Integer.compare(dish1.getCalories(), dish2.getCalories());
			}
		});
		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish dish : lowCaloricDishes) {
			lowCaloricDishesName.add(dish.getName());
		}
		System.out.println(lowCaloricDishesName);
	}
}