package me.practice.PracticeWithNumbers;

import java.util.Scanner;

/*
    На вход приходят два числа: n и k.
    n - кол-во записанных чисел (числа приходят не отсортированные)
    k - кол-во операций, которые можно совершить с числами
    Операция с числами - взять число и заменить любую цифру числа на другую.
    Цель: получить максимальную разность между конечной и начальной суммой.
 */

 /*Планирую отсортировывать исходный массив чисел и далее смотреть на наименьшие двухзначные числа,
 так как они дадут наибольший прирост к новой сумме. До цифр двухзначенного числа буду добираться
 с помощью деления на 10.*/

public class prwn {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите кол-во чисел");
        int n = sc.nextInt();
        int arrNumbers[] = new int[n];


        for (int i = 0; i < arrNumbers.length; i++) {
            int numb = sc.nextInt();
            arrNumbers[i] = numb;
        }

        for (int i = 0; i < arrNumbers.length; i++) {
            System.out.println(arrNumbers[i]);
        }
    }
}
