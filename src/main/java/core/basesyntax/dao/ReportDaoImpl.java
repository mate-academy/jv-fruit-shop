package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReportDaoImpl implements ReportDao {
    private final Storage storage = new Storage();

    @Override
    public Map<String, Integer> getReport() {
        return storage.getFruitTransactionInfo();
    }

    @Override
    public void updateReport(FruitTransaction fruitTransaction) {
        storage.addFruit(fruitTransaction);
    }

    @Override
    public int getBalanceFruitTransaction(FruitTransaction fruitTransaction) {
        return getReport().get(fruitTransaction.getFruit());
    }
}
