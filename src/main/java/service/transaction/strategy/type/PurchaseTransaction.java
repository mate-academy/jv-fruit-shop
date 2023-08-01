package service.transaction.strategy.type;

import dao.DbDao;
import java.util.Map;
import model.InvalidTransaction;
import model.Transaction;

public class PurchaseTransaction extends ProductTransactionHandler {
    public PurchaseTransaction(DbDao dbDao) {
        super(dbDao);
    }

    @Override
    public void perform(Transaction transaction) {
        Map<String, Integer> data = dbDao.getData();
        String product = transaction.getProduct();
        int quantity = transaction.getQuantity();
        if (!data.containsKey(product)) {
            throw new InvalidTransaction("Product does not exist id stock");
        }
        quantity = data.get(product) - quantity;
        if (quantity < 0) {
            throw new InvalidTransaction("The transaction cannot be completed, "
                    + "the quantity for sale is greater than the quantity in stock");
        }
        data.put(product, quantity);
        dbDao.updateData(data);
    }
}
