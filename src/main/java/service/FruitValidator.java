package service;

import java.util.Arrays;

public class FruitValidator implements Validator {
    private static final int OPERATOR_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static int EXPECTED_ARRAY_LENGTH = 3;

    @Override
    public boolean validate(String[] lineParse) {
        return lineParse.length == EXPECTED_ARRAY_LENGTH
                && Arrays.asList(Operations.values())
                .contains(Operations.valueOf(lineParse[OPERATOR_INDEX]))
                && !lineParse[NAME_INDEX].equals("")
                && Integer.parseInt(lineParse[QUANTITY_INDEX]) > 0;
    }
}
