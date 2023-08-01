package service.transaction.strategy.type;

import java.util.Map;
import model.InvalidTransaction;
import model.Transaction;

public class BalanceTransaction implements TransactionHandler {
    @Override
    public void perform(Map<String, Integer> stock, Transaction transaction) {
        String product = transaction.getProduct();
        int quantity = transaction.getQuantity();
        if (stock.containsKey(product)) {
            if (stock.get(product) != quantity) {
                throw new InvalidTransaction("Product has already quantity in stock "
                        + "and it`s not " + quantity);
            }
            return;
        }
        stock.put(product, quantity);
    }
}
