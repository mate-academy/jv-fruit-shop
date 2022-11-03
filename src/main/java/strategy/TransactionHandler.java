package strategy;

public interface TransactionHandler {
    void addToBalance(String fruit, Integer quantity);

    void takeFromBalance(String fruit, Integer quantity);
}
