package core.basesyntax;

import dao.WareHouseDao;
import dao.impl.WareHouseDaoImpl;

public class Supply extends OperationStrategy {
    @Override
    public void makeOperation() {
        WareHouseDao wareHouseDao = new WareHouseDaoImpl();
        wareHouseDao.addFruitLot(this.getFruit(), this.getQuantity());
    }
}
