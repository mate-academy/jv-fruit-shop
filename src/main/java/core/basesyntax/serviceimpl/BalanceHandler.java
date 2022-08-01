package core.basesyntax.serviceimpl;

import core.basesyntax.dao.DaoFruitStorage;
import core.basesyntax.daoimpl.DaoFruitStorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceHandler implements OperationHandler {
    private final DaoFruitStorage fruitStorage = new DaoFruitStorageImpl();

    @Override
    public void apply(List<FruitTransaction> transactions) {
        getBalanceList(transactions)
                .forEach(t -> fruitStorage.addToFruitStorage(t.getFruitType(), t.getQuantity()));
    }

    private List<FruitTransaction> getBalanceList(List<FruitTransaction> transactions) {
        return transactions.stream()
        .filter(t -> t.getOperation() == FruitTransaction.Operation.BALANCE)
        .collect(Collectors.toList());
    }
}
