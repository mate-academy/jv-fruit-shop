package dao;

import java.util.List;
import model.FruitTransaction;

public interface ActionDao {
    void addFruitTransaction(FruitTransaction fruitTransaction);

    void addAllTransactions(List<FruitTransaction> fruitTransactions);

    FruitTransaction getFruitTransaction(String operation);

    List<FruitTransaction> getListTransactions();
}
