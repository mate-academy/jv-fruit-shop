package strategy;

import db.Storage;
import dto.Transaction;
import model.Fruit;

public class SupplyOperationHandler implements OperationHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public int perform(Transaction transferObject) {
        Fruit fruit = new Fruit(transferObject.getName());
        int currentQuantity = Storage.getStorage().getOrDefault(fruit, DEFAULT_VALUE);
        int newQuantity = currentQuantity + transferObject.getQuantity();
        Storage.getStorage().put(fruit, newQuantity);
        return newQuantity;
    }
}
