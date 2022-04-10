package core.basesyntax.validation;

import java.util.List;

public class Validator {
    private static final int FRUIT_AMOUNT_POSITION = 2;
    private static final int VALUES_IN_LINE = 3;

    public static boolean validate(List<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            if (values.length == VALUES_IN_LINE
                    && Integer.parseInt(values[FRUIT_AMOUNT_POSITION]) < 0) {
                return false;
            }
        }
        return true;
    }
}
