package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    private FruitTransaction processLine(String data) {
        if (!data.contains(COMMA)) {
            throw new RuntimeException("Can't process data: " + data);
        }

        String[] splitData = data.split(COMMA);
        Operation operation = Operation.fromCode(splitData[OPERATION_INDEX]);
        String fruitName = splitData[FRUIT_NAME_INDEX];
        int quantity = Integer.parseInt(splitData[FRUIT_QUANTITY_INDEX]);

        if (quantity < 0) {
            throw new NumberFormatException("Quantity can't be less than 0, but was: " + quantity);
        }

        return new FruitTransaction(operation, fruitName, quantity);
    }

    @Override
    public List<FruitTransaction> processAll(List<String> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (String line : data) {
            if (!line.equals("type,fruitName,quantity")) {
                fruitTransactionList.add(processLine(line));
            }
        }

        return fruitTransactionList;
    }
}
