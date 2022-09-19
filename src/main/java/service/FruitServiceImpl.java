package service;

import dao.FruitQuantityStorageDao;
import dao.FruitQuantityStorageDaoImpl;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private FruitQuantityStorageDao storageDao;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storageDao = new FruitQuantityStorageDaoImpl();
    }

    @Override
    public List<FruitTransaction> getReport(List<FruitTransaction> transactions) {
        transactions.forEach(c -> operationStrategy
                .get(c.getTypeOperation())
                .getOperationQuantity(c));
        return transactions.stream()
                .map(FruitTransaction::getName)
                .distinct()
                .map(s -> new FruitTransaction(FruitTransaction.Operation.BALANCE,
                        s,storageDao.get(s)))
                .collect(Collectors.toList());
    }
}
