package shopoperations;

public class Return implements ShopBalanceOperation {
    @Override
    public int calculate(int previousValue, int value) {
        return previousValue + value;
    }
}
