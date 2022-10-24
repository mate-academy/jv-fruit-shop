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
    private static final String SEPARATOR = ",";
    private final OperationValidator validator;

    public TransactionParserImpl(OperationValidator operationValidator) {
        this.validator = operationValidator;
    }

    @Override
    public List<FruitTransaction> parseTransactions(List<String> list) {
        String [] parsedData;
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            parsedData = list.get(i).split(SEPARATOR);
            transactions.add(new FruitTransaction(
                    validator.validate(parsedData[OPERATION_TYPE]),
                    new Fruit(parsedData[FRUIT_NAME]), Integer.parseInt(parsedData[COUNT])));
        }
        return transactions;
    }
}
