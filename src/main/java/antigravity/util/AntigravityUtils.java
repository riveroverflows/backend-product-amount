package antigravity.util;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class AntigravityUtils {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static List<Integer> arrayToList(int[] ids) {
        return Arrays.stream(ids).boxed().toList();
    }
}
