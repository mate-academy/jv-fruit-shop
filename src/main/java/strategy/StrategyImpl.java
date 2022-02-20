package strategy;

import model.FruitModel;

public class StrategyImpl {
    private Strategy strategy;

    public StrategyImpl(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public boolean executeStrategy(FruitModel fruitModel) {
        return strategy.doOperation(fruitModel);
    }
}
