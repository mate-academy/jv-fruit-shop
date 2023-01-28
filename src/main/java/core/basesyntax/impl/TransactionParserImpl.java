package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    public static final String REGEX = ",";

    @Override
    public List<FruitTransaction> parse(List<String> transaction) {
        List<FruitTransaction> parsedTransactions = new ArrayList<>();
        for (String elements : transaction) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] split = elements.split(REGEX);
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getByCode(split[OPERATION_INDEX]));
            fruitTransaction.setFruit(split[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(split[QUANTITY_INDEX]));
            parsedTransactions.add(fruitTransaction);
        }
        return parsedTransactions;
    }
}
