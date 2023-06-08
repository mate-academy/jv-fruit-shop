package fruitstore.strategy;

public class PurchaseOption implements Option {
    @Override
    public int getOptionResult(int currentValue, int addValue) {
        int result = currentValue - addValue;
        if (result >= 0) {
            return result;
        }
        throw new RuntimeException("Not enough fruits!");
    }
}
