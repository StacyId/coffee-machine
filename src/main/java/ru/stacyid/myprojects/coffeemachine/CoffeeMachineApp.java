package ru.stacyid.myprojects.coffeemachine;

import java.util.Scanner;

public class CoffeeMachineApp {

    private static int coffee = 0;
    private static int water = 0;
    private static int milk = 0;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        do {
            String commandWithValue = console.nextLine();
            if (commandWithValue.equals("turn off")) {
                break;
            }

            String[] split = commandWithValue.split(" ");

            String command = split[0];
            int value = Integer.parseInt(split[1]);

            switch (command) {
                case "water":
                    water = value;
                    break;
                case "milk":
                    milk = value;
                    break;
                case "coffee":
                    coffee = value;
                    break;
                case "latte": {
                    makeCoffee(value, 0.1, 0.3, 0.6);
                    break;
                }
                case "ristretto": {
                    makeCoffee(value, 0.5, 0.5, 0);
                    break;
                }
                case "cappuccino": {
                    makeCoffee(value, 0.15, 0.4, 0.45);
                    break;
                }
                case "lungo": {
                    makeCoffee(value, 0.15, 0.85, 0);
                    break;
                }
                case "espresso": {
                    makeCoffee(value, 0.3, 0.7, 0);
                    break;
                }
                default: {
                    System.out.println("Тип кофе не найден");
                    break;
                }
            }
        }
        while(true);
    }

    private static void makeCoffee(
            int value,
            double perCoffee,
            double perWater,
            double perMilk
    ) {
        if (value < 10) {
            System.out.println("Объем кофе для приготовления должен быть не меньше 10 мл");
            return;
        }

        int coffeeResult = (int) (coffee - value * perCoffee);
        if (perCoffee == 0 || coffeeResult >= 0) {
            coffee = coffeeResult;
        }
        else {
            System.out.println("Недостаточно кофе");
            return;
        }

        int waterResult = (int) (water - value * perWater);
        if (perWater == 0 || waterResult >= 0) {
            water = waterResult;
        }
        else {
           System.out.println("Недостаточно воды");
           return;
        }

        int milkResult = (int) (milk - value * perMilk);
        if (perMilk == 0 || milkResult >= 0) {
            milk = milkResult;
        }
        else {
            System.out.println("Недостаточно молока");
            return;
        }

        System.out.println(coffee + " " + water + " " + milk);
    }
}
