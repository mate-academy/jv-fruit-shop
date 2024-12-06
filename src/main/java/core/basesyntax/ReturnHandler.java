package core.basesyntax;

import dao.WareHouseDao;
import dao.impl.WareHouseDaoImpl;

public class ReturnHandler extends OperationHandler {
    private WareHouseDao wareHouseDao;

    public ReturnHandler() {
        this.wareHouseDao = new WareHouseDaoImpl();
    }

    @Override
    public void makeOperation() {
        wareHouseDao.addFruitLot(this.getFruit(), this.getQuantity());
    }
}
