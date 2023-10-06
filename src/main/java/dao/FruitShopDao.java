package dao;

import java.util.List;

public interface FruitShopDao {
    void processTransactions(List<String> transactionLines);
}
