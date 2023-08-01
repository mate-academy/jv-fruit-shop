package service.transaction.strategy.type;

import java.util.Map;
import model.Transaction;

public class SupplyTransaction implements TransactionHandler {
    @Override
    public void perform(Map<String, Integer> stock, Transaction transaction) {
        String product = transaction.getProduct();
        int quantity = transaction.getQuantity();
        if (stock.containsKey(product)) {
            quantity += stock.get(product);
        }
        stock.put(product, quantity);
    }
}
