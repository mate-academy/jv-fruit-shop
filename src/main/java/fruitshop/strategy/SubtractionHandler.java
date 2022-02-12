package fruitshop.strategy;

public class SubtractionHandler implements StrategyService {

    @Override
    public int process(int quality, int balance) {
        return balance - quality;
    }
}
