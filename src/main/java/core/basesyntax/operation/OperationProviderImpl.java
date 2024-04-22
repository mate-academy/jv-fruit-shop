package core.basesyntax.operation;

public class OperationProviderImpl implements OperationProvider {
    private static final String BALANCE_ABBREVIATION = "b";
    private static final String SUPPLY_ABBREVIATION = "s";
    private static final String PURCHASE_ABBREVIATION = "p";
    private static final String RETURN_ABBREVIATION = "r";

    public StoreOperation.Operation get(String operation) {
        return switch (operation) {
            case BALANCE_ABBREVIATION -> StoreOperation.Operation.BALANCE;
            case SUPPLY_ABBREVIATION -> StoreOperation.Operation.SUPPLY;
            case PURCHASE_ABBREVIATION -> StoreOperation.Operation.PURCHASE;
            case RETURN_ABBREVIATION -> StoreOperation.Operation.RETURN;
            default -> throw new RuntimeException("Invalid data, no corresponding Operation");
        };
    }
}
