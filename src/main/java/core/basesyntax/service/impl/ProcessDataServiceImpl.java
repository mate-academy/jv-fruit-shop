package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ProcessDataService;
import java.util.List;
import java.util.Map;

public class ProcessDataServiceImpl implements ProcessDataService {
    private final StorageDao storageDao;

    public ProcessDataServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public Map<String, Integer> processing(List<FruitTransaction> operations) {
        for (FruitTransaction operation : operations) {
            storageDao.putToMap(operation.getFruit(), processTransaction(operation));
        }
        return storageDao.getAll();
    }

    private Integer processTransaction(FruitTransaction operation) {
        int balance = 0;
        if (storageDao.getAmount(operation.getFruit()) != null) {
            balance = storageDao.getAmount(operation.getFruit());
        }

        if (operation.getOperation() == Operation.BALANCE
                || operation.getOperation() == Operation.SUPPLY
                || operation.getOperation() == Operation.RETURN) {
            balance += operation.getQuantity();
        }
        if (operation.getOperation() == Operation.PURCHASE) {
            balance -= operation.getQuantity();
        }

        return balance;
    }
}
