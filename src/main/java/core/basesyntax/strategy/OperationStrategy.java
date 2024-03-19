package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Balance;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Purchase;
import core.basesyntax.model.Return;
import core.basesyntax.model.Supply;

public class OperationStrategy {

    public void processData(Operation operation) {
        switch (operation) {
            case Balance balance -> {
                Storage.data.put(balance.getProduct(), balance.getAmount());
            }
            case Purchase purchase -> {
                int newAmount = Storage.data.get(purchase.getProduct()) - purchase.getAmount();
                Storage.data.put(purchase.getProduct(), newAmount);
            }
            case Return opReturn -> {
                int newAmount = Storage.data.get(opReturn.getProduct()) + opReturn.getAmount();
                Storage.data.put(opReturn.getProduct(), newAmount);
            }
            case Supply supply -> {
                int newAmount = Storage.data.get(supply.getProduct()) + supply.getAmount();
                Storage.data.put(supply.getProduct(), newAmount);
            }
        }
    }
}
