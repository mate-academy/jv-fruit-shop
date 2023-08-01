package core.basesyntax.service.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;

public class ShopServiceImpl implements ShopService {
    private Storage storage;

    public ShopServiceImpl() {
    }

    public ShopServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case BALANCE:
                new BalanceHandler()
                        .operation(storage, transaction.getFruit(), transaction.getQuantity());
                break;
            case SUPPLY:
                new SupplyHandler()
                        .operation(storage, transaction.getFruit(), transaction.getQuantity());
                break;
            case RETURN:
                new ReturnHandler()
                        .operation(storage, transaction.getFruit(), transaction.getQuantity());
                break;
            case PURCHASE:
                new PurchaseHandler()
                        .operation(storage, transaction.getFruit(), transaction.getQuantity());
                break;
            default: throw new RuntimeException("Invalid operation attempted");
        }
    }
}
