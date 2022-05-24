package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import storage.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruitStorage.put(fruitTransaction.getFruit(), fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruitName) {
        return Storage.fruitStorage.get(fruitName);
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (Map.Entry<String, FruitTransaction> entry : Storage.fruitStorage.entrySet()) {
            fruitTransactionList.add(entry.getValue());
        }
        return fruitTransactionList;
    }
}
