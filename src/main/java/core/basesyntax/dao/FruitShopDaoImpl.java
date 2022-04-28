package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void save(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    @Override
    public Integer getValue(FruitTransaction fruitTransaction) {
        return Storage.fruitsStorage.get(fruitTransaction.getFruit());
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : Storage.fruitsStorage.entrySet()) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setFruit(entry.getKey());
            fruitTransaction.setQuantity(entry.getValue());
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
