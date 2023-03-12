package fruitshop.dao;

import fruitshop.db.FruitShopStorage;
import fruitshop.model.FruitTransaction;
import java.util.List;

public class FruitShopStorageDaoImpl implements FruitShopStorageDao {
    public void add(FruitTransaction transaction) {
        FruitShopStorage.fruitTransactions.add(transaction);
    }

    public List<FruitTransaction> getAll() {
        return FruitShopStorage.fruitTransactions;
    }
}
