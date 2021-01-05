package fshop.service.strategy;

public class StrategySupply implements Strategy {
    @Override
    public Integer execute(Integer a, Integer b) {
        return a + b;
    }
}
