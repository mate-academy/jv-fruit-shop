package service.transaction.strategy.type;

import java.util.Map;
import model.FruitTransaction;
import model.InvalidTransaction;

public class BalanceTransaction implements TransactionHandler {
    @Override
    public void perform(Map<String, Integer> stock, FruitTransaction fruitTransaction) {
        String product = fruitTransaction.getProduct();
        int quantity = fruitTransaction.getQuantity();
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
