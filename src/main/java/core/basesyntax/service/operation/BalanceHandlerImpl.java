package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitRecordDao;
import core.basesyntax.dao.FruitRecordDaoImpl;
import core.basesyntax.model.FruitRecord;

public class BalanceHandlerImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitRecord fruitRecord) {
        FruitRecordDao fruitRecordDao = new FruitRecordDaoImpl();
        fruitRecordDao.getFruitMap().put(fruitRecord.getFruitName(), fruitRecord.getAmount());
    }
}
