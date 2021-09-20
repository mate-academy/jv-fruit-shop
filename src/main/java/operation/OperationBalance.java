package operation;

public class OperationBalance implements Operation {
    @Override
    public int operate(int first, int second) {
        return first + second;
    }
}
