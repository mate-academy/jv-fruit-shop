package core.basesyntax;

public class ReturnTransaction extends AbstractTransaction {
    public static final String TRANSACTION_TYPE = "r";

    public ReturnTransaction() {
        super(TRANSACTION_TYPE);
    }
}
