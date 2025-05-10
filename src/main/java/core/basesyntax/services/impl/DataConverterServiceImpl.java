package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.DataConverterService;
import java.util.ArrayList;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    private static final int FRUIT_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final int DATA_INDEX = 1;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> parsedLines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = DATA_INDEX; i < parsedLines.size(); i++) {
            String[] fruitInfo = parsedLines.get(i).split(",");
            String fruitOperation = fruitInfo[FRUIT_OPERATION_INDEX].trim();
            String fruitName = fruitInfo[FRUIT_NAME_INDEX];
            int fruitQuantity = Integer.parseInt(fruitInfo[FRUIT_QUANTITY_INDEX]);
            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .getOperationByValue(fruitOperation);
            fruitTransactions.add(new FruitTransaction(operation, fruitName, fruitQuantity));
        }
        return fruitTransactions;
    }
}
