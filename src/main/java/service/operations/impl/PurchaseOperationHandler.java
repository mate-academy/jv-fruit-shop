package service.operations.impl;

import db.Storage;
import dto.FruitTransactionDto;
import model.Fruit;
import service.operations.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final Storage storage;

    public PurchaseOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransactionDto dto) {
        String fruitName = dto.fruitName();
        int quantity = dto.quantity();
        int currentQuantity = storage.getFruits().getOrDefault(new Fruit(fruitName), 0);
        storage.addFruit(new Fruit(fruitName), currentQuantity - quantity);
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "p".equalsIgnoreCase(dto.operation());
    }
}
