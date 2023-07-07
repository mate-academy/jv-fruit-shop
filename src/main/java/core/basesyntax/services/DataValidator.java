package core.basesyntax.services;

public interface DataValidator {
    void validateAmount(int balance, int amount);

    void positiveAmountValidator(Integer fruitAmount);
}
