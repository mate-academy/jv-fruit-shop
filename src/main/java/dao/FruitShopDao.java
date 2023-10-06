package dao;

import java.util.List;

public interface FruitShopDao {
//    void add(FruitTransaction fruitTransaction);
//
//    FruitTransaction get(String fruit);
//
//    List<FruitTransaction> getAll();

    void processTransactions(List<String> transactionLines);
}
