package fruit.shop.service.transaction;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    private final QuantityValidator quantityValidator = new QuantityValidator();

    @Override
    public void execute(FruitTransaction transaction) {
        Integer stock = Storage.get(transaction.getFruit());
        Integer transactionQuantity = transaction.getQuantity();
        if (quantityValidator.validate(stock, transactionQuantity)) {
            Storage.put(transaction.getFruit(), stock - transactionQuantity);
            return;
        }
        throw new RuntimeException("Shop doesn't have enough stock of: " + transaction.getFruit());
    }
}
