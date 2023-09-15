package service.operation;

import java.util.List;
import model.FruitTransaction;
import service.OperationStrategy;

public interface OperationProcessor {
    void processConvertedData(List<FruitTransaction> fruitTransactionList,
                              OperationStrategy operationStrategy);
}
