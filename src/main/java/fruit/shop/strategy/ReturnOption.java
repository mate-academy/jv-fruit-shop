package fruit.shop.strategy;

public class ReturnOption implements Option {
    @Override
    public int getOptionResult(int currentValue, int addValue) {
        return currentValue + addValue;
    }
}
