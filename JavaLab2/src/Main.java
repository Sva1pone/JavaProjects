//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


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
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        menu();

    }
}