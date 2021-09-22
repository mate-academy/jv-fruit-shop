package service.operation;

public class SubtractionOperation implements Calculator {
    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue - value;
    }
}
