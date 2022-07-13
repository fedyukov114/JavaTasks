package me.practice.pr9;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class pr9 {
    public static void main(String[] args) throws Exception {
        pr9 mainObject = new pr9();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sumDigits = 0;
        Map<Integer, String> fruits = new HashMap<Integer, String>();

        mainObject.createHashMap(fruits);

        //Проверяем больше ли 100 заданное число. От этого зависит способ отсчета
        if (number > 100) {
            //Через деление получаем цифры трехзначного числа
            while (number > 100) {
                sumDigits = number / 100;
            }
        }
    }


    //Метод заполняет хеш-мапу значениями из файла.
    public Map<Integer, String> createHashMap(Map<Integer, String> myMap) throws Exception {
        try {
            FileReader fr = new FileReader("E:\\java\\src\\me\\practice\\pr9\\DataForMap.txt");
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
            System.out.println("Ops, seems like your collection is empty.");
        }
        return myMap;
    }
}
