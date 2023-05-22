package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int newQuantity = fruitTransaction.getQuantity();
        if (Storage.fruits.containsKey(fruitName)) {
            int oldQuantity = Storage.fruits.get(fruitName);
            Storage.fruits.put(fruitName, oldQuantity + newQuantity);
        } else {
            Storage.fruits.put(fruitName, newQuantity);
        }
    }
}
