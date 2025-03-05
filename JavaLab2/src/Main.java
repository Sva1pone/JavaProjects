import java.util.Scanner;

public class Main {
    // Константа для ключа шифрования
    static final String KEY = "секрет";

    // Алфавит, который используется для шифрования и дешифрования
    static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя,!?.:;'\" ";

    // Создаём объект Scanner для ввода с консоли
    static final Scanner scanner = new Scanner(System.in);

    // Переменная для хранения сдвига для циклического сдвига
    static int shift = 0;

    /**
     * XOR-шифрование – это метод симметричного шифрования, при котором каждый символ исходного текста
     * складывается по модулю 2 (операция XOR) с соответствующим символом ключа. Если ключ короче текста,
     * он повторяется циклически. Этот метод обеспечивает простое и обратимое преобразование текста.
     * @param text исходный или зашифрованный текст
     * @return результат шифрования или дешифрования
     */
    public static String xor_cipher(String text) {
        StringBuilder result = new StringBuilder();
        // Проходим по каждому символу текста
        for (int i = 0; i < text.length(); i++) {
            // Находим индекс текущего символа в алфавите
            int num_text_char = ALPHABET.indexOf(text.charAt(i));
            // Находим индекс соответствующего символа ключа
            int num_key_char = ALPHABET.indexOf(KEY.charAt(i % KEY.length()));
            // Применяем операцию XOR
            int encrypted_char = num_text_char ^ num_key_char;

            // Проверяем, есть ли символ в алфавите
            if (num_text_char != -1 && num_key_char != -1 && encrypted_char <= ALPHABET.length()) {
                // Добавляем зашифрованный символ, если оба символа есть в алфавите
                result.append(ALPHABET.charAt(encrypted_char));
            } else {
                // Если символа нет в алфавите, добавляем оригинальный символ
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * Выполняет циклический сдвиг символов в тексте.
     * Сдвиг производится внутри ограниченного алфавита с использованием модульной арифметики,
     * что позволяет корректно обрабатывать границы массива символов.
     * @param text Исходный текст
     * @param encode Если true, выполняется шифрование (сдвиг вперёд), иначе – дешифрование (сдвиг назад)
     * @return Преобразованный текст
     */
    public static String cyclic_shift(String text, boolean encode) {
        StringBuilder result = new StringBuilder();
        // Проходим по каждому символу текста
        for (int i = 0; i < text.length(); i++) {
            // Получаем индекс символа в алфавите
            int index_alfabet = ALPHABET.indexOf(text.charAt(i));
            // Если символ есть в алфавите
            if (index_alfabet != -1) {
                // Сдвигаем индекс на нужное количество позиций
                int position_shift = encode ? (index_alfabet + shift) : (index_alfabet - shift);
                // Применяем модуль для правильной обработки границ алфавита
                position_shift = (position_shift + ALPHABET.length()) % ALPHABET.length();
                // Добавляем результат сдвига в строку
                result.append(ALPHABET.charAt(position_shift));
            } else {
                // Если символа нет в алфавите, добавляем оригинальный символ
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    // Обработка команды шифрования XOR
    public static void command1() {
        System.out.println("Введите текст:");
        String original_text = scanner.nextLine();
        // Приводим текст к нижнему регистру перед шифрованием
        String encrypted_text = xor_cipher(original_text.toLowerCase());
        System.out.println("Зашифрованный текст: " + encrypted_text);
        // Расшифровываем текст, используя ту же функцию
        System.out.println("Расшифрованный текст: " + xor_cipher(encrypted_text) + '\n');
    }

    // Обработка команды шифрования циклическим сдвигом
    public static void command2() {
        System.out.println("Введите текст:");
        String original_text = scanner.nextLine();
        // Приводим текст к нижнему регистру перед шифрованием
        String encrypted_text = cyclic_shift(original_text.toLowerCase(), true);
        System.out.println("Зашифрованный текст: " + encrypted_text);
        // Расшифровываем текст с помощью циклического сдвига в другую сторону
        System.out.println("Расшифрованный текст: " + cyclic_shift(encrypted_text, false) + '\n');
    }

    // Установка нового значения сдвига
    public static void command3() {
        System.out.println("Введите число позиций для сдвига:");
        // Сохраняем старое значение сдвига для отображения
        int old_shift = shift;
        // Читаем новое значение сдвига
        try {
            shift = Integer.parseInt(scanner.nextLine()); // Пытаемся преобразовать строку в число
            System.out.printf("Число позиций для сдвига изменилось с %d на %d\n\n", old_shift, shift);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Вы ввели не число...");
        }
    }

    // Вывод меню с текущим значением сдвига
    public static void print_menu() {
        System.out.printf("""
1 - Шифрование с помощью операции XOR
2 - Шифрование с помощью циклического сдвига (Текущий сдвиг - %d)
3 - Ввести число позиций для шифрования путем циклического сдвига
Q - Выход из программы
""", shift); // Отображаем меню с текущим значением сдвига
    }

    // Главный цикл программы
    public static void main(String[] args) {
        String command;
        do {
            // Печатаем меню и ждем команду
            print_menu();
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    command1(); // Обрабатываем команду 1
                    break;
                case "2":
                    command2(); // Обрабатываем команду 2
                    break;
                case "3":
                    command3(); // Обрабатываем команду 3
                    break;
                case "Q":
                    break; // Выход из программы
                default:
                    System.out.println("Команда не распознана!\n"); // Обработка неверных команд
            }
        } while (!"Q".equals(command)); // Повторяем цикл до команды "Q"
        scanner.close(); // Закрываем scanner
    }
}
