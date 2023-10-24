package Task2;

import java.util.Scanner;

public class KnightMoving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Chessboard chessboard = new Chessboard();
        String startPosition;
        String movingPosition;
        String isContinue;

        while (true) {
            System.out.print("Установите положение коня (например, А3): ");
            startPosition = scanner.next();
            if (chessboard.isPositionValid(startPosition)) {
                System.out.print("Куда сдвинуть коня? (например, В5): ");
                movingPosition = scanner.next();
                if (chessboard.isMovingValid(startPosition, movingPosition)) {
                    System.out.println("Ход возможен!");
                } else {
                    System.out.println("Ход невозможен!");
                }
            } else {
                System.out.print("Неправильное положение коня! ");
                continue;
            }

            while (true) {
                System.out.print("Продолжить выполнение программы? (YES / NO): ");
                isContinue = scanner.next();
                if (isContinue.equals("NO")) {
                    System.out.println("Завершение программы");
                    return;
                } else if (isContinue.equals("YES")) {
                    System.out.println();
                    break;
                } else {
                    System.out.print("Неизвестная команда! ");
                }
            }
        }
    }
}
