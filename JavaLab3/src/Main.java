import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static ArrayList<StringBuilder> get_palindromes(StringBuilder[][] text) {
        ArrayList<StringBuilder> palindromes = new ArrayList<>();
        for (StringBuilder[] strings : text) {
            for (StringBuilder string : strings) {
//                System.out.println(string + " " + string.reverse());

                if (string.toString().contentEquals(string.reverse())){
                    palindromes.add(string);
                }
            }
        }
        return palindromes;
    }

    public static void print_text(StringBuilder[][] text) {
        System.out.print("Текст: \n");
        for (StringBuilder[] strings : text) {
            for (StringBuilder string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static StringBuilder[][] generate_text(int size_word, int count_lines, int size_line) {
        Random random = new Random();
        StringBuilder[][] text = new StringBuilder[count_lines][size_line];


        for (int  i= 0; i < count_lines; i++) {
            for (int j = 0; j < size_line; j++) {
                StringBuilder word = new StringBuilder();
                for (int h = 0; h < size_word; h++) {
                    int randomNumber = random.nextInt(ALPHABET.length());
                    char randomChar = ALPHABET.charAt(randomNumber);
                    word.append(randomChar);
                }
                text[i][j] = word;
            }
        }

        System.out.println(Arrays.deepToString(text));

        return text;
    }

    public static void main(String[] args) {
        StringBuilder[][] text = generate_text(3, 100, 100);
        print_text(text);
        ArrayList<StringBuilder> palindromes = get_palindromes(text);
        System.out.println("Палиндромы: " + palindromes);
    }
}