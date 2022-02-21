package strategy.handlers;

import dao.StorageDaoImpl;
import model.FruitModel;
import strategy.OperationHandler;
import strategy.validator.CommodityValidator;

public class BalanceOperationHandler implements OperationHandler, CommodityValidator {
    private static final String OPERATION_NAME = "Balance";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        StorageDaoImpl storageDao = new StorageDaoImpl();
        if (storageDao.containsKey(fruitModel.getName())) {
            throw new RuntimeException("Operation balance Runtime error \\n "
                    + "Fruit " + fruitModel.getName() + " already exists.");
        }
        storageDao.putFruitModel(fruitModel);
        return true;
    }
}
