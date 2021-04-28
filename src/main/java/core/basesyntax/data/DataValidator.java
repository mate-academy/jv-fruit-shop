package core.basesyntax.data;

public interface DataValidator {
    void validateAmount(int balance, int checkedAmount);

    void validateAmountPositive(Integer fruitAmount);
}
