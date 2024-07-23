package core.basesyntax.dao.impl;

import core.basesyntax.dao.ReportDao;
import core.basesyntax.db.DataBase;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReportDaoImpl implements ReportDao {
    private final DataBase dataBase = new DataBase();

    @Override
    public Map<String, Integer> getReport() {
        return dataBase.getFruitTransactionInfo();
    }

    @Override
    public void updateReport(FruitTransaction fruitTransaction) {
        dataBase.addFruitTransactionInfo(fruitTransaction);
    }

    @Override
    public int getBalanceFruitTransaction(FruitTransaction fruitTransaction) {
        return getReport().get(fruitTransaction.getFruit());
    }
}
