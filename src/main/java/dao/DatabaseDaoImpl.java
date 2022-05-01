package dao;

import db.Database;
import java.util.List;
import model.FruitTransaction;

public class DatabaseDaoImpl implements DatabaseDao {
    @Override
    public void addAllTransaction(List<FruitTransaction> fruitTransaction) {
        Database.database.addAll(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getFruitTransaction() {
        return Database.database;
    }
}
