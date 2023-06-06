package fruit.shop.strategy;

public class PurchaseOption implements Option {
    @Override
    public int getOptionResult(int currentValue, int addValue) {
        return currentValue - addValue;
    }
}
