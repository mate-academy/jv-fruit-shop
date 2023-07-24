package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.operations.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataInputParserImpl implements DataInputParser {
    private static final int INFO_LINE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int PARTS_LENGTH = 3;

    @Override
    public List<FruitTransaction> parseData(List<String> dataList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        dataList.remove(INFO_LINE_INDEX);

        for (String line : dataList) {
            String[] parts = line.split(",");
            if (parts.length == PARTS_LENGTH) {
                Operation operation = Operation.getOperationFromString(parts[OPERATION_INDEX]);
                String fruitName = parts[FRUIT_NAME_INDEX];
                int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
                if (operation != null) {
                    Fruit fruit = new Fruit(fruitName, quantity);
                    FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit);
                    fruitTransactionList.add(fruitTransaction);
                }
            }
        }
        return fruitTransactionList;
    }
}
