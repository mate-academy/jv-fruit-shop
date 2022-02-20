package strategy.handlers;

import dao.StorageDaoImpl;
import model.FruitModel;
import strategy.Strategy;
import strategy.validator.CommodityValidator;
import strategy.validator.StorageValidator;

public class Purchase implements Strategy, StorageValidator, CommodityValidator {
    private static final String OPERATION_NAME = "Purchase";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        doesStorageContainsFruit(fruitModel, OPERATION_NAME);
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        StorageDaoImpl storageDao = new StorageDaoImpl();
        int amountAfterPurchase = storageDao.get(fruitModel.getName())
                - fruitModel.getAmount();
        if (amountAfterPurchase < 0) {
            throw new RuntimeException("Operation Purchase. \\n" + "There is not enough fruit "
                    + fruitModel.getName() + "\\n Required " + fruitModel.getAmount()
                    + " but there is " + storageDao.get(fruitModel.getName()));
        }
        storageDao.replace(fruitModel.getName(), amountAfterPurchase);
        return true;
    }
}
