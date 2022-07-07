package transaction;

public class ReturnTransactionHandler extends AddingTransactionHandler {
    @Override
    public int getAmount(int amount, int newAmount) {
        return super.getAmount(amount, newAmount);
    }
}
