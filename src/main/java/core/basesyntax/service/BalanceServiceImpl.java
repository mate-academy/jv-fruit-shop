package core.basesyntax.service;

import core.basesyntax.dao.PivotDao;
import core.basesyntax.dao.PivotDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceServiceImpl implements BalanceService {
    private final OperationStrategy operationStrategy;

    public BalanceServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<Product, Integer> getBalance(List<Transaction> transactions) {
        return transactions.stream()
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
    public void exportPivotToFile(String pivotFileName, List<String> report) {
        PivotDao pivotDao = new PivotDaoImpl();
        pivotDao.writePivotFile(pivotFileName, report);
    }

    @Override
    public List<String> makeBalanceReport(Map<Product, Integer> balance) {
        return new PivotDaoImpl().getBalanceList(balance);
    }
}
