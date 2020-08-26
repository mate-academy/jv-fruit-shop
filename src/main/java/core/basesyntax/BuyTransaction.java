package core.basesyntax;

public class BuyTransaction extends AbstractTransaction {
    public static final String TRANSACTION_TYPE = "b";

    public BuyTransaction() {
        super(TRANSACTION_TYPE);
    }

}
