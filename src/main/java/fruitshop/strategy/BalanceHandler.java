package fruitshop.strategy;

import fruitshop.model.FruitTransaction;

public class BalanceHandler implements StrategyService {

    @Override
    public int process(FruitTransaction fruitTransaction, int optional) {
        return fruitTransaction.getQuantity();
    }
}
