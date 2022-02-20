package strategy.handlers;

import static storage.FruitStorage.fruitStorage;

import model.FruitModel;
import storage.FruitStorage;
import strategy.Strategy;
import strategy.validator.CommodityValidator;
import strategy.validator.StorageValidator;

public class Supply implements Strategy, StorageValidator, CommodityValidator {
    private static final String OPERATION_NAME = "Supply";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        doesStorageContainsFruit(fruitModel, OPERATION_NAME);
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        int amountAfterReturn = fruitStorage.get(fruitModel.getName()) + fruitModel.getAmount();
        FruitStorage.fruitStorage.replace(fruitModel.getName(), amountAfterReturn);
        return true;
    }
}
