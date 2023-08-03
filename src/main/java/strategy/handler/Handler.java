package strategy.handler;

public interface Handler {
    void fruitOperation(String fruit, int quantity);

    boolean checkNull(String fruit);

    boolean checkNegative(int quantity);
}
