package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface FruitTransactionService {
    List<String[]> getTransactions(String fileToReadPath);

    Fruit makeFruit(String[] transactionValues);

    void handleTransaction(Fruit fruit, String transactionType);

    String getReport(Map<String, Fruit> fruits);

    void writeReportToFile(String fileToWritePath, String report);
}
