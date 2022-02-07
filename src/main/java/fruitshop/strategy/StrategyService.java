package fruitshop.strategy;

import fruitshop.model.FruitTransaction;

public interface StrategyService {

    int process(FruitTransaction fruitTransaction, int optional);
}
