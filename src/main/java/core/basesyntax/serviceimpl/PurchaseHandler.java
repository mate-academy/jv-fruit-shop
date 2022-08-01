package core.basesyntax.serviceimpl;

import core.basesyntax.dao.DaoFruitStorage;
import core.basesyntax.daoimpl.DaoFruitStorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseHandler implements OperationHandler {
    private final DaoFruitStorage fruitStorage = new DaoFruitStorageImpl();

    @Override
    public void apply(List<FruitTransaction> transactions) {
        getPurchaseList(transactions).stream()
                .forEach(t -> {
                    int remainder = fruitStorage.getQuantityFromFruitStorage(t.getFruitType());
                    int newQuantity = remainder - t.getQuantity();
                    fruitStorage.addToFruitStorage(t.getFruitType(), newQuantity);
                });
    }

    private List<FruitTransaction> getPurchaseList(List<FruitTransaction> transactions) {
        return transactions.stream()
        .filter(t -> t.getOperation() == FruitTransaction.Operation.PURCHASE)
        .collect(Collectors.toList());
    }

}

