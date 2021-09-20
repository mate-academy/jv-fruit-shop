package operation;

public class OperationSupply implements Operation {
    @Override
    public int operate(int first, int second) {
        return first + second;
    }
}
