package strategy.handlers;

import dao.StorageDaoImpl;
import model.FruitModel;
import strategy.Strategy;
import strategy.validator.CommodityValidator;
import strategy.validator.StorageValidator;

public class Return implements Strategy, StorageValidator, CommodityValidator {
    private static final String OPERATION_NAME = "Return";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        doesStorageContainsFruit(fruitModel, OPERATION_NAME);
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        StorageDaoImpl storageDao = new StorageDaoImpl();
        int amountAfterReturn = storageDao.get(fruitModel.getName()) + fruitModel.getAmount();
        storageDao.replace(fruitModel.getName(), amountAfterReturn);
        return true;
    }
}
