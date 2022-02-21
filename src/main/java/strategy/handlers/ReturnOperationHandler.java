package strategy.handlers;

import dao.StorageDaoImpl;
import model.FruitModel;
import strategy.OperationHandler;
import strategy.validator.CommodityValidator;
import strategy.validator.StorageValidator;

public class ReturnOperationHandler implements OperationHandler, StorageValidator,
        CommodityValidator {
    private static final String OPERATION_NAME = "Return";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        doesStorageContainsFruit(fruitModel, OPERATION_NAME);
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        StorageDaoImpl storageDao = new StorageDaoImpl();
        int amountAfterReturn = storageDao.getAmount(fruitModel.getName()) + fruitModel.getAmount();
        storageDao.replaceWithNewAmount(fruitModel.getName(), amountAfterReturn);
        return true;
    }
}
