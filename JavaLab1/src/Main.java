public class Main {
    public static void print_menu() {
        String text = """
1 - Шифрование с помощью операции XOR
2 - Шифрование с помощью  циклического сдвига
Q - Выход из программы
""";
        System.out.print(text);
    }

    public static String get_command() {
        String command = System.in.read();
        return command;
    }

    public static void main(String[] args) {
        System.out.print("Hello word!");
        print_menu();
        get_command();
    }
}