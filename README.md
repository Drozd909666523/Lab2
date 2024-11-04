# Отчет по лабораторной работе № 2

---
№ группы: ПМ-2401

Выполнил: Дроздов Иван Юрьевич

Вариант: 12

### Содержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Напишите программу на Java, которая выполняет следующие действия
с одномерным массивом целых чисел:
> 1. Считывает с консоли число N, затем N целых чисел и заполняет
   массив размером N.
> 2. Размещает числа в массиве таким образом, чтобы сначала шли числа, являющиеся квадратами целых чисел, в порядке возрастания,
   затем остальные числа в порядке убывания.
> 3. Находит и выводит количество чисел в массиве, которые являются
   кубами целых чисел.
> 4. Выводит элементы массива, заменяя числа, являющиеся квадратами, на их квадратные корни, остальные числа оставляет без изменений.
> 5. Заменяет каждое число в массиве на его факториал (если число
   неотрицательное) и выводит полученный массив.

Будем выполнять задачу попунктно:
1. Через цикл for считаем числа, попутно записывая их в массив.
2. Сначала отсортируем массив по убыванию, а потом будем находить числа,
являющиеся квадратами и перемещать их в начало массива
(пример: 6 4 3 8 1 -> 8 6 4 3 1 -> 1 4 8 6 3)

3. Проходим по массиву и считаем числа, являющиеся кубами.
4. Снова проходимся по массиву и если число равно квадрату,
то выводим его корень, иначе выводим само число.
5. проверяем, если число больше или равно нулю,
то считаем его факториал и заменяем в массиве.

Чтобы посчитать факториал k-го числа, будем перемещать число во
временную переменную, а его само приравнивать к 1.
Дальше домножаем число на числа от 2 до k-го числа
Если на этапе домножения мы "выйдем" за диапазон то выводим об
этом сообщение и оставляем исходное число неизменным.

### 2. Входные и выходные данные

#### Данные на вход
По условию известно, что на вход программа должна получать
целое число n, а далее еще n целых чисел. Так как для всех пунктов,
за исключением 5-го (вычисление факториала) не предполагается
использование больших по размеру чисел
(а при подсчёте факториала тип не имеет больших различий
$`12!`$ для int против $`20!`$ для long),
то в силу экономии памяти будем использовать тип int.

|            | Тип                         | min значение | max значение   |
|------------|-----------------------------|--------------|----------------|
| n          | Целое неотрицательное число | 0            | $`2^{31} - 1`$ |
| arr[0]     | Целое число                 | $`-2^{31}`$  | $`2^{31} - 1`$ |
| arr[1]     | Целое число                 | $`-2^{31}`$  | $`2^{31} - 1`$ |
| ...        | ...                         | ...          | ...            |
| arr[n - 1] | Целое число                 | $`-2^{31}`$  | $`2^{31} - 1`$ |

#### Данные на выход
Так как программа должна вывести количество заполненных ванночек,
то число целое $` \leq 4 `$.

|              | Тип                         | Длинна | min значение элемента | max значение элемента |
|--------------|-----------------------------|--------|-----------------------|-----------------------|
| arr          | Массив целых чисел          | n      | $`-2^{31}`$           | $`2^{31} - 1`$        |
| countOfCubes | Целое неотрицательное число |        | 0                     | $`2^{31} - 1`$        |

### 2,5. Математическая модель
Чтобы проверить, является ли число квадратом,
будем брать его корень и смотреть равна ли его дробная часть нулю:

Корень из числа - целая часть корня.

$`\sqrt{n} - \left[\sqrt{n} \right] == 0`$

`(Math.sqrt(arr[i]) - (int)Math.sqrt(arr[i]) == 0)`

Проверка куба происходит по аналогии:
кубический корень из числа - целая часть корня.

$`\sqrt[3]{n} - \left[\sqrt[3]{n} \right] == 0`$

`(Math.cbrt(arr[i]) - (int)Math.cbrt(arr[i]) == 0)`

Чтобы посчитать факториал числа, будем использовать формулу:
$`n! = 1 \cdot 2 \cdot 3 \cdot ... \cdot (n - 1) \cdot n`$

### 3. Выбор структуры данных

|         | Название переменной  | Тип (в java) |
|---------|----------------------|--------------|
| n       | x                    | integer      |
| Число 1 | arr[0]               | integer      |
| Число 2 | arr[1]               | integer      |
| ...     | ...                  | ...          |
| Число n | arr[n - 1]           | integer      |

Результат.

|                                               | Название переменной | Тип (в java) |
|-----------------------------------------------|---------------------|--------------|
| Отсортированный одномерный массив целых чисел | arr                 | integer []   |
| Количество кубов в массиве                    | countOfCubes        | integer      |

### 4. Алгоритм

#### Алгоритм выполнения программы:
##### 1. Ввод данных и создание переменных:
Программа считывает целое число n.

Создаем массив arr размером n.

Создаем счётчик кубов countOfCubes.

Далее через цикл считываем n целых чисел и заносим их в массив arr.
##### 2. Сортировка чисел:
Сортируем числа от большего к меньшему,
попарно сравнивая числа и меняя местами, если 1-е меньше 2-ого.

Проходим по массиву и если число является квадратом,
то перемещаем число в начало массива, а все элементы до
квадрата сдвигаем на 1 вперёд.

Выводим ответ на пункт 2
##### 3. Решение пункта 3:
Считаем количество кубов в массиве

Выводим ответ на пункт 3
##### 4. Решение пункта 4:
Проходим по массиву, если число является квадратом выводим его корень,
иначе выводим само число
##### 5. Замена чисел на факториал:
Проходим по массиву, если число больше нуля,
то считаем его факториал,
иначе оставляем число не тронутым.

Выводим новый массив с факториалами.

### 5. Программа

```Java
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
            System.out.print(arr[i] + " ");
         }
      }

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

      System.out.print("\nМассив с числами, заменёнными на факториалы: ");
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
   }
}
```
### 6. Анализ правильности решения

Программа работает корректно при всех допустимых значениях.

1. Тест на числах, факториал которых не превышает $`2^{31} - 1`$:
    - Input:

   ```
   5
   1 5 4 2 3
   ```

    - Output:

   ```
   Новый массив: 1 4 5 3 2
   Количество чисел, являющихся кубами: 1
   Массив с извлеченными квадратами: 1 2 5 3 2
   Массив с числами, заменёнными на факториалы: 1 24 120 6 2
   ```

2. Тест на отсортированном массиве:
    - Input:

   ```
   5
   1 2 3 4 5
   ```

    - Output:

   ```
   Новый массив: 1 4 5 3 2
   Количество чисел, являющихся кубами: 1
   Массив с извлеченными квадратами: 1 2 5 3 2
   Массив с числами, заменёнными на факториалы: 1 24 120 6 2
   ```

3. Тест на массиве содержащем числа меньше или равные нулю:
    - Input:

   ```
   7
   2 -5 4 -1 0 6 1
   ```

    - Output:

   ```
   Новый массив: 0 1 4 6 2 -1 -5
   Количество чисел, являющихся кубами: 3
   Массив с извлеченными квадратами: 0 1 2 6 2 -1 -5
   Массив с числами, заменёнными на факториалы: 1 1 24 720 2 -1 -5
   ```

4. Тест на числах, факториал которых превышает $`2^{31} - 1`$:
    - Input:

   ```
   5
   9 4 27 16 20
   ```

    - Output:

   ```
   Новый массив: 4 9 16 27 20
   Количество чисел, являющихся кубами: 1
   Массив с извлеченными квадратами: 2 3 4 27 20
   Факториал 3 числа слишком большой для хранения.
   Факториал 4 числа слишком большой для хранения.
   Факториал 5 числа слишком большой для хранения.
   Массив с числами, заменёнными на факториалы: 24 362880 16 27 20
   ```

5. Тест на всех квадратах:
    - Input:

   ```
   5
   0 1 4 1 9
   ```

    - Output:

   ```
   Новый массив: 0 1 1 4 9
   Количество чисел, являющихся кубами: 3
   Массив с извлеченными квадратами: 0 1 1 2 3
   Массив с числами, заменёнными на факториалы: 1 1 1 24 362880
   ```

6. Тест на всех кубах:
    - Input:

   ```
   5
   0 1 27 1 8
   ```

    - Output:

   ```
   Новый массив: 0 1 1 27 8
   Количество чисел, являющихся кубами: 5
   Массив с извлеченными квадратами: 0 1 1 27 8
   Факториал 4 числа слишком большой для хранения
   Массив с числами, заменёнными на факториалы: 1 1 1 27 40320
   ```

7. Тест на числах, не являющихся квадратами и кубами:
   - Input:

   ```
   5
   2 7 5 11 10
   ```

   - Output:

   ```
   Новый массив: 11 10 7 5 2
   Количество чисел, являющихся кубами: 0
   Массив с извлеченными квадратами: 11 10 7 5 2
   Массив с числами, заменёнными на факториалы: 39916800 3628800 5040 120 2
   ```