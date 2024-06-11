import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Добро пожаловать в игру 'Угадай число'!");
        System.out.println("Введите минимальное и максимальное значения для диапазона чисел:");

        System.out.print("Минимальное значение: ");
        int min = scanner.nextInt();

        System.out.print("Максимальное значение: ");
        int max = scanner.nextInt();

        int secretNumber = random.nextInt(max - min + 1) + min;
        int guess;
        boolean guessed = false;

        System.out.println("Программа загадала число в диапазоне от " + min + " до " + max + ".");
        System.out.println("Попробуйте угадать его!");

        while (!guessed) {
            System.out.print("Введите ваше предположение: ");
            guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("Поздравляем! Вы угадали число " + secretNumber + "!");
                guessed = true;
            } else if (guess < secretNumber) {
                System.out.println("Загаданное число больше.");
            } else {
                System.out.println("Загаданное число меньше.");
            }
        }

        scanner.close();
    }
}
