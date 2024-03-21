package service.operations.impl;

import db.Storage;
import dto.FruitTransactionDto;
import model.Fruit;
import service.operations.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransactionDto dto) {
        String fruitName = dto.fruitName();
        int quantity = dto.quantity();
        storage.addFruit(new Fruit(fruitName), quantity);
    }
}
