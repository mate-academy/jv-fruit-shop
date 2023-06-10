package fruit.shop.service.strategy;

public class BalanceHandler implements ActivityHandler {
    @Override
    public int getOptionResult(int currentValue, int addValue) {
        return addValue;
    }
}
