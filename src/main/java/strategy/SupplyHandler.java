package strategy;

public class SupplyHandler implements FruitsAmountHandler {
    @Override
    public int getAmount(int quantity) {
        return quantity;
    }
}
