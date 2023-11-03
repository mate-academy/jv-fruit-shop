package core.basesyntax.service;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.FruitTransaction.Operation;
import java.util.ArrayList;
import java.util.List;

public class FruitMapperImpl implements FruitMapper {
    private static final String REGEX_COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEAD_LINE_INDEX = 0;

    @Override
    public List<FruitTransaction> mapData(List<String> lines) {
        lines.remove(HEAD_LINE_INDEX);
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(REGEX_COMMA);
            Operation operation = Operation.valueOf(data[OPERATION_INDEX]);
            String fruitType = data[FRUIT_TYPE_INDEX];
            int quantity = Integer.parseInt(data[QUANTITY_INDEX]);
            FruitTransaction fruitTransaction =
                    new FruitTransaction(operation, fruitType, quantity);
            fruitTransactionsList.add(fruitTransaction);
        }
        return fruitTransactionsList;
    }
}
