package strategy.handlers;

import model.FruitModel;
import storage.FruitStorage;
import strategy.Strategy;
import strategy.validator.CommodityValidator;

public class Balance implements Strategy, CommodityValidator {
    private static final String OPERATION_NAME = "Balance";

    @Override
    public boolean doOperation(FruitModel fruitModel) {
        isFruitAmountCorrect(fruitModel, OPERATION_NAME);
        if (FruitStorage.fruitStorage.containsKey(fruitModel.getName())) {
            throw new RuntimeException("Operation balance Runtime error \\n "
                    + "Fruit " + fruitModel.getName() + " already exists.");
        }
        FruitStorage.fruitStorage.put(fruitModel.getName(), fruitModel.getAmount());
        return true;
    }
}
