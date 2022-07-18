package core.basesyntax.service;

import core.basesyntax.dao.PivotDao;
import core.basesyntax.dao.TransactionDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceServiceImpl implements BalanceService {
    private final TransactionDao transactionDao;
    private final PivotDao pivotDao;
    private Map<Product, Integer> balanceList;
    private final OperationStrategy operationStrategy;

    public BalanceServiceImpl(TransactionDao transactionDao, PivotDao pivotDao,
                              OperationStrategy operationStrategy) {
        this.transactionDao = transactionDao;
        this.pivotDao = pivotDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculateBalance() {
        balanceList = Storage.transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getProduct))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .mapToInt(v -> operationStrategy
                                        .get(v.getOperation())
                                        .getOperationalQuantity(v.getQuantity()))
                                .sum()));
    }

    @Override
    public void getTransactionsFromFile() {
        Storage.transactions.addAll(transactionDao.getAll());
    }

    @Override
    public void exportPivotToFile(List<String> report) {
        pivotDao.writePivotFile(report);
    }

    @Override
    public List<String> makeBalanceReport() {
        return balanceList.entrySet().stream()
                .map(p -> (p.getKey().getType() + "," + p.getValue()))
                .collect(Collectors.toList());
    }
}
