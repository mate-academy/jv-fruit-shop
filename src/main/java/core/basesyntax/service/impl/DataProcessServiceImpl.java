package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessService;
import java.util.ArrayList;
import java.util.List;

public class DataProcessServiceImpl implements DataProcessService {
    private static final int FIRST_LINE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final String LINE_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> processData(List<String> inputData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        inputData.remove(FIRST_LINE_INDEX);
        for (String line : inputData) {
            String[] data = line.split(LINE_SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(
                    FruitTransaction.Operation.getType(data[OPERATION_INDEX]));
            fruitTransaction.setFruitName(data[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
