package fruit.shop.strategy;

public class PurchaseHandler implements ActivityHandler {
    @Override
    public int getOptionResult(int currentValue, int addValue) {
        int result = currentValue - addValue;
        if (result >= 0) {
            return result;
        }
        throw new RuntimeException("Not enough fruits!");
    }
}
