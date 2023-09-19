package service.operation;

import java.util.List;
import model.FruitTransaction;

public interface OperationProcessor {
    void processConvertedData(List<FruitTransaction> fruitTransactionList);
}
