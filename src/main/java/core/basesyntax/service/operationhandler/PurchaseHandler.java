package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.RemnantsDao;
import core.basesyntax.dao.RemnantsDaoMap;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void apply(String[] recordArray) {
        RemnantsDao remnantsDao = new RemnantsDaoMap();
        if (remnantsDao.fruitIsPresentInStorage(recordArray[1])) {
            Long oldRemnant = remnantsDao.getFruitRemnant(recordArray[1]);
            Long newRemnant = oldRemnant - Long.parseLong(recordArray[2]);
            remnantsDao.updateFruitRemnant(recordArray[1], newRemnant);
        }
    }
}
