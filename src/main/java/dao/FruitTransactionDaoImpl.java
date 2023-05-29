package dao;

import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public void saveAllTransactionToDB(List<FruitTransaction> transactionsToSave) {
        Storage.FRUIT_TRANSACTIONS.addAll(transactionsToSave);
    }

    @Override
    public void saveCurrentBalanceByFruitToDB(HashMap<String, Integer> currentBalanceToSave) {
        for (Map.Entry<String, Integer> entry : currentBalanceToSave.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Can't create report with " + entry.getKey()
                        + ", its balance is negative");
            }
            Storage.CURRENT_BALANCE_BY_FRUIT.put(entry.getKey(), entry.getValue());
        }
    }
}
