package core.basesyntax.service;

import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.Map;

public interface BalanceService {
    Map<Product, Integer> getBalance(List<Transaction> transactions);

    void exportPivotToFile(String pivotFileName, List<String> report);

    List<String> makeBalanceReport(Map<Product, Integer> balance);
}
