package operations;

public class OperationSupply implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
