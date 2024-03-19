package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operations;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int REQUIRED_DATA_PARTS = 3;
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int ENTITY_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> records) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (var record : records) {
            String[] splitData = record.split(DATA_SEPARATOR);
            if (splitData.length != REQUIRED_DATA_PARTS) {
                throw new RuntimeException("Can't parse data - " + record);
            }
            Operations operation = Operations.getOperationByCode(splitData[OPERATION_TYPE_INDEX]);
            String fruit = splitData[ENTITY_NAME_INDEX];
            int amount = Integer.parseInt(splitData[AMOUNT_INDEX]);
            fruitTransactions.add(new FruitTransaction(operation, fruit, amount));
        }
        return fruitTransactions;
    }
}
