package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.DataConverterService;

import java.util.ArrayList;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int REPORT_START_POSITION = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> fruitInfoList) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = REPORT_START_POSITION; i < fruitInfoList.size(); i++) {
            String[] fruitInfo = fruitInfoList.get(i).split(CSV_SEPARATOR);
            String fruitName = fruitInfo[FRUIT_NAME_INDEX];
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.getOperationByValue(fruitInfo[OPERATION_INDEX]);
            int fruitQuantity = Integer.parseInt(fruitInfo[QUANTITY_INDEX]);
            fruitTransactions.add(new FruitTransaction(operation, fruitName, fruitQuantity));
        }
        return fruitTransactions;
    }
}
