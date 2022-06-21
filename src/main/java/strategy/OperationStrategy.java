package strategy;

public class OperationStrategy {
    private static final String PURCHASE = "p";
    private static final int SHOULD_ADD_TO_QUANTITY = 1;
    private static final int SHOULD_SUBSTRACT_FROM_QUANTITY = -1;

    public static int getCahngesInQuantityByType(String operation) {
        return PURCHASE.equals(operation.replace(" ", ""))
                ? SHOULD_SUBSTRACT_FROM_QUANTITY : SHOULD_ADD_TO_QUANTITY;
    }
}
