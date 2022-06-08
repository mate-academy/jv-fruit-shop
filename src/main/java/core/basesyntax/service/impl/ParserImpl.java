package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Parser;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int CORRECT_DATA_LENGTH = 3;
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public Transaction parseLine(String line) {
        String[] splittedData = line.split(COMMA_SEPARATOR);
        if (validate(splittedData)) {
            Operation operation = Operation.valueOf(splittedData[OPERATION_INDEX].toUpperCase());
            Fruit fruit = new Fruit(splittedData[FRUIT_INDEX]);
            int quantity = Integer.parseInt(splittedData[QUANTITY_INDEX]);
            return new Transaction(operation, fruit, quantity);
        }
        throw new RuntimeException("Wrong input data! " + line);
    }

    private boolean validate(String[] splittedData) {
        return splittedData.length == CORRECT_DATA_LENGTH
                && Integer.parseInt(splittedData[QUANTITY_INDEX]) > 0;
    }
}
