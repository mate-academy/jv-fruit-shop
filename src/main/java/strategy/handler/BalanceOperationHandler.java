package strategy.handler;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Map<String, Integer> getCurrentBalanceByFruit(List<FruitTransaction> fruitTransactions,
                                                         int index) {
        currentBalanceByFruit.put(fruitTransactions.get(index).getFruit(),
                fruitTransactions.get(index).getQuantity());
        return currentBalanceByFruit;
    }
}
