package core.basesyntax;

import dao.WareHouseDao;
import dao.impl.WareHouseDaoImpl;

public class SupplyHandler extends OperationHandler {
    private WareHouseDao wareHouseDao;

    public SupplyHandler() {
        this.wareHouseDao = new WareHouseDaoImpl();
    }

    @Override
    public void makeOperation() {
        wareHouseDao.addFruitLot(this.getFruit(), this.getQuantity());
    }
}
