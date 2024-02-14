package dao;

import db.Storage;
import java.util.List;
import model.FruitTransaction;

public class ActionDaoImpl implements ActionDao {
    private final Storage storage = new Storage();

    @Override
    public void addFruitTransaction(FruitTransaction fruitTransaction) {
        storage.createTransaction(fruitTransaction);
    }

    @Override
    public void addAllTransactions(List<FruitTransaction> fruitTransactions) {
        storage.setTransactions(fruitTransactions);
    }

    @Override
    public FruitTransaction getFruitTransaction(String operation) {
        return storage.getTransactions().stream()
                .filter(data -> data.getOperation().getCode().equals(operation))
                .findFirst()
                .get();
    }

    @Override
    public List<FruitTransaction> getListTransactions() {
        return storage.getTransactions();
    }
}
