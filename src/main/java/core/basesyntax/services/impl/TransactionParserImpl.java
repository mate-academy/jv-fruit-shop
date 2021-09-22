package core.basesyntax.services.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT = 1;
    public static final int QUALITY = 2;
    public static final String COMMA = ",";

    @Override
    public Transaction parse(String data) {
        String[] parseData = data.split(COMMA);
        return new Transaction(OperationHandler.findOperation(parseData[OPERATION_INDEX]),
                new Fruit(parseData[FRUIT]), Integer.parseInt(parseData[QUALITY]));
    }
}
