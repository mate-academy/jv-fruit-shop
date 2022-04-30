package dao;

import db.Database;
import java.util.List;
import model.FruitTransaction;

public class DatabaseDaoImpl implements DatabaseDao {
    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        Database.database.add(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getFruitTransaction() {
        return Database.database;
    }
}
