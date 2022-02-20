package strategy.validator;

import model.FruitModel;
import storage.FruitStorage;

public interface StorageValidator extends OperationValidator {
    default boolean doesStorageContainsFruit(FruitModel fruitModel, String operationName) {
        if (!FruitStorage.fruitStorage.containsKey(fruitModel.getName())) {
            throw new RuntimeException("Operation " + operationName
                    + "\\n There is no such fruit " + fruitModel.getName());
        }
        return true;
    }
}
