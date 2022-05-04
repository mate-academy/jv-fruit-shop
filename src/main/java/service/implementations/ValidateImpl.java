package service.implementations;

import java.util.List;
import java.util.regex.Pattern;
import service.inerfaces.Validate;

public class ValidateImpl implements Validate {
    public static final int INDEX_AFTER_FIRST_ROW = 1;
    private static final Pattern REGEX_FOR_DATA = Pattern.compile("[bprs],[a-z]*,[0-9]*");

    @Override
    public boolean validate(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("Empty input or null!");
        }
        for (int i = INDEX_AFTER_FIRST_ROW; i < list.size(); i++) {
            if (!REGEX_FOR_DATA.matcher(list.get(i)).matches()) {
                throw new RuntimeException("Invalid input!");
            }
        }
        return true;
    }
}
