package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import java.util.Map;

public class SubtractionHandler implements StrategyService {

    @Override
    public int process(FruitTransaction fruitTransaction, Map<String, Integer> balancesOfFruits) {
        return balancesOfFruits.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity();
    }
}
