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
        int sumDigits = 0;
        Map<Integer, String> fruits = new HashMap<Integer, String>();

        mainObject.createHashMap(fruits);

        //Используем цикл do while из-за условия задачи:
        //в любом случае нужно будет пересчитывать заданное число, а затем искать его в списке.
        //Далее высчитываем новое число, основываясь на цифрах, из которых состояло старое число.
        do {
            sumDigits = number / 100 + number / 10 % 10 + number % 10;
            System.out.println("Сумма цифр числа = " + sumDigits);
            number = number - sumDigits;
            System.out.println("Новое число = " + number);
        } while (!fruits.containsKey(number));
        System.out.println("Фрукт, который подходит по получившемуся числу: " + fruits.get(number));
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
        }
        catch (IOException exception){
            exception.getMessage();
        }
        if (myMap.isEmpty()){
            System.out.println("Похоже коллекция пуста");
        }
        return myMap;
    }
}
