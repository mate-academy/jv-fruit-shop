package fruitshop.strategy;

public class BalanceHandler implements StrategyService {

    @Override
    public int process(int quality, int balance) {
        return quality;
    }
}
