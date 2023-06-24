package service;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.transaction.TransactionHandler;

public class ReportServiceImpl implements ReportService {
    private final TransactionStrategy transactionStrategy;
    private final StorageDao storageDao = new StorageDaoImpl();

    public ReportServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public List<String> createReport(List<FruitTransaction> transactions) {
        List<String> fruitList = transactions.stream()
                                            .peek(this::applyTransaction)
                                            .map(FruitTransaction::getFruit)
                                            .distinct()
                                            .collect(Collectors.toList());
        return fruitList.stream()
                        .map(fruit -> fruit + "," + storageDao.getAmount(fruit))
                        .collect(Collectors.toList());
    }

    private void applyTransaction(FruitTransaction transaction) {
        TransactionHandler transactionHandler =
                transactionStrategy.get(transaction.getOperation());
        int amountFromStorage = storageDao.getAmount(transaction.getFruit());
        int newAmount = transactionHandler.calculateRemnant(amountFromStorage,
                                                        transaction.getAmount());
        storageDao.add(transaction.getFruit(), newAmount);
    }
}
