package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import java.util.Map;

public interface StrategyService {

    int process(FruitTransaction fruitTransaction, Map<String, Integer> balancesOfFruits);
}
