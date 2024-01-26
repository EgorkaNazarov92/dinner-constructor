package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Досвидания!");
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // добавьте новое блюдо
        dc.addDishToMenu(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> dishTypes = new ArrayList<>();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (dc.containDishTypeInMenu(nextItem)) {
                dishTypes.add(nextItem);
            } else {
                System.out.println("Такого типа блюда нет в меню! Выберите что нибудь другое.");
            }
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        if (dishTypes.isEmpty()){
            System.out.println("Не получилось сформировать комбо меню, так как нет подходящих типов блюд");
        } else {
            HashMap<String, ArrayList<String>> combos = dc.getComboMenu(numberOfCombos, dishTypes);
            for (String comboItem : combos.keySet()) {
                System.out.println(comboItem);
                System.out.println(combos.get(comboItem));
            }
        }
    }
}
