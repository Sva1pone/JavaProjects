import java.util.Scanner;

public class Main {
    static final String KEY = "sekret";
    static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя?,. ";
    static final Scanner scanner = new Scanner(System.in);
    public static int shift = 0;

    public static String xor_cipher(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            result.append((char) (text.charAt(i) ^ KEY.charAt(i % KEY.length())));
        }

        return result.toString();
    }

    public static String cyclic_shift(String text, boolean encode) {
        StringBuilder result = new StringBuilder();
        int position_shift;
        int index_alfabet;

        for (int i = 0; i < text.length(); i++) {
            index_alfabet = ALPHABET.indexOf(text.charAt(i));
            position_shift = encode ? (index_alfabet + shift) : (index_alfabet - shift);
            position_shift = (position_shift + ALPHABET.length()) % ALPHABET.length();

            result.append(ALPHABET.charAt(position_shift));
        }



        return result.toString();
    }

    public static void command1() {
        System.out.println("Введите текст:");
        String original_text = scanner.nextLine();

        String encrypted_text = xor_cipher(original_text.toLowerCase());
        System.out.println("Зашифрованный текст: " + encrypted_text);

        String decrypted_text = xor_cipher(encrypted_text);
        System.out.println("Расшифрованный текст: " + decrypted_text + '\n');
    }

    public static void command2() {
        System.out.println("Введите текст:");
        String original_text = scanner.nextLine();

        String encrypted_text = cyclic_shift(original_text.toLowerCase(), true);
        System.out.println("Зашифрованный текст: " + encrypted_text);

        String decrypted_text = cyclic_shift(encrypted_text, false);
        System.out.println("Расшифрованный текст: " + decrypted_text + '\n');
    }

    public static void command3() {
        System.out.println("Введите число позиций для сдвига:");
        int old_shift = shift;
        shift = Integer.parseInt(scanner.nextLine());

        System.out.printf("Число позиций для сдвига изменилось с %d на %d\n\n", old_shift, shift);
    }

    public static void print_menu() {
        String text = """

1 - Шифрование с помощью операции XOR
2 - Шифрование с помощью  циклического сдвига (Текущий сдвиг - %d)
3 - Ввести число позиций для шифрования путем циклического сдвига
Q - Выход из программы

""";
        System.out.printf(text, shift);
    }

    public static void main(String[] args) {
        String command;
        do {
            print_menu();
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    command1();
                    break;
                case "2":
                    command2();
                    break;
                case "3":
                    command3();
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("Команда не распознана!\n");
            }
        } while (!"Q".equals(command));

        scanner.close();
    }
}



// Привет, мир!
// Что вершит судьбу человечества в этом мире?
// Эта строка включает все буквы русского алфавита.