package service;

import java.util.List;
import java.util.regex.Pattern;

public class ValidateImpl implements Validate {
    private static final Pattern REGEX_FOR_DATA = Pattern.compile("[bprs],[a-z]*,[0-9]*");

    @Override
    public void validate(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("Empty input or null!");
        }
        for (int i = 1; i < list.size(); i++) {
            if (!REGEX_FOR_DATA.matcher(list.get(i)).matches()) {
                throw new RuntimeException("Invalid input!");
            }
        }
    }
}
