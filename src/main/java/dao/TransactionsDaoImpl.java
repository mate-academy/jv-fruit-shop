package dao;

import db.Storage;
import service.FruitTransactionService;
import service.ReadTransactions;

public class TransactionsDaoImpl implements TransactionsDao {
    private FruitTransactionService fruitTransactionService;
    private ReadTransactions readTransactions;
    private String path;

    public TransactionsDaoImpl(FruitTransactionService fruitTransactionService,
                               ReadTransactions readTransactions, String path) {
        this.fruitTransactionService = fruitTransactionService;
        this.readTransactions = readTransactions;
        this.path = path;
    }

    @Override
    public void createTransactionList() {
        Storage.setTransactions(fruitTransactionService
                .createListOfTransactions(readTransactions.convertFromFileToList(path)));
    }
}
