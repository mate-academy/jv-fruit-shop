package core.basesyntax.transactionprocessorimpl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.daoimpl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionprocessor.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final FruitDao fruitStorage = new FruitDaoImpl();

    @Override
    public void handle(FruitTransaction transaction) {
        int remainder = fruitStorage.getQuantity(transaction.getFruitType());
        int newQuantity = remainder + transaction.getQuantity();
        fruitStorage.add(transaction.getFruitType(), newQuantity);
    }
}
