package fshop.service.strategy;

public class StrategyPurchase implements Strategy {
    @Override
    public Integer execute(Integer a, Integer b) {
        return a - b;
    }
}
