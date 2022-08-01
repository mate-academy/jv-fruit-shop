package core.basesyntax.serviceimpl;

import core.basesyntax.dao.DaoFruitStorage;
import core.basesyntax.daoimpl.DaoFruitStorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.List;
import java.util.stream.Collectors;

public class ReturnHandler implements OperationHandler {
    private final DaoFruitStorage fruitStorage = new DaoFruitStorageImpl();

    @Override
    public void apply(List<FruitTransaction> transactions) {
        getReturnList(transactions).stream()
                .forEach(t -> {
                    int remainder = fruitStorage.getQuantityFromFruitStorage(t.getFruitType());
                    fruitStorage.addToFruitStorage(t.getFruitType(), t.getQuantity() + remainder);
                });
    }

    private List<FruitTransaction> getReturnList(List<FruitTransaction> transactions) {
        return transactions.stream()
        .filter(t -> t.getOperation() == FruitTransaction.Operation.RETURN)
        .collect(Collectors.toList());
    }
}

