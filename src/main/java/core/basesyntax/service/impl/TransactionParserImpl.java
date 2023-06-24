package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> transaction) {
        List<FruitTransaction> parsedTransactions = new ArrayList<>();
        for (String strings : transaction) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splittedData = strings.split(",");
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getByCode(splittedData[OPERATION_INDEX]));
            fruitTransaction.setFruit(splittedData[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splittedData[QUANTITY_INDEX]));
            parsedTransactions.add(fruitTransaction);
        }
        return parsedTransactions;
    }
}
