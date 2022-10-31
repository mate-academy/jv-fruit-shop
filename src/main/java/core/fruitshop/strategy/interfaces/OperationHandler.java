package core.fruitshop.strategy.interfaces;

public interface OperationHandler {
    String AMOUNT_LESS_THEN_ZERO_EXCEPTION_MESSAGE
            = "Amount can't be less then zero for product ";
    String AMOUNT_TO_MINUS_INCORRECT_EXCEPTION_MESSAGE = "Amount to minus can't be "
            + "greater then current amount: ";
    String NOT_EXISTS_EXCEPTION_MESSAGE = " doesn't exist in storage";

    void handle(String productName, int amount);
}
