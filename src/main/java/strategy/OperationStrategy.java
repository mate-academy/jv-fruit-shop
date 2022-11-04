package strategy;

import java.util.Map;

public class OperationStrategy {
    private static final int INDEX_OF_TRANSACTION = 0;
    private final Map<String, TransactionStrategy> strategyMap;

    public OperationStrategy(Map<String, TransactionStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public TransactionStrategy getStrategy(String[] s) {
        return strategyMap.get(s[INDEX_OF_TRANSACTION]);
    }
}
