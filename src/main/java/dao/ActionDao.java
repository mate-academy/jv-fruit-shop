package dao;

import java.util.List;
import model.FruitTransaction;

public interface ActionDao {
    void addFruitTransaction(FruitTransaction fruitTransaction);

    List<FruitTransaction> getListTransactions();
}
