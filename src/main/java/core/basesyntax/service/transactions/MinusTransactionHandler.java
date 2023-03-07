package core.basesyntax.service.transactions;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.Map;

public class MinusTransactionHandler implements TransactionHandler {
    private static final String CSV_SEPARATOR = ",";
    private final FruitShopDao dao = new FruitShopDaoImpl();

    @Override
    public void processTransaction(Transaction transaction) {
        Map<Fruit,Integer> db = dao.getRecords();
        if (db.containsKey(transaction.getFruit())) {
            if (db.get(transaction.getFruit()) >= transaction.getQuantity()) {
                int newValue = db.get(transaction.getFruit()) - transaction.getQuantity();
                db.put(transaction.getFruit(), newValue);
                dao.setRecords(db);
            } else {
                System.out.println("Not enough fruits in storage, only "
                        + db.get(transaction.getFruit()) + " left; transaction ["
                        + transaction.getTransactionType().getAsLetter() + CSV_SEPARATOR
                        + transaction.getFruit().getFruitType().getAsString() + CSV_SEPARATOR
                        + transaction.getQuantity() + "] rejected.");
            }
        } else {
            System.out.println("There is no such fruits in storage, transaction ["
                    + transaction.getTransactionType().getAsLetter() + CSV_SEPARATOR
                    + transaction.getFruit().getFruitType().getAsString() + CSV_SEPARATOR
                    + transaction.getQuantity() + "] cancelled.");
        }
    }
}
