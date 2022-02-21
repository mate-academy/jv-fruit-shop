package strategy.handlers;

import dao.StorageDaoImpl;
import model.FruitModel;
import strategy.OperationHandler;
import strategy.validator.CommodityValidator;
import strategy.validator.StorageValidator;

public class PurchaseOperationHandler implements OperationHandler, StorageValidator,
        CommodityValidator {
    private static final String OPERATION_NAME = "Purchase";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        doesStorageContainsFruit(fruitModel, OPERATION_NAME);
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        StorageDaoImpl storageDao = new StorageDaoImpl();
        int amountAfterPurchase = storageDao.getAmount(fruitModel.getName())
                - fruitModel.getAmount();
        if (amountAfterPurchase < 0) {
            throw new RuntimeException("Operation Purchase. \\n" + "There is not enough fruit "
                    + fruitModel.getName() + "\\n Required " + fruitModel.getAmount()
                    + " but there is " + storageDao.getAmount(fruitModel.getName()));
        }
        storageDao.replaceWithNewAmount(fruitModel.getName(), amountAfterPurchase);
        return true;
    }
}
