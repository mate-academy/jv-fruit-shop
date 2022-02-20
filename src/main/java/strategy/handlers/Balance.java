package strategy.handlers;

import dao.StorageDaoImpl;
import model.FruitModel;
import strategy.Strategy;
import strategy.validator.CommodityValidator;

public class Balance implements Strategy, CommodityValidator {
    private static final String OPERATION_NAME = "Balance";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        StorageDaoImpl storageDao = new StorageDaoImpl();
        if (storageDao.containsKey(fruitModel.getName())) {
            throw new RuntimeException("Operation balance Runtime error \\n "
                    + "Fruit " + fruitModel.getName() + " already exists.");
        }
        storageDao.put(fruitModel);
        return true;
    }
}
