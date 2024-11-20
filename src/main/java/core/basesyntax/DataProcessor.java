package core.basesyntax;

import java.util.List;

public class DataProcessor {
    private final FruitDB fruitDB;
    private final DataOperationStrategy operationStrategy;

    public DataProcessor(FruitDB fruitDB, DataOperationStrategy operationStrategy) {
        this.fruitDB = fruitDB;
        this.operationStrategy = operationStrategy;
    }

    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.execute(transaction, fruitDB);
        }
    }
}


