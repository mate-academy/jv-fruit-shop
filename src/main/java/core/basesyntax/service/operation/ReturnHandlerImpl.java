package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitRecordDao;
import core.basesyntax.dao.FruitRecordDaoImpl;
import core.basesyntax.model.FruitRecord;
import java.util.Map;

public class ReturnHandlerImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitRecord fruitRecord) {
        FruitRecordDao fruitRecordDao = new FruitRecordDaoImpl();
        for (Map.Entry<String, Integer> e : fruitRecordDao.getFruitMap().entrySet()) {
            if (e.getKey().equals(fruitRecord.getFruitName())) {
                e.setValue(e.getValue() + fruitRecord.getAmount());
            }
        }
    }
}
