package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;
import model.FruitTransaction;
import service.impl.FruitServiceImpl;

public class SupplyOperation implements OperationHandler {
    private FruitDao fruitDao;

    public SupplyOperation() {
        this.fruitDao = new FruitDaoImpl(new FruitServiceImpl());
    }

    @Override
    public FruitTransaction operate(FruitTransaction fruitTransaction) {
        int quantityInStorage = fruitDao.get(fruitTransaction).getQuantity();
        int transactionQuantity = fruitTransaction.getQuantity();
        fruitDao.get(fruitTransaction).setQuantity(quantityInStorage + transactionQuantity);
        return fruitDao.get(fruitTransaction);
    }
}
