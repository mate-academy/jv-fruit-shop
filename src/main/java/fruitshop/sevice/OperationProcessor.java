package fruitshop.sevice;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface OperationProcessor {
    void manageTransaction(List<FruitTransaction> transactions);
}
