package OpareationHandler;

import dao.FruitsDao;
import model.FruitTransaction;

public class PurcheseHandler implements OperationHandler {
    private final FruitsDao fruitsDao;

    public PurcheseHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if(transaction.getQuantity() <= fruitsDao
                .getQuantityByFruit(transaction.getFruit())) {
            fruitsDao.addFruit(transaction.getFruit(), fruitsDao.getQuantityByFruit(transaction.getFruit())
                    - transaction.getQuantity());
        } else {
            throw new RuntimeException("Cant purchaser more than fruitDao contain " + transaction.getQuantity());
        }
    }
}
