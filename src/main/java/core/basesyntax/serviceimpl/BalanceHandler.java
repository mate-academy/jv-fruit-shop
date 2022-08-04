package core.basesyntax.serviceimpl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.daoimpl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitStorage = new FruitDaoImpl();

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getOperation() == FruitTransaction.Operation.BALANCE) {
            int remainder = fruitStorage.getQuantity(transaction.getFruitType());
            int newQuantity = remainder + transaction.getQuantity();
            fruitStorage.add(transaction.getFruitType(), newQuantity);
        }
    }
}
