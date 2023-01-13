package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_FIELD_INDEX = 0;
    private static final int FRUIT_FIELD_INDEX = 1;
    private static final int QUANTITY_FIELD_INDEX = 2;
    private static final int FIRST_VALUE_LINE_INDEX = 1;

    @Override
    public List<FruitTransaction> toTransactions(String data) {
        List<FruitTransaction> list = new ArrayList<>();
        String[] lines = data.split(System.lineSeparator());
        for (int i = FIRST_VALUE_LINE_INDEX; i < lines.length; i++) {
            String[] fields = lines[i].split(",");
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromString(fields[OPERATION_FIELD_INDEX]);
            String fruit = fields[FRUIT_FIELD_INDEX];
            int quantity = Integer.parseInt(fields[QUANTITY_FIELD_INDEX]);
            FruitTransaction fruitTransaction =
                    new FruitTransaction(operation, fruit, quantity);
            list.add(fruitTransaction);
        }
        return list;
    }
}
