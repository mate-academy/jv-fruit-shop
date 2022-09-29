package opareation;

import dao.FruitsDao;
import model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    private final FruitsDao fruitsDao;

    public SupplyHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if (fruitsDao.contains(transaction.getFruit())) {
            fruitsDao.addFruit(transaction.getFruit(),
                    transaction.getQuantity()
                            + fruitsDao.getQuantityByFruit(transaction.getFruit()));
        } else {
            fruitsDao.addFruit(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
