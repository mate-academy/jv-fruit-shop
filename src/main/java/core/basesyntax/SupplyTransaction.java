package core.basesyntax;

public class SupplyTransaction extends AbstractTransaction {
    public static final String TRANSACTION_TYPE = "s";

    public SupplyTransaction() {
        super(TRANSACTION_TYPE);
    }
}
