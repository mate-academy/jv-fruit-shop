package core.basesyntax.data;

public interface DataValidator {
    void validateAmount(int balance, int checkedAmount);

    void validateFruitName(Integer fruitAmount);

    void validateAmountPositive(Integer fruitAmount);
}
