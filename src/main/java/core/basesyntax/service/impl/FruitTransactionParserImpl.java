package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> transactions) {
        List<FruitTransaction> resultList = new ArrayList<>();
        for (String transaction: transactions) {
            String[] splitLine = transaction.split(",");
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.get(splitLine[OPERATION_INDEX]);
            String fruit = splitLine[FRUIT_INDEX];
            int quantity = Integer.parseInt(splitLine[QUANTITY_INDEX]);
            resultList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return resultList;
    }
}
