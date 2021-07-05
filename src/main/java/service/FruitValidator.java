package service;

import java.util.Arrays;

public class FruitValidator implements Validator {
    private static final int OPERATOR_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int EXPECTED_ARRAY_LENGTH = 3;
    private static final String[] operations = new String[]{"b", "s", "p", "r"};

    @Override
    public boolean validate(String[] lineParse) {
        return lineParse.length == EXPECTED_ARRAY_LENGTH
                && Arrays.asList(operations).contains(lineParse[OPERATOR_INDEX])
                && lineParse[NAME_INDEX].length() > 0
                && Integer.parseInt(lineParse[QUANTITY_INDEX]) > 0;
    }
}
