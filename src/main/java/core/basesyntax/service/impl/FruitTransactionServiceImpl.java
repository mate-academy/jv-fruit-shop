package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.FruitTransactionStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private FruitTransactionStrategy strategy;
    private Storage fruitsStorage;

    public FruitTransactionServiceImpl(FruitTransactionStrategy strategy, Storage fruitsStorage) {
        this.strategy = strategy;
        this.fruitsStorage = fruitsStorage;
    }

    public void getFruitTransactionFromString(String[] dataFromFile) {
        FruitTransaction transaction = new FruitTransaction();
        for (String string : dataFromFile) {
            String[] data = string.split(",");
            transaction.setFruit(data[FRUIT_NAME_INDEX]);
            transaction.setOperation((FruitTransaction.Operation.valueOf(FruitTransaction.Operation
                    .getOperationByString(data[OPERATION_INDEX]))));
            transaction.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
            setOperationHandler(transaction);
            addToStorage(transaction);
        }
    }

    public void setOperationHandler(FruitTransaction transaction) {
        if (fruitsStorage.getFruitsStorage().containsKey(transaction.getFruit())) {
            transaction.setQuantity(strategy.get(transaction.getOperation())
                    .processOperation(fruitsStorage.getFruitsStorage().get(transaction.getFruit()),
                            transaction.getQuantity()));
        } else {
            transaction.setQuantity(strategy.get(transaction.getOperation())
                    .processOperation(0, transaction.getQuantity()));
        }
    }

    public void addToStorage(FruitTransaction transaction) {
        fruitsStorage.getFruitsStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
