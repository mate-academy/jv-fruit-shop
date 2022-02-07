package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import java.util.Map;

public class BalanceHandler implements StrategyService {

    @Override
    public int process(FruitTransaction fruitTransaction, Map<String, Integer> balancesOfFruits) {
        return fruitTransaction.getQuantity();
    }
}
