package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.List;

public class ValidatorImpl implements Validator {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public boolean isValid(List<String> lines) {
        String[] splittedLine;
        for (String line : lines) {
            splittedLine = line.split(",");
            if (splittedLine.length != 3
                    || !splittedLine[OPERATION_INDEX].trim().matches("[brsp]")
                    || Integer.parseInt(splittedLine[QUANTITY_INDEX]) <= 0
                    || splittedLine[FRUIT_INDEX].isEmpty()) {
                throw new RuntimeException("Invalid input file.");
            }
        }
        return true;
    }
}
