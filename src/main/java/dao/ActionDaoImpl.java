package dao;

import model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class ActionDaoImpl implements ActionDao {
    private final List<FruitTransaction> transactions = new ArrayList<>();

    @Override
    public void addFruitTransaction(FruitTransaction fruitTransaction) {
        transactions.add(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getListTransactions() {
        return transactions;
    }
}