package service.transaction.strategy.type;

import java.util.Map;
import model.FruitTransaction;

public class SupplyTransaction implements TransactionHandler {
    @Override
    public void perform(Map<String, Integer> stock, FruitTransaction fruitTransaction) {
        String product = fruitTransaction.getProduct();
        int quantity = fruitTransaction.getQuantity();
        if (stock.containsKey(product)) {
            quantity += stock.get(product);
        }
        stock.put(product, quantity);
    }
}
