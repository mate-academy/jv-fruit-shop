package core.basesyntax.validation;

import java.util.List;

public class Validator {
    private static final int FRUIT_AMOUNT_POSITION = 2;

    public static boolean validate(List<String> lines) {
        for (String line : lines) {
            String[] values = line.split(",");
            if (Integer.parseInt(values[FRUIT_AMOUNT_POSITION]) < 0) {
                return false;
            }
        }
        return true;
    }
}
