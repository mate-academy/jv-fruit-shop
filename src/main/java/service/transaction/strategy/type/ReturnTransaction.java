package service.transaction.strategy.type;

import dao.DbDao;
import java.util.Map;
import model.Transaction;

public class ReturnTransaction extends ProductTransactionHandler {
    public ReturnTransaction(DbDao dbDao) {
        super(dbDao);
    }

    @Override
    public void perform(Transaction transaction) {
        Map<String, Integer> data = dbDao.getData();
        String product = transaction.getProduct();
        if (!data.containsKey(product)) {
            throw new IllegalStateException("Product which wasn't in the stock cannot be returned");
        }
        int quantity = transaction.getQuantity() + data.get(product);
        data.put(product, quantity);
        dbDao.updateData(data);
    }
}
