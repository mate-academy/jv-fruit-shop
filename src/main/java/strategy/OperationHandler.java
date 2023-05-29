package strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface OperationHandler {
    Map<String, Integer> currentBalanceByFruit = new HashMap<>();

    Map<String, Integer> getCurrentBalanceByFruit(List<FruitTransaction> fruitTransactions,
                                                  int index);
}
