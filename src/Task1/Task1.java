package Task1;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        while (true) {
            System.out.print("Введите размер масива: ");
            size = scanner.nextInt();
            if (size <= 0) {
                System.out.print("Массив не может быть пустым или содержать отрицательное количество элементов! ");
            }
            else {
                break;
            }
        }

        int[] array = new int[size];
        fillArray(array);
        printArray(array);
        int result = numberOfUniqueElements(array);
        System.out.println("Количество уникальных элементов = " + result);
    }

    private static int numberOfUniqueElements(int[] array) {
        int result = 0;
        boolean isUnique;
        for (int i = 0; i < array.length; i++) {
            isUnique = true;
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                result++;
            }
        }
        return result;
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(11);
        }
    }

    public static void printArray(int[] array) {
        System.out.println("Массив:");
        for (int element : array) {
            System.out.print(element + "\t");
        }
        System.out.println();
    }
}
