package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;
import exception.InvalidDataException;
import model.FruitTransaction;
import service.impl.FruitServiceImpl;

public class PurchaseOperation implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperation() {
        this.fruitDao = new FruitDaoImpl(new FruitServiceImpl());
    }

    @Override
    public FruitTransaction operate(FruitTransaction fruitTransaction) {
        int quantityInStorage = fruitDao.get(fruitTransaction).getQuantity();
        int transactionQuantity = fruitTransaction.getQuantity();
        if (quantityInStorage < transactionQuantity) {
            throw new InvalidDataException("Storage doesn't have required amount of "
                    + fruitTransaction.getName());
        }
        fruitDao.get(fruitTransaction).setQuantity(quantityInStorage
                - transactionQuantity);
        return fruitDao.get(fruitTransaction);
    }
}
