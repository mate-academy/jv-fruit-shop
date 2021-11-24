package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;

public class ParserImpl implements Parser {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parseLine(String line) {
        validator.validateLine(line);
        String[] values = line.split(",");
        String operation = values[INDEX_OF_OPERATION];
        String fruitName = values[INDEX_OF_FRUIT_NAME].toLowerCase();
        int amount = Integer.parseInt(values[INDEX_OF_AMOUNT]);
        return new TransactionDto(operation, fruitName, amount);
    }
}
