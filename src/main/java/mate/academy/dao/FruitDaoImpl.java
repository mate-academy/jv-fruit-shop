package mate.academy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mate.academy.db.Storage;
import mate.academy.model.FruitTransaction;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruitName) {
        return Storage.fruits.get(fruitName);
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (Map.Entry<String, FruitTransaction> entry : Storage.fruits.entrySet()) {
            fruitTransactionList.add(entry.getValue());
        }
        return fruitTransactionList;
    }
}
