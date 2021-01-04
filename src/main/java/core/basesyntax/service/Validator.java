package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.entities.Product;
import core.basesyntax.model.entities.exception.InvalidOperationException;
import core.basesyntax.model.OperationSet;
import core.basesyntax.db.Warehouse;
import core.basesyntax.model.impl.BalanceOperation;
import core.basesyntax.model.impl.PurchaseOperation;
import core.basesyntax.model.impl.ReturnOperation;

import java.util.Map;

public class Validator<T extends Product> {
    private final Warehouse<T> warehouse;

    public Validator(Warehouse<T> warehouse) {
        this.warehouse = warehouse;
    }

    public void validateOperation(Operation<T> operation, Product product, Integer amount) {
        Map<? extends Product, Integer> storage = warehouse.getStorage();
        if (operation instanceof PurchaseOperation
                && (!storage.containsKey(product) || storage.get(product) - amount < 0)) {
            throw new InvalidOperationException(
                    "Demand is higher than supply for product " + product.getName());
        }
        if (operation instanceof ReturnOperation
                && (!storage.containsKey(product) || storage.get(product) - amount < 0)) {
            throw new InvalidOperationException("Invalid return amount for product " + product.getName());
        }
        if (operation instanceof BalanceOperation && storage.containsKey(product)) {
            throw new InvalidOperationException(
                    "More than one Balance operation found for product " + product.getName());
        }
    }
}
