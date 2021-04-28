package core.basesyntax.data;

public interface DataValidator {
    void validateAmount(int balance, int checkedAmount);

    void validateName(Integer fruitAmount);

    void validateAmountPositive(Integer fruitAmount);
}
