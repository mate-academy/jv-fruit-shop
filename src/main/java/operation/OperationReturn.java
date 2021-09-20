package operation;

public class OperationReturn implements Operation {
    @Override
    public int operate(int first, int second) {
        return first + second;
    }
}
