package core.basesyntax.service.transactions;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.Map;

public class PlusTransactionHandler implements TransactionHandler {
    private final FruitShopDao dao = new FruitShopDaoImpl();

    @Override
    public void processTransaction(Transaction transaction) {
        Map<Fruit,Integer> db = dao.getRecords();
        if (db.containsKey(transaction.getFruit())) {
            int newValue = db.get(transaction.getFruit()) + transaction.getQuantity();
            db.put(transaction.getFruit(), newValue);
        } else {
            db.put(transaction.getFruit(), transaction.getQuantity());
        }
        dao.setRecords(db);
    }
}
