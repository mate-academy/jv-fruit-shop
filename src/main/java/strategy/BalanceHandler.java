package strategy;

public class BalanceHandler implements FruitsAmountHandler {
    @Override
    public int getAmount(int quantity) {
        return quantity;
    }
}
