package core.basesyntax.service.impl;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.AbstractTransaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShopCalculationService;
import java.util.List;

public class FruitShopCalculationServiceImpl implements ShopCalculationService<Fruit> {
    private final FruitShopStorage fruitShopStorage;

    public FruitShopCalculationServiceImpl(FruitShopStorage fruitShopStorage) {
        this.fruitShopStorage = fruitShopStorage;
    }

    @Override
    public FruitShopStorage calculate(List<AbstractTransaction<Fruit>> abstractTransactions) {
        abstractTransactions.forEach(this::processFruitTransaction);
        return fruitShopStorage;
    }

    private void processFruitTransaction(AbstractTransaction<Fruit> transaction) {
        fruitShopStorage.save(transaction.getItem(), transaction.getQuantity(),
                              transaction.getOperationType()
        );
    }
}
