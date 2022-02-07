package fruitshop.strategy;

import fruitshop.model.FruitTransaction;

public class SubtractionHandler implements StrategyService {

    @Override
    public int process(FruitTransaction fruitTransaction, int optional) {
        return optional - fruitTransaction.getQuantity();
    }
}
