import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // Строка с алфавитом, используемая для генерации случайных символов
    static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    // Создаём объект Scanner для ввода с консоли
    static final Scanner scanner = new Scanner(System.in);

    // Функция для поиска палиндромов в двумерном массиве текста
    public static ArrayList<StringBuilder> get_palindromes(StringBuilder[][] text) {
        // Список для хранения найденных палиндромов
        ArrayList<StringBuilder> palindromes = new ArrayList<>();

        // Перебор всех строк в двумерном массиве
        for (StringBuilder[] strings : text) {
            // Перебор каждого слова в строках
            for (StringBuilder string : strings) {
                // Проверяем, является ли слово палиндромом
                String original = string.toString();  // Сохраняем оригинальную строку
                String reversed = string.reverse().toString();  // Переворачиваем строку и сохраняем её

                // Если слово и его перевёрнутая версия совпадают, оно палиндром
                if (original.equals(reversed)) {
                    palindromes.add(string);  // Добавляем слово в список палиндромов
                }
            }
        }
        return palindromes;  // Возвращаем список найденных палиндромов
    }

    // Функция для вывода текста на экран
    public static void print_text(StringBuilder[][] text) {
        System.out.println("Текст: ");
        // Перебор строк двумерного массива
        for (StringBuilder[] strings : text) {
            // Перебор слов в каждой строке
            for (StringBuilder string : strings) {
                System.out.print(string + " ");  // Выводим каждое слово на экран
            }
            System.out.println();  // Переход на новую строку после вывода всех слов в строке
        }
    }

    // Функция для генерации текста со случайными словами
    public static StringBuilder[][] generate_text(int size_word, int count_lines, int size_line) {
        Random random = new Random();  // Создаём объект Random для генерации случайных чисел
        StringBuilder[][] text = new StringBuilder[count_lines][size_line];  // Двумерный массив для хранения текста

        // Генерация текста
        for (int i = 0; i < count_lines; i++) {  // Перебор строк
            for (int j = 0; j < size_line; j++) {  // Перебор слов в строках
                StringBuilder word = new StringBuilder();
                // Генерация случайных слов
                for (int h = 0; h < size_word; h++) {
                    int randomNumber = random.nextInt(ALPHABET.length());  // Случайный индекс из алфавита
                    char randomChar = ALPHABET.charAt(randomNumber);  // Получаем случайный символ
                    word.append(randomChar);  // Добавляем символ к слову
                }
                text[i][j] = word;  // Записываем слово в массив
            }
        }

        return text;  // Возвращаем двумерный массив с текстом
    }

    // Функция для ввода данных с проверкой с использованием try-catch
    public static int getPositiveIntFromUser(String prompt) {
        int number = -1;
        boolean validInput = false;

        // Повторяем ввод до тех пор, пока пользователь не введёт корректное число
        while (!validInput) {
            System.out.print(prompt);  // Выводим подсказку пользователю
            try {
                number = Integer.parseInt(scanner.nextLine());  // Попытка считать число
                if (number <= 0) {
                    System.out.println("Число должно быть положительным.");  // Если число не положительное, выводим ошибку
                } else {
                    validInput = true;  // Ввод корректен
                }
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");  // Если ошибка формата числа, выводим сообщение
            }
        }
        return number;  // Возвращаем корректное число
    }

    // Основной метод
    public static void main(String[] args) {
        // Ввод данных с проверкой
        int size_word = getPositiveIntFromUser("Введите размер слова: ");
        int count_lines = getPositiveIntFromUser("Введите количество строк: ");
        int size_line = getPositiveIntFromUser("Введите количество слов в строке: ");

        // Генерация текста с введёнными данными
        StringBuilder[][] text = generate_text(size_word, count_lines, size_line);
        // Вывод текста
        print_text(text);
        // Поиск палиндромов в тексте
        ArrayList<StringBuilder> palindromes = get_palindromes(text);
        // Вывод найденных палиндромов
        System.out.println("Палиндромы: " + palindromes);

        scanner.close();  // Закрытие scanner после завершения работы с ним
    }
}
