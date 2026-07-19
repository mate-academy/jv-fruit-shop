package strategy;

import db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void operate(Map<String, Integer> fruits, FruitTransaction transaction) {
        Storage.getFruits().put(transaction.getFruit(), transaction.getQuantity());
    }
}
