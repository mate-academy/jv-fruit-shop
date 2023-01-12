package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertStringToFruitTransaction(List<String> elementsInFile) {
        return elementsInFile.stream().map(this::getFruitFromCsvRow).collect(Collectors.toList());
    }

    private FruitTransaction getFruitFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        FruitTransaction.Operation operation = Arrays.stream(FruitTransaction.Operation.values())
                .filter(x -> x.getOperation().equals(fields[INDEX_OPERATION]))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find this operation"));
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[INDEX_FRUIT_NAME]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_QUANTITY]));
        return fruitTransaction;
    }
}
