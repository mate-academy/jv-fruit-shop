package strategy;

public class ReturnHandler implements FruitsAmountHandler {
    @Override
    public int getAmount(int quantity, int amount) {
        return amount + quantity;
    }
}
