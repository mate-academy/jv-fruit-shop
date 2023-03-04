package core.basesyntax.service.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.validator.Validator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final Validator validator;

    public TransactionServiceImpl() {
        this.validator = new Validator();
    }

    @Override
    public List<FruitTransaction> createListTransaction(List<String> dataFromFile) {
        if (dataFromFile == null || dataFromFile.isEmpty()) {
            throw new IllegalArgumentException("Data from input file can`t be empty");
        }

        return dataFromFile.subList(1, dataFromFile.size())
                .stream()
                .map(this::createTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransaction(String data) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] line = data.split(SEPARATOR);
        String operation = line[OPERATION_INDEX].replaceAll("\\W", "");
        String fruit = line[FRUIT_INDEX].replaceAll("\\W", "");
        String quantity = line[QUANTITY_INDEX].replaceAll("\\D", "");
        validator.checkTransaction(operation, fruit, quantity);
        fruitTransaction.setOperation(FruitTransaction.Operation.getOperationLetter(operation));
        fruitTransaction.setFruit(fruit);
        fruitTransaction.setQuantity(Integer.parseInt(quantity));
        return fruitTransaction;
    }
}
