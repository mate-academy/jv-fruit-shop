package core.basesyntax.service;

public interface FruitTransactionValidator<T, U> {
    void validateOperation(T t);

    void validateFruit(String fruit);

    void validateAmount(int amount, U u);
}
