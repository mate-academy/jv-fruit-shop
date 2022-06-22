package strategy;

public class BalanceHandler implements FruitsAmountHandler {
    @Override
    public int getAmount(int quantity, int amount) {
        return amount + quantity;
    }
}
