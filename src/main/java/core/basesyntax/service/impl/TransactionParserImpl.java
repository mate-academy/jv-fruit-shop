package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int FIRST_LINE_INDEX = 0;

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        if (!data.isEmpty()) {
            data.remove(0);
        }
        for (String lines: data) {
            String[] fields = lines.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.getByCode(fields[OPERATION_INDEX]));
            fruitTransaction.setFruit(fields[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
