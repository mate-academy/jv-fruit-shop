package shopoperations;

public class Supply implements ShopBalanceOperation {
    @Override
    public int calculate(int previousValue, int value) {
        return previousValue + value;
    }
}
