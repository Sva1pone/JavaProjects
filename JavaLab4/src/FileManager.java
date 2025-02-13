import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class FileManager {
    String base_dir = "C:\\Users\\CurrentUser";
    String start_line = "PS " + base_dir + ">";
    String current_dir;

    public String get_current_directory() {
        return current_dir;
    }

    public boolean choice_directory(String new_dir) {
        if (new_dir.startsWith("C:\\") | new_dir.startsWith("C:/")){
            current_dir = new_dir;
            return true;
        } else {
            Pattern pattern = Pattern.compile("..(\\|/)");
            long count_jump = pattern.matcher(new_dir).results().count();

            ArrayList<String> dirs = new ArrayList<>(Arrays.asList(current_dir.split("(\\|/)")));
            for (int i = 0; i < count_jump; i++) {
                dirs.removeLast();
            }
            current_dir = String.join("\\", dirs) + "\\";
            new_dir = new_dir.replaceAll("..(\\|/)", "");
            new_dir = new_dir.replaceAll(".(\\|/)", "");
            new_dir = String.join("\\", new_dir.split("(\\|/)"));

            current_dir = current_dir + new_dir;

        }
    }


}
