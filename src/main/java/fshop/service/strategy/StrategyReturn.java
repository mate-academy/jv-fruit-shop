package fshop.service.strategy;

public class StrategyReturn implements Strategy {
    @Override
    public Integer execute(Integer a, Integer b) {
        return a + b;
    }
}
