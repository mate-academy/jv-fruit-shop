package core.basesyntax;

import dao.WareHouseDao;
import dao.impl.WareHouseDaoImpl;

public class Purchase extends OperationStrategy {
    @Override
    public void makeOperation() {
        WareHouseDao wareHouseDao = new WareHouseDaoImpl();
        int theRest;
        int storedFruits = wareHouseDao.getStoredQuantity(this.getFruit());
        if (this.getQuantity() > storedFruits) {
            throw new RuntimeException("Invalid quantity, " + this.getFruit() + " balance is "
                    + storedFruits);
        }
        theRest = storedFruits - this.getQuantity();
        wareHouseDao.removeFruitLot(this.getFruit());
        wareHouseDao.addFruitLot(this.getFruit(), theRest);
    }
}
