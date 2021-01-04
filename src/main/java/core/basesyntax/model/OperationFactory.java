package core.basesyntax.model;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Product;
import core.basesyntax.model.entities.exception.InvalidOperationException;
import core.basesyntax.model.impl.BalanceOperation;
import core.basesyntax.model.impl.PurchaseOperation;
import core.basesyntax.model.impl.ReturnOperation;
import core.basesyntax.model.impl.SupplyOperation;

public class OperationFactory<T extends Product> {
    private final Warehouse<T> warehouse;

    public OperationFactory(Warehouse<T> warehouse) {
        this.warehouse = warehouse;
    }

    public AbstractOperation<T> get(OperationSet type) {
        switch (type) {
            case B :
                return new BalanceOperation<>(warehouse);
            case S :
                return new SupplyOperation<>(warehouse);
            case P :
                return new PurchaseOperation<>(warehouse);
            case R :
                return new ReturnOperation<>(warehouse);
            default :
                throw new InvalidOperationException("Unsupported operation found");
        }
    }
}
