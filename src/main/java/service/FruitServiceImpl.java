package service;

import dao.FruitQuantityStorageDao;
import dao.FruitQuantityStorageDaoImpl;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private FruitQuantityStorageDao storageDao;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storageDao = new FruitQuantityStorageDaoImpl();
    }

    @Override
    public String getReport(List<FruitTransaction> transactions) {
        transactions.forEach(c -> operationStrategy
                .get(c.getTypeOperation())
                .getOperationQuantity(c));
        String report = transactions.stream()
                .map(FruitTransaction::getName)
                .distinct()
                .map(s -> s + "," + storageDao.get(s))
                .collect(Collectors.joining(System.lineSeparator()));
        return REPORT_TITLE + System.lineSeparator() + report;
    }
}
