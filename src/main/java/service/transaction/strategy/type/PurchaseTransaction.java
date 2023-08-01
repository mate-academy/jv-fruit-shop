package service.transaction.strategy.type;

import java.util.Map;
import model.InvalidTransaction;
import model.Transaction;

public class PurchaseTransaction implements TransactionHandler {
    @Override
    public void perform(Map<String, Integer> stock, Transaction transaction) {
        String product = transaction.getProduct();
        int quantity = transaction.getQuantity();
        if (!stock.containsKey(product)) {
            throw new InvalidTransaction("Product does not exist in stock");
        }
        quantity = stock.get(product) - quantity;
        if (quantity < 0) {
            throw new InvalidTransaction("The transaction cannot be completed, "
                    + "the quantity for sale is greater than the quantity in stock");
        }
        stock.put(product, quantity);
    }
}
