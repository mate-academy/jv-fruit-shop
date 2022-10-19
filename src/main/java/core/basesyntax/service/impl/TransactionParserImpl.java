package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationValidator;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int COUNT = 2;
    private static final OperationValidator validator = new OperationValidatorImpl();

    @Override
    public List<FruitTransaction> transactionParser(List<String> list) {
        String [] parsedData;
        Fruit fruit = new Fruit("");
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            parsedData = list.get(i).split(",");
            fruit.setName(parsedData[FRUIT_NAME]);
            transactions.add(new FruitTransaction(
                    validator.valid(parsedData[OPERATION_TYPE]),
                    new Fruit(parsedData[FRUIT_NAME]), Integer.parseInt(parsedData[COUNT])));
        }
        return transactions;
    }
}
