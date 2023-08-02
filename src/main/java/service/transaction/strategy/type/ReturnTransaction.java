package service.transaction.strategy.type;

import java.util.Map;
import model.FruitTransaction;

public class ReturnTransaction implements TransactionHandler {
    @Override
    public void perform(Map<String, Integer> stock, FruitTransaction fruitTransaction) {
        String product = fruitTransaction.getProduct();
        if (!stock.containsKey(product)) {
            throw new IllegalStateException("Product which wasn't in the stock cannot be returned");
        }
        int quantity = fruitTransaction.getQuantity() + stock.get(product);
        stock.put(product, quantity);
    }
}
