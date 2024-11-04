import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Создание переменных
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int [n];
        int countOfCubes = 0;
        int temp;

        // Заполнение массива (пункт 1)
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Сортировка массива от большего к меньшему
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Перемещение всех квадратов в начало массива
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && Math.sqrt(arr[i]) - (int)Math.sqrt(arr[i]) == 0) {
                temp = arr[i];
                for (int j = i; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = temp;
            }
        }
        // Выводим ответ на пункт 2
        System.out.print("Новый массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Считаем количество кубов в массиве
        for (int i = 0; i < n; i++) {
            if (Math.cbrt(arr[i]) - (int)Math.cbrt(arr[i]) == 0) {
                countOfCubes++;
            }
        }
        // Выводим ответ на пункт 3
        System.out.println("\nКоличество чисел, являющихся кубами: " + countOfCubes);

        // Находим квадраты в массиве и выводим их корни (пункт 4)
        System.out.print("Массив с извлеченными квадратами: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && Math.sqrt(arr[i]) - (int)Math.sqrt(arr[i]) == 0) {
                System.out.print((int)Math.sqrt(arr[i]) + " ");
            } else {
                System.out.print(arr[i] + " ");
            }
        }

        // Считаем факториал числа, если он помещается в массив,
        // иначе оставляем не тронутым
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                temp = arr[i];
                arr[i] = 1;
                for (int j = 2; j <= temp; j++) {
                    if (arr[i] <= (Math.pow(2, 31) - 1) / j){
                        arr[i] *= j;
                    } else {
                        arr[i] = temp;
                        System.out.print("\nФакториал " + (i + 1) + " числа слишком большой для хранения.");
                        break;
                    }
                }
            }
        }

        // Выводим ответ на пункт 5
        System.out.print("\nМассив с числами, заменёнными на факториалы: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}