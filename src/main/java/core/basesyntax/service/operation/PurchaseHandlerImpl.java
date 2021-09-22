package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitRecordDao;
import core.basesyntax.dao.FruitRecordDaoImpl;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.ValidationException;
import java.util.Map;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void applyOperation(FruitRecord fruitRecord) {
        FruitRecordDao fruitRecordDao = new FruitRecordDaoImpl();
        for (Map.Entry<String, Integer> e : fruitRecordDao.getFruitMap().entrySet()) {
            if (e.getKey().equals(fruitRecord.getFruitName())) {
                if (e.getValue() < fruitRecord.getAmount()) {
                    throw new ValidationException("Can't purchase as stock is low");
                }
                e.setValue(e.getValue() - fruitRecord.getAmount());
            }
        }
    }
}
