package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int LINE_LENGTH = 3;
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public Transaction parseLine(String line) {
        String[] lineSplitted = line.split(COMMA_SEPARATOR);
        if (validate(lineSplitted)) {
            Operation operation = Operation.valueOf(lineSplitted[OPERATION_INDEX]);
            Fruit fruit = new Fruit();
            fruit.setName(lineSplitted[FRUIT_INDEX]);
            int quantity = Integer.parseInt(lineSplitted[QUANTITY_INDEX]);
            return new Transaction(operation, fruit, quantity);
        }
        throw new RuntimeException("Wrong input data! " + line);
    }

    private boolean validate(String[] lineSplitted) {
        return lineSplitted.length == LINE_LENGTH
                && Integer.parseInt(lineSplitted[QUANTITY_INDEX]) > 0;
    }
}
