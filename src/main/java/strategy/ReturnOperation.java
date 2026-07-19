package strategy;

import db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void operate(Map<String, Integer> fruits, FruitTransaction transaction) {
        int currentQuantity = Storage.getFruits().getOrDefault(transaction.getFruit(), 0);
        int newQuantity = currentQuantity + transaction.getQuantity();
        Storage.getFruits().put(transaction.getFruit(), newQuantity);
    }
}
