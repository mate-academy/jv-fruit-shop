package core.basesyntax.service.impl;

import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {

    @Override
    public void fillStorage(List<String[]> listOfOperations) {
        TransactionStrategy transactionStrategy = new TransactionStrategy();
        listOfOperations.forEach(s -> transactionStrategy.getTransactionService().get(s[0])
                .makeTransaction(s[1],Integer.parseInt(s[2])));
    }
}
