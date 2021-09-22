package service.operation;

public class AddOperation implements Calculator {
    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue + value;
    }
}
