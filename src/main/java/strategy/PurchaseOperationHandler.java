package strategy;

import db.Storage;
import dto.TransferObject;
import model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int perform(TransferObject transferObject) {
        Fruit fruit = new Fruit(transferObject.getName());
        int newQuantity = Storage.getStorage().get(fruit) - transferObject.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("We don't have enough product");
        } else {
            Storage.getStorage().put(fruit, newQuantity);
        }
        return newQuantity;
    }
}
