package strategy;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface OperationHandler {
    Map<String, Integer> getInterimSettlement(List<FruitTransaction> fruitsTransactionData);
}
