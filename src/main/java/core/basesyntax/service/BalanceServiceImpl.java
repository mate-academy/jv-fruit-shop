package core.basesyntax.service;

import core.basesyntax.Dao.PivotDao;
import core.basesyntax.Dao.PivotDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceServiceImpl implements BalanceService {
    private final List<Transaction> balanceDao;
    private final OperationStrategy operationStrategy;

    public BalanceServiceImpl(List<Transaction> balanceDao, OperationStrategy operationStrategy) {
        this.balanceDao = balanceDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<Product, Integer> getBalance() {
        return balanceDao.stream()
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
    public void exportPivotToFile(String pivotFileName) {
        PivotDao pivotDao = new PivotDaoImpl();
        pivotDao.writePivotFile(pivotFileName, this.makeBalanceReport());
    }

    private List<String> makeBalanceReport() {
        return new PivotDaoImpl().getBalanceList(this.getBalance());
    }
}
