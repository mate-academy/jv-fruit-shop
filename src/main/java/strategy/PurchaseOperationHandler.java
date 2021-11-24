package strategy;

import db.Storage;
import java.util.Map;
import model.Fruit;
import model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruitName = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        for (Map.Entry<Fruit, Integer> fruit : Storage.storage.entrySet()) {
            if (fruitName.equals(transactionDto.getFruitName())) {
                if (fruit.getValue() - quantity < 0) {
                    throw new RuntimeException("Not enough fruits in storage");
                }
                Storage.storage.put(fruitName, quantity);
            }
        }
    }
}
