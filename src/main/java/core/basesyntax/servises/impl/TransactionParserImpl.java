package core.basesyntax.servises.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.servises.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SPLIT = ",";
    private static final int OPERAION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> interfaceTransactionParser(List<String> list) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (String line : list) {
            String[] elements = line.split(SPLIT);
            FruitTransaction.Operation operation = FruitTransaction
                        .getOperationByString(elements[OPERAION_INDEX]);
            fruits.add(new FruitTransaction(operation, elements[FRUIT_NAME_INDEX],
                        Integer.parseInt(elements[AMOUNT_INDEX])));
        }
        return fruits;
    }
}
