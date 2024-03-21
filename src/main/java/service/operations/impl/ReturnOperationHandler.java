package service.operations.impl;

import db.Storage;
import dto.FruitTransactionDto;
import model.Fruit;
import service.operations.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final Storage storage;

    public ReturnOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransactionDto dto) {
        String fruitName = dto.fruitName();
        int returnedQuantity = dto.quantity();
        int currentQuantity = storage.getFruits().getOrDefault(new Fruit(fruitName), 0);
        storage.addFruit(new Fruit(fruitName), currentQuantity + returnedQuantity);
    }
}
