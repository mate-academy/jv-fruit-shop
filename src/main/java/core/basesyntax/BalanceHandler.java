package core.basesyntax;

import dao.WareHouseDao;
import dao.impl.WareHouseDaoImpl;

public class BalanceHandler extends OperationHandler {
    private WareHouseDao wareHouseDao;

    public BalanceHandler() {
        this.wareHouseDao = new WareHouseDaoImpl();
    }

    @Override
    public void makeOperation() {
        wareHouseDao.addFruitLot(this.getFruit(), this.getQuantity());
    }
}
