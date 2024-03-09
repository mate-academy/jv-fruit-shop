package core.basesyntax.service.impl;

import core.basesyntax.dao.RecordDao;
import core.basesyntax.dao.RecordDaoImpl;
import core.basesyntax.record.Record;
import core.basesyntax.service.DataOperation;

public class BalanceOperation implements DataOperation {
    private final RecordDao recordDao = new RecordDaoImpl();

    @Override
    public void operate(Record record) {
        recordDao.put(record.product());
    }
}
