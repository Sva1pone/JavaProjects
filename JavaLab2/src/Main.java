
public class Main {
    public static final String KEY = "sekret"

    public static void encrypt_xor() {
        System.out.print('Введите текст для шифрования:');
        String original_text = System.in.read();
        String encrypted_text;
        String encrypted_char;
        String original_char;
        String key_char;

        int index = 0;
        for (int i = 0; i < original_text.length(); i++) {
            original_char = Integer.toBinaryString(original_text[i]);
            if (i >= KEY.length()) {
                index = 0
            }
            key_char = Integer.toBinaryString(original_text[i])
            encrypted_char = Integer.toBinaryString(original_text[i]);
            encrypted_text += encrypted_char;

            index++;
        }
    }


    public static void print_menu() {
        String text = """
1 - Шифрование с помощью операции XOR
2 - Шифрование с помощью  циклического сдвига
Q - Выход из программы
""";
        System.out.print(text);
    }

    public static void main(String[] args) {
        do {
            print_menu();
            String command = System.in.read();
            switch (command) {
                case '1':
                    null
                case '2':
                    null
                case 'Q':
                    break;
                default:
                    System.out.print('Команда не распознана!');
            }
        } while (command != 'Q')
    }
}