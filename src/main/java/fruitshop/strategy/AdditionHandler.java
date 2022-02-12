package fruitshop.strategy;

public class AdditionHandler implements StrategyService {

    @Override
    public int process(int quality, int balance) {
        return balance + quality;
    }
}
