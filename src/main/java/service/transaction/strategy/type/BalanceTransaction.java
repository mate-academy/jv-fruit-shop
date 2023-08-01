package service.transaction.strategy.type;

import dao.DbDao;
import java.util.Map;
import model.InvalidTransaction;
import model.Transaction;

public class BalanceTransaction extends ProductTransactionHandler {
    public BalanceTransaction(DbDao dbDao) {
        super(dbDao);
    }

    @Override
    public void perform(Transaction transaction) {
        Map<String, Integer> data = dbDao.getData();
        String product = transaction.getProduct();
        int quantity = transaction.getQuantity();
        if (data.containsKey(product)) {
            if (data.get(product) != quantity) {
                throw new InvalidTransaction("Product has already quantity in stock "
                        + "and it`s not " + quantity);
            }
            return;
        }
        data.put(product, quantity);
        dbDao.updateData(data);
    }
}
