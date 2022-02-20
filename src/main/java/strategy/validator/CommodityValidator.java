package strategy.validator;

import model.FruitModel;

public interface CommodityValidator extends OperationValidator {
    default boolean isFruitAmountCorrect(FruitModel fruitModel, String operationName) {
        if (fruitModel.getAmount() < 0) {
            throw new RuntimeException("Negative amount for operation" + operationName
                    + "\\n " + fruitModel);
        }
        return true;
    }
}
