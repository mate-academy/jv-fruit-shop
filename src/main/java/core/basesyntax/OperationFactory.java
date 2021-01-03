package core.basesyntax;

public class OperationFactory {

    public Operation get(OperationSet type) {
        switch (type) {
            case B :
                return new BalanceOperation();
            case S :
                return new SupplyOperation();
            case P :
                return new PurchaseOperation();
            case R :
                return new ReturnOperation();
            default :
                throw new InvalidOperationException("Unsupported operation found");
        }
    }
}
