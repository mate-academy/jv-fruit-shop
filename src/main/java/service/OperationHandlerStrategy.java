package service;

public interface AmountStrategy {
    AmountHandler get(Operation operation);
}
