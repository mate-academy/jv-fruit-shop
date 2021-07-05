package core.basesyntax.service;

import core.basesyntax.dto.Operations;
import core.basesyntax.dto.Transaction;
import core.basesyntax.fruit.Fruit;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int CORRECT_DATA_LENGTH = 3;
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public Transaction parseLine(String line) {
        Transaction transaction;
        String[] splittedData = line.split(COMMA_SEPARATOR);
        if (validate(splittedData)) {
            Operations operation = Operations.valueOf(splittedData[OPERATION_INDEX]);
            Fruit fruit = new Fruit(splittedData[FRUIT_INDEX]);
            int quantity = Integer.parseInt(splittedData[QUANTITY_INDEX]);
            transaction = new Transaction(operation, fruit, quantity);
            return transaction;
        }
        throw new RuntimeException("Wrong input data! " + line);
    }

    private boolean validate(String[] splittedData) {
        return splittedData.length == CORRECT_DATA_LENGTH
                && Integer.parseInt(splittedData[QUANTITY_INDEX]) > 0;
    }
}
