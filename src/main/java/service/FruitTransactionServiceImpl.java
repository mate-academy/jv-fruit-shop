package service;

import dao.StorageDaoImpl;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    StorageDaoImpl dao = new StorageDaoImpl();

    @Override
    public FruitTransaction createFruitTransaction(String stringFromFile) {

        return null;
    }

    @Override
    public FruitTransaction createFruitTransaction(String type, String fruit, int quantity) {
        return new FruitTransaction(type, fruit, quantity);
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        dao.putTransfer(transaction);
    }
}
