package strategy;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface Consumption {
    Map<String, Integer> getConsumption(List<FruitTransaction> fruitsTransactionData);
}
