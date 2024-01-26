package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
	HashMap<String, ArrayList<String>> dinnerMenu;

	Random random = new Random();

	DinnerConstructor() {
		dinnerMenu = new HashMap<>();
	}

	void addDishToMenu(String dishType, String dishName) {
		if (dinnerMenu.containsKey(dishType)) {
			ArrayList<String> dish = dinnerMenu.get(dishType);

			for (String dishItem : dish) {
				if (dishItem.equals(dishName)) {
					System.out.println(dishName + " уже есть в списке с типом блюда: " + dishType);
					return;
				}
			}

			dish.add(dishName);
			System.out.println("Добавили блюдо: " + dishName + " в существующи список блюд с типом: " + dishType);
		} else {
			ArrayList<String> dish = new ArrayList<>();
			dish.add(dishName);
			dinnerMenu.put(dishType, dish);
			System.out.println("Добавили блюдо: " + dishName + " в список блюд с типом: " + dishType);
		}
	}

	boolean containDishTypeInMenu (String dishType) {
		return dinnerMenu.containsKey(dishType);
	}

	HashMap<String, ArrayList<String>> getComboMenu(int numberOfCombos, ArrayList<String> dishTypes) {
		HashMap<String, ArrayList<String>> comboMenu = new HashMap<>();
		for (int i = 1; i <= numberOfCombos; i++) {
			ArrayList<String> combo = new ArrayList<>();
			for (String dishType : dishTypes) {
				ArrayList<String> dish = dinnerMenu.get(dishType);
				int randomPosition = random.nextInt(dish.size());

				combo.add(dish.get(randomPosition));
			}
			comboMenu.put("Комбо " + i, combo);
		}
		return comboMenu;
	}
}
