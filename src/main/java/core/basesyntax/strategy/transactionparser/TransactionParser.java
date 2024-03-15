package core.basesyntax.strategy.transactionparser;

import java.util.List;
import java.util.Map;

public interface TransactionParser {
    List<String> generateReport(Map<String, Integer> fruitQuantities);
}
