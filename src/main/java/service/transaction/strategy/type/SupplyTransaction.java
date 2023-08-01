package service.transaction.strategy.type;

import dao.DbDao;
import java.util.Map;
import model.Transaction;

public class SupplyTransaction extends ProductTransactionHandler {
    public SupplyTransaction(DbDao dbDao) {
        super(dbDao);
    }

    @Override
    public void perform(Transaction transaction) {
        Map<String, Integer> data = dbDao.getData();
        String product = transaction.getProduct();
        int quantity = transaction.getQuantity();
        if (data.containsKey(product)) {
            quantity += data.get(product);
        }
        data.put(product, quantity);
        dbDao.updateData(data);
    }
}
