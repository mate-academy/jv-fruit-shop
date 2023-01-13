package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataTransactionService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTransactionServiceImpl implements DataTransactionService {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int AMOUNT = 2;

    @Override
    public List<FruitTransaction> getData(String data) {
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
                .getOperation(splitLine[OPERATION]));
        fruitTransaction.setFruit(splitLine[FRUIT_NAME]);
        fruitTransaction.setQuantity(Integer.parseInt(splitLine[AMOUNT]));
        return fruitTransaction;
    }
}
