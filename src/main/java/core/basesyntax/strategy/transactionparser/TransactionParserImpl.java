package core.basesyntax.strategy.transactionparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionParserImpl implements TransactionParser {
    public List<String> generateReport(Map<String, Integer> fruitQuantities) {
        List<String> result = new ArrayList<>();
        result.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitQuantities.entrySet()) {
            result.add(entry.getKey() + ',' + entry.getValue());
        }
        return result;
    }
}
