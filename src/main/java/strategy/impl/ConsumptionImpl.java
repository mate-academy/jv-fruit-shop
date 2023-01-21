package strategy.impl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.Consumption;

public class ConsumptionImpl implements Consumption {
    @Override
    public Map<String, Integer> getConsumption(List<FruitTransaction> fruitsTransactionData) {
        return new Purchase().getInterimSettlement(fruitsTransactionData);
    }
}
