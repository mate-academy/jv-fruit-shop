package strategy;

public class ReturnHandler implements FruitsAmountHandler {
    @Override
    public int getAmount(int quantity) {
        return quantity;
    }
}
