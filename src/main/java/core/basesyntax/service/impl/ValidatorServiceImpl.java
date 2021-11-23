package core.basesyntax.service.impl;

import core.basesyntax.service.ValidatorService;
import java.util.List;

public class ValidatorServiceImpl implements ValidatorService {
    private static final String FIRST_LINE_OF_INPUT_FILE = "type,fruit,quantity";
    private static final String PATTERN_OF_FIRST_ELEMENT = "[bpsr]";
    private static final String PATTERN_OF_FRUIT_NAME = "[A-Za-z]{3,12}";
    private static final String COMMA = ",";
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public boolean isValid(List<String> text) {
        if (text.isEmpty() || !text.get(0).matches(FIRST_LINE_OF_INPUT_FILE)) {
            throw new RuntimeException("This data is incorrect!");
        }
        for (int i = 1; i < text.size(); i++) {
            String[] arrayLine = text.get(i).split(COMMA);
            if (!(arrayLine[INDEX_OF_TYPE].matches(PATTERN_OF_FIRST_ELEMENT))
                    || !(arrayLine[INDEX_OF_FRUIT_NAME].matches(PATTERN_OF_FRUIT_NAME))
                    || (Integer.parseInt(arrayLine[INDEX_OF_QUANTITY]) < 0)) {
                throw new RuntimeException("Data format is incorrect!");
            }
        }
        return true;
    }
}
