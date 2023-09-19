package service.operation;

import database.dao.FruitDao;
import database.dao.FruitDaoImpl;
import model.FruitTransaction;
import service.exception.InvalidDataException;

public class PurchaseOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperation() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int quantityInStorage = fruitDao.get(fruitTransaction.getName());
        int transactionQuantity = fruitTransaction.getQuantity();
        if (quantityInStorage < transactionQuantity) {
            throw new InvalidDataException("Storage doesn't have required amount of '"
                    + fruitTransaction.getName() + "'");
        }
        fruitDao.add(fruitTransaction.getName(), quantityInStorage - transactionQuantity);
    }
}
