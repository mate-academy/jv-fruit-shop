package main;

import core.basesyntax.db.CommandDao;
import core.basesyntax.db.CommandDaoImpl;
import model.FruitStorage;
import model.FruitTransactionStorage;
import service.FruitStoreService;

public class FruitStoreMain {
    public static void main(String[] args) {
        CommandDao commandDao = new CommandDaoImpl();
        FruitTransactionStorage fruitTransactionStorage = commandDao.read();

        FruitStoreService fruitStoreService = new FruitStoreService();
        FruitStorage fruitStorage = fruitStoreService.processTransactions(fruitTransactionStorage);

        commandDao.write(fruitStorage);
    }
}
