package strategy;

public class PurchaseHandler implements FruitsAmountHandler {
    @Override
    public int getAmount(int quantity) {
        return - quantity;
    }
}
