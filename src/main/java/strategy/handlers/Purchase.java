package strategy.handlers;

import model.FruitModel;
import storage.FruitStorage;
import strategy.Strategy;
import strategy.validator.CommodityValidator;
import strategy.validator.StorageValidator;

public class Purchase implements Strategy, StorageValidator, CommodityValidator {
    private static final String OPERATION_NAME = "Purchase";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        doesStorageContainsFruit(fruitModel, OPERATION_NAME);
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        int amountAfterPurchase = FruitStorage.fruitStorage.get(fruitModel.getName())
                - fruitModel.getAmount();
        if (amountAfterPurchase < 0) {
            throw new RuntimeException("Operation Purchase. \\n" + "There is not enough fruit "
                    + fruitModel.getName() + "\\n Required " + fruitModel.getAmount()
                    + " but there is " + FruitStorage.fruitStorage.get(fruitModel.getName()));
        }
        FruitStorage.fruitStorage.replace(fruitModel.getName(), amountAfterPurchase);
        return true;
    }
}
