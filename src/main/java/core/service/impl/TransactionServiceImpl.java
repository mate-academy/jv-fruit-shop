package core.service.impl;

import core.db.FruitTransaction;
import core.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> createFromList(List<String> line) {
        line.remove(0);
        return line.stream()
                .map(this::createFromString)
                .collect(Collectors.toList());
    }

    private FruitTransaction createFromString(String line) {
        String[] splitLine = line.split(",");
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .getOperationByLetter(splitLine[OPERATION_INDEX]);
        int quantity = Integer.parseInt(splitLine[QUANTITY_INDEX]);
        return new FruitTransaction(operation, splitLine[FRUIT_INDEX], quantity);
    }
}
