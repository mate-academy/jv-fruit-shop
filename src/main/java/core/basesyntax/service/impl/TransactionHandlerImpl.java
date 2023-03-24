package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionHandlerImpl implements TransactionHandler {
    private StorageDao storageDao;
    private TransactionStrategy transactionStrategy;

    public TransactionHandlerImpl(StorageDao storageDao, TransactionStrategy transactionStrategy) {
        this.storageDao = storageDao;
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public List<String> getReport(List<String> listInputData) {
        ParserService parse = new ParserServiceImpl();
        Set<Fruit> listFruits = new HashSet<>();

        for (String text : listInputData) {
            FruitTransaction fruitTransaction = parse.getDataFromLine(text, transactionStrategy);
            Fruit fruit = fruitTransaction.getFruit();
            listFruits.add(fruit);
            if (storageDao.getQuantity(fruit) == null) {
                storageDao.add(fruit, 0);
            }
            int newQuantity = fruitTransaction.getOperationHandler()
                    .getBalance(storageDao.getQuantity(fruit), fruitTransaction.getQuantity());
            storageDao.add(fruit, newQuantity);
        }
        return new ReportCreationServiceImpl().getResult(listFruits, storageDao);
    }
}
