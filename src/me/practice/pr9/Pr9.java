package me.practice.pr9;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr9 {
    public static void main(String[] args) throws Exception {
        Pr9 mainObject = new Pr9();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Map<Integer, String> fruits = new HashMap<Integer, String>();

        mainObject.createHashMap(fruits);
        mainObject.findFruit(fruits, number);
    }

    //Метод заполняет хеш-мапу значениями из файла.
    public Map<Integer, String> createHashMap(Map<Integer, String> myMap) throws Exception {
        try {
            FileReader fr = new FileReader("E:\\java\\src\\me\\practice\\Pr9\\DataForMap.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                int key = sc.nextInt();
                String value = sc.nextLine();
                myMap.put(key, value);
            }
            fr.close();
        } catch (IOException exception) {
            exception.getMessage();
        }
        if (myMap.isEmpty()) {
            System.out.println("Похоже коллекция пуста!");
        }
        return myMap;
    }

    //Метод получает число от пользователя и определяет соответствующий фрукт
    public void findFruit(Map<Integer, String> myMap, int numberFromUser) {
        int sumDigits = 0;

        //Используем цикл do while из-за условия задачи:
        //в любом случае нужно будет пересчитывать заданное число, а затем искать его в списке.
        //Далее высчитываем новое число, основываясь на цифрах, из которых состояло старое число.
        do {
            sumDigits = numberFromUser / 100 + numberFromUser / 10 % 10 + numberFromUser % 10;
            System.out.println("Сумма цифр числа = " + sumDigits);
            numberFromUser = numberFromUser - sumDigits;
            System.out.println("Новое число = " + numberFromUser);
        } while (!myMap.containsKey(numberFromUser));
        System.out.println("Фрукт, который подходит по получившемуся числу: " + myMap.get(numberFromUser));
    }
}
