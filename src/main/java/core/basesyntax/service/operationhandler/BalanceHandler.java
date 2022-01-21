package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.RemnantsDao;
import core.basesyntax.dao.RemnantsDaoMap;

public class BalanceHandler implements OperationHandler {

    @Override
    public void apply(String[] recordArray) {
        RemnantsDao remnantsDao = new RemnantsDaoMap();
        if (remnantsDao.fruitIsPresentInStorage(recordArray[1])) {
            remnantsDao.updateFruitRemnant(recordArray[1], Long.parseLong(recordArray[2]));
        } else {
            remnantsDao.addFruitRemnant(recordArray[1], Long.parseLong(recordArray[2]));
        }
    }
}
