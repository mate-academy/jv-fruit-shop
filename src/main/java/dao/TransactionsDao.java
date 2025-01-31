package dao;

import java.util.List;
import model.FruitTransaction;

public interface TransactionsDao {

    void processTransaction(FruitTransaction transaction);

    void updateTransactionInfo(FruitTransaction transaction);

    List<FruitTransaction> getAll();

    FruitTransaction getTransactionByName(String fruitName);

    FruitTransaction findOrCreateFruit(FruitTransaction transaction);
}
