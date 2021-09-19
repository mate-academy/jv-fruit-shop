package operations;

public class OperationPurchase implements Operation {
    @Override
    public int calculate(int first, int second) {
        if (first - second < 0) {
            throw new RuntimeException("Have no enough product");
        }
        return first - second;
    }
}
