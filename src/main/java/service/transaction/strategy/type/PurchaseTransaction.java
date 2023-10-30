package service.transaction.strategy.type;

import java.util.Map;
import model.FruitTransaction;
import model.InvalidTransaction;

public class PurchaseTransaction implements TransactionHandler {
    @Override
    public void perform(Map<String, Integer> stock, FruitTransaction fruitTransaction) {
        String product = fruitTransaction.getProduct();
        int quantity = fruitTransaction.getQuantity();
        if (!stock.containsKey(product)) {
            throw new InvalidTransaction("Product does not exist in stock");
        }
        int quantityInStock = stock.get(product);
        int newQuantity = quantityInStock - quantity;
        if (newQuantity < 0) {
            throw new InvalidTransaction("The transaction cannot be completed, "
                    + " quantity for sale - " + quantity
                    + " is greater than the quantity in stock - " + quantityInStock);
        }
        stock.put(product, newQuantity);
    }
}
