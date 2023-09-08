package core.basesyntax.service.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {
    public static final String COMA_SEPARATOR = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> creatListTransaction(List<String> dataFromFile) {
        return dataFromFile
                .stream()
                .skip(1)
                .map(this::createTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransaction(String data) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] line = data.split(COMA_SEPARATOR);
        fruitTransaction.setOperation(fruitTransaction
                .getOperationLetter(line[OPERATION_INDEX].replaceAll("\\W", "")));
        fruitTransaction.setFruit(line[FRUIT_INDEX].replaceAll("\\W", ""));
        fruitTransaction
                .setQuantity(Integer.parseInt(line[QUANTITY_INDEX].replaceAll("\\D", "")));
        return fruitTransaction;
    }
}


