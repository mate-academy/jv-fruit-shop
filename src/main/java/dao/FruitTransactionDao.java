package dao;

import java.util.HashMap;
import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionDao {
    void saveAllTransactionToDB(List<FruitTransaction> transactionsToSave);

    void saveCurrentBalanceByFruitToDB(HashMap<String, Integer> currentBalanceToSave);
}
