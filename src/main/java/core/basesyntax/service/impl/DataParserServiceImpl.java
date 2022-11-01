package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.ArrayList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private static final String REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitsToList(List<String> linesFromInputFile) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        for (int i = 1; i < linesFromInputFile.size(); i++) {
            String[] fruitTransactionAttributes = linesFromInputFile.get(i).split(REGEX);
            FruitTransaction.Operation operation = FruitTransaction.Operation.BALANCE;
            for (FruitTransaction.Operation operationType : FruitTransaction.Operation.values()) {
                if (operationType.getOperation()
                        .equals(fruitTransactionAttributes[OPERATION_INDEX])) {
                    operation = operationType;
                    break;
                }
            }
            String fruit = fruitTransactionAttributes[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(fruitTransactionAttributes[QUANTITY_INDEX]);
            fruitTransactionsList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactionsList;
    }
}
