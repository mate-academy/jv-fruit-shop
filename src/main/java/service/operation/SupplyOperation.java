package service.operation;

import database.dao.FruitDao;
import database.dao.FruitDaoImpl;
import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperation() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int quantityInStorage = fruitDao.get(fruitTransaction.getName());
        int transactionQuantity = fruitTransaction.getQuantity();
        fruitDao.add(fruitTransaction.getName(), quantityInStorage + transactionQuantity);
    }
}
