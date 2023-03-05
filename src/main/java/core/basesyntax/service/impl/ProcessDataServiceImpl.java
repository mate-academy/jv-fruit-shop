package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessDataServiceImpl implements ProcessData {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int COLUMN_NAMES_INDEX = 0;

    @Override
    public List<FruitTransaction> create(List<String> list) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        list.remove(COLUMN_NAMES_INDEX);
        for (String transaction : list) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] line = transaction.split(",");
            String operator = line[OPERATION_TYPE_INDEX].trim();
            fruitTransaction.setOperation(getOperation(operator));
            fruitTransaction.setFruit(line[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(line[QUANTITY_INDEX]));
            transactionList.add(fruitTransaction);
        }
        return transactionList;
    }

    private FruitTransaction.Operation getOperation(String operator) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(s -> s.getCode().equals(operator))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("wrong operator index"));
    }
}
