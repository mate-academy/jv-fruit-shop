package strategy;

public class PurchaseHandler implements FruitsAmountHandler {
    @Override
    public int getAmount(int quantity, int amount) {
        return amount - quantity;
    }
}
