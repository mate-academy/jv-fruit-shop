package fruit.shop.service.strategy;

public class SupplyHandler implements ActivityHandler {
    @Override
    public int getOptionResult(int currentValue, int addValue) {
        return currentValue + addValue;
    }
}
