package service.transaction;

public interface TransactionHandler {
    void apply(String fruit, Integer amount);
}
