package core.basesyntax.service.impl;

import core.basesyntax.dao.IFruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.IFruitTransactionProcessor;
import java.util.List;

public class FruitTransactionProcessor implements IFruitTransactionProcessor {

    private final IFruitTransactionDao fruitTransactionDao;

    public FruitTransactionProcessor(IFruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        transactionList
                .forEach(fruitTransactionDao::add);
    }
}
