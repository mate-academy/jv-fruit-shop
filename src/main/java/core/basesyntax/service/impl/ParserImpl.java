package core.basesyntax.service.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;

public class ParserImpl implements Parser {
    private static final String LINE_SPLIT_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public Transaction parseLine(String line) {
        if (validator.isValid(line)) {
            String[] data = line.split(LINE_SPLIT_SEPARATOR);
            return new Transaction(data[OPERATION_INDEX],
                    data[FRUIT_NAME_INDEX],
                    Integer.parseInt(data[QUANTITY_INDEX]));
        }
        throw new RuntimeException("Line is invalid! " + line);
    }
}
