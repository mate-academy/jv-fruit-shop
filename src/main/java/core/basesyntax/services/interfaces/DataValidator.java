package core.basesyntax.services.interfaces;

public interface DataValidator {
    void checkIfQuantityPositive(int fruitQuantity);

    void checkIfQuantitySufficiently(int balance, int fruitQuantity);
}
