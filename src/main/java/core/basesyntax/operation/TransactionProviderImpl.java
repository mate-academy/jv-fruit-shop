package core.basesyntax.operation;

public class TransactionProviderImpl implements TransactionProvider {
    private static final String BALANCE_ABBREVIATION = "b";
    private static final String SUPPLY_ABBREVIATION = "s";
    private static final String PURCHASE_ABBREVIATION = "p";
    private static final String RETURN_ABBREVIATION = "r";

    public Transaction.Operation get(String operation) {
        return switch (operation) {
            case BALANCE_ABBREVIATION -> Transaction.Operation.BALANCE;
            case SUPPLY_ABBREVIATION -> Transaction.Operation.SUPPLY;
            case PURCHASE_ABBREVIATION -> Transaction.Operation.PURCHASE;
            case RETURN_ABBREVIATION -> Transaction.Operation.RETURN;
            default -> throw new RuntimeException("Invalid data, no corresponding Operation");
        };
    }
}
