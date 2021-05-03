package shopoperations;

public class Purchase implements ShopBalanceOperation {
    @Override
    public int calculate(int previousValue, int value) {
        return previousValue - value;
    }
}
