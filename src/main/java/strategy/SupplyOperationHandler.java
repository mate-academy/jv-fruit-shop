package strategy;

import db.Storage;
import dto.TransferObject;
import model.Fruit;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int perform(TransferObject transferObject) {
        Fruit fruit = new Fruit(transferObject.getName());
        int currentQuantity = Storage.getStorage().getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + transferObject.getQuantity();
        Storage.getStorage().put(fruit, newQuantity);
        return newQuantity;
    }
}
