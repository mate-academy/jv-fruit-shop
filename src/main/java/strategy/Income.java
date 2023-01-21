package strategy;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface Income {
    Map<String, Integer> getIncome(List<FruitTransaction> fruitsTransactionData);
}
