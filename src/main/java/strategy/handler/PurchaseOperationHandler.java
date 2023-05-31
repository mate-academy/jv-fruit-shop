package strategy.handler;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Map<String, Integer> getCurrentBalanceByFruit(List<FruitTransaction> fruitTransactions,
                                                         int index) {
        for (Map.Entry<String, Integer> entry : currentBalanceByFruit.entrySet()) {
            if (entry.getKey().equals(fruitTransactions.get(index).getFruit())) {
                if (entry.getValue() > fruitTransactions.get(index).getQuantity()) {
                    entry.setValue(entry.getValue() - fruitTransactions.get(index).getQuantity());
                } else {
                    throw new RuntimeException("Not enough quantity for purchase!");
                }
            }
        }
        return currentBalanceByFruit;
    }
}
