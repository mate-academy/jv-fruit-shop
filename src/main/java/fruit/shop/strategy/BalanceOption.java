package fruit.shop.strategy;

public class BalanceOption implements Option {
    @Override
    public int getOptionResult(int currentValue, int addValue) {
        return addValue;
    }
}
