package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    public static final String SEPARATOR = ",";
    public static final int REPORT_START_POSITION_INDEX = 1;
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_NAME_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> fruitInfoList) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = REPORT_START_POSITION_INDEX; i < fruitInfoList.size(); i++) {
            String[] fruitInfo = fruitInfoList.get(i).split(SEPARATOR);
            String fruitName = fruitInfo[FRUIT_NAME_INDEX];
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.getOperationByValue(fruitInfo[OPERATION_INDEX]);
            int fruitQuantity = Integer.parseInt(fruitInfo[QUANTITY_INDEX]);
            fruitTransactions.add(new FruitTransaction(operation, fruitName, fruitQuantity));
        }
        return fruitTransactions;
    }
}
