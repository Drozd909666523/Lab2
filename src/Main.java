import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int [n];
        int countOfCubes = 0;
        int temp;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && Math.sqrt(arr[i]) - (int)Math.sqrt(arr[i]) == 0) {
                temp = arr[i];
                for (int j = i; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = temp;
            }
        }
        System.out.print("Новый массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < n; i++) {
            if (Math.cbrt(arr[i]) - (int)Math.cbrt(arr[i]) == 0) {
                countOfCubes++;
            }
        }
        System.out.println("\nКоличество чисел, являющихся кубами: " + countOfCubes);

        System.out.print("Массив с извлеченными квадратами: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && Math.sqrt(arr[i]) - (int)Math.sqrt(arr[i]) == 0) {
                System.out.print((int)Math.sqrt(arr[i]) + " ");
            } else {
                System.out.print((int)arr[i] + " ");
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                temp = arr[i];
                arr[i] = 1;
                for (int j = 2; j <= temp; j++) {
                    if (true) {
                        arr[i] *= j;
                    } else {
                        arr[i] = temp;
                        System.out.print("\nФакториал " + i + 1 + " числа слишком большой для хранения.");
                    }
                }
            }
        }

        System.out.print("\nМассив с числами, заменёнными на факториалы: ");
        for (int i = 0; i < n; i++) {

        }
    }
}