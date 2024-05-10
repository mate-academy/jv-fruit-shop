package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertorService;
import java.util.ArrayList;
import java.util.List;

public class ConvertorServiceImpl implements ConvertorService {
    private static final int FRUIT_STRATEGY_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int FRUIT_AMOUNT_POSITION = 2;

    @Override
    public List<FruitTransaction> convertData(List<String> inputList) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < inputList.size(); i++) {
            String[] splitInputList = inputList.get(i).split(",");
            FruitTransaction.Operation operation = getfruitOperation(splitInputList);
            String fruitName = splitInputList[FRUIT_NAME_POSITION];
            int amountFruit = Integer.parseInt(splitInputList[FRUIT_AMOUNT_POSITION]);
            fruitTransactionList.add(new FruitTransaction(operation, fruitName, amountFruit));
        }
        return fruitTransactionList;
    }

    private FruitTransaction.Operation getfruitOperation(String[] splitInputList) {
        FruitTransaction.Operation operation = null;
        for (FruitTransaction.Operation element : FruitTransaction.Operation.values()) {
            if (splitInputList[FRUIT_STRATEGY_POSITION].equals(element.getCode())) {
                operation = element;
            }
        }
        return operation;
    }
}
