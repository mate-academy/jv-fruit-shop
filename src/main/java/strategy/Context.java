package strategy;

import model.FruitModel;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public boolean executeStrategy(FruitModel fruitModel) {
        return strategy.doOperation(fruitModel);
    }
}
