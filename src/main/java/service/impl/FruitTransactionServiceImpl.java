package service.impl;

import db.Storage;
import model.FruitTransaction;
import service.FruitTransactionService;
import strategy.FruitTransactionStrategy;

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

    public void addToStorage(String[] dataFromFile) {
        FruitTransaction fruit = new FruitTransaction();
        for (String string : dataFromFile) {
            String[] data = string.split(",");
            fruit.setFruit(data[FRUIT_NAME_INDEX]);
            fruit.setOperation((FruitTransaction.Operation.valueOf(FruitTransaction.Operation
                    .getOperationByString(data[OPERATION_INDEX]))));
            if (fruitsStorage.getFruitsStorage().containsKey(fruit.getFruit())) {
                fruit.setQuantity(strategy.get(fruit.getOperation())
                        .getOperation(fruitsStorage.getFruitsStorage().get(fruit.getFruit()),
                                Integer.parseInt(data[QUANTITY_INDEX])));
            } else {
                fruit.setQuantity(strategy.get(fruit.getOperation())
                        .getOperation(0, Integer.parseInt(data[QUANTITY_INDEX])));
            }
            fruitsStorage.getFruitsStorage().put(fruit.getFruit(), fruit.getQuantity());
        }
    }
}
