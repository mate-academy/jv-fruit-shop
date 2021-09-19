package operations;

public class OperationBalance implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
