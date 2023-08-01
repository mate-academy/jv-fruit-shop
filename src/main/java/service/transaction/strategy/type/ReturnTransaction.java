package service.transaction.strategy.type;

import java.util.Map;
import model.Transaction;

public class ReturnTransaction implements TransactionHandler {
    @Override
    public void perform(Map<String, Integer> stock, Transaction transaction) {
        String product = transaction.getProduct();
        if (!stock.containsKey(product)) {
            throw new IllegalStateException("Product which wasn't in the stock cannot be returned");
        }
        int quantity = transaction.getQuantity() + stock.get(product);
        stock.put(product, quantity);
    }
}
