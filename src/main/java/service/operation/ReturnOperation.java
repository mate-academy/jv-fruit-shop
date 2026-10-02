package service.operation;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int newQuantity = Storage.fruits.getOrDefault(fruit, 0) + transaction.getQuantity();
        Storage.fruits.put(fruit, newQuantity);
    }
}
