package core.basesyntax.service.impl;

import static core.basesyntax.model.FruitTransaction.greatOperationPattern;

import core.basesyntax.service.DataValidatorService;
import java.util.List;
import java.util.regex.Pattern;

public class DataValidatorServiceImpl implements DataValidatorService {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern OPERATION_PATTERN = greatOperationPattern();
    private static final String SEPARATOR = ",";
    private static final int INDEX_SEPARATOR = 0;
    private static final int INDEX_FOR_OPERATION_IN_STRING = 0;
    private static final int INDEX_FOR_PRODUCT_NAME_IN_STRING = 1;
    private static final int INDEX_FOR_PRODUCT_VALUE_IN_STRING = 2;
    private static final int CORRECT_NUMBERS_OF_COMMAS = 2;
    private static final int INDEX_CORRECT_FOR_LINE_IN_WHICH_ERROR = 2;
    private static final int HEADER_INDEX = 0;

    @Override
    public boolean isDataValid(List<String> data) {
        data.remove(HEADER_INDEX);
        if (data.isEmpty()) {
            throw new RuntimeException("Data from input file empty");
        }
        for (int i = 0; i < data.size(); i++) {
            String[] isLineLengthCorrect = data.get(i)
                    .split(SEPARATOR);
            char[] searchCountComma = data.get(i).toCharArray();
            int countCommaInLine = 0;
            for (char current : searchCountComma) {
                if (current == SEPARATOR.charAt(INDEX_SEPARATOR)) {
                    countCommaInLine++;
                }
            }
            if (countCommaInLine != CORRECT_NUMBERS_OF_COMMAS) {
                throw new RuntimeException("Data from input file not correct. "
                        + "String format not equal three groups, separated by a comma in line "
                        + (i + INDEX_CORRECT_FOR_LINE_IN_WHICH_ERROR));
            }
            if (!OPERATION_PATTERN.matcher(isLineLengthCorrect[INDEX_FOR_OPERATION_IN_STRING])
                    .matches()) {
                throw new RuntimeException("Data from input file not correct. "
                        + "Unknown operation in line "
                        + (i + INDEX_CORRECT_FOR_LINE_IN_WHICH_ERROR));
            }
            if (isLineLengthCorrect[INDEX_FOR_PRODUCT_NAME_IN_STRING].isEmpty()) {
                throw new RuntimeException("Data from input file not correct. "
                        + "The product name is empty in line "
                        + (i + INDEX_CORRECT_FOR_LINE_IN_WHICH_ERROR));
            }
            if (!INTEGER_PATTERN.matcher(isLineLengthCorrect[INDEX_FOR_PRODUCT_VALUE_IN_STRING])
                    .matches()) {
                throw new RuntimeException("Data from input file not correct. "
                        + "The third group is not a number in line "
                        + (i + INDEX_CORRECT_FOR_LINE_IN_WHICH_ERROR));
            }
        }
        return true;
    }
}
