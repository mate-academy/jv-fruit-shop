package core.basesyntax.service.impl;

import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {

    @Override
    public void fillStorage(List<String> listOfOperations) {
        String[] parser;
        for (int i = 1; i < listOfOperations.size(); i++) {
            parser = listOfOperations.get(i).split(",");
            String operation = parser[0];
            String fruits = parser[1];
            int number = Integer.parseInt(parser[2]);
            TransactionStrategy transactionStrategy = new TransactionStrategy();
            transactionStrategy.getTransactionService(operation).makeTransaction(fruits,number);
        }
    }
}
