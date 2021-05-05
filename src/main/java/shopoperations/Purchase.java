package shopoperations;

public class Purchase implements ShopBalanceOperation {
    @Override
    public int calculate(int previousValue, int value) {
        if (previousValue - value < 0) {
            throw new RuntimeException("Cannot do this operation,"
                    + " because of lack of fruit in storage.");
        }
        return previousValue - value;
    }
}
