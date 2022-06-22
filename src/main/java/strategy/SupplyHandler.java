package strategy;

public class SupplyHandler implements FruitsAmountHandler {
    @Override
    public int getAmount(int quantity, int amount) {
        return amount + quantity;
    }
}
