package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parse(List<String> dataArray) {
        List<FruitTransaction> transactions = new ArrayList<>();
        if (dataArray == null || dataArray.isEmpty()) {
            throw new RuntimeException("Impossible to parse data! "
            + "Data array is empty!");
        }
        for (String data : dataArray) {
            final FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(data.split(",")[OPERATION_INDEX]);
            transaction.setFruit(data.split(",")[FRUIT_INDEX]);
            transaction.setQuantity(Integer.parseInt(data.split(",")[QUANTITY_INDEX]));
            transactions.add(transaction);
        }
        return transactions;
    }
}
