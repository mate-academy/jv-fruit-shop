package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ExecuteTransactionService;
import java.util.List;

public class ExecuteTransactionServiceImpl implements ExecuteTransactionService {
    private FruitStorageDao dao = new FruitStorageDaoImpl();

    @Override
    public void executeTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            dao.addData(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
