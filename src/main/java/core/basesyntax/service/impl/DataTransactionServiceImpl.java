package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataTransactionService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTransactionServiceImpl implements DataTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> turnDataToTransactions(String data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] lines = data.split(System.lineSeparator());
        Arrays.stream(lines)
                .skip(1)
                .map(this::splitLines)
                .forEach(transactions::add);
        return transactions;
    }

    private FruitTransaction splitLines(String line) {
        String[] splitLine = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperation(splitLine[OPERATION_INDEX]));
        fruitTransaction.setFruit(splitLine[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(splitLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
