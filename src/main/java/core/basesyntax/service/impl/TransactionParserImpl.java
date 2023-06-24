package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationValidation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int COUNT_INDEX = 2;
    private static final String SEPARATOR = ",";
    private final OperationValidation validator;

    public TransactionParserImpl(OperationValidation operationValidation) {
        this.validator = operationValidation;
    }

    @Override
    public List<FruitTransaction> parseTransaction(List<String> list) {
        String[] parsedValue;
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            parsedValue = list.get(i).split(SEPARATOR);
            transactions.add(new FruitTransaction(validator.validate(parsedValue[OPERATION_INDEX]),
                    new Fruit(parsedValue[FRUIT_NAME_INDEX]),
                    Integer.parseInt(parsedValue[COUNT_INDEX])));
        }
        return transactions;
    }
}
