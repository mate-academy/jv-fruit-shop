package strategy.validator;

import dao.StorageDaoImpl;
import model.FruitModel;

public interface StorageValidator extends OperationValidator {
    default boolean doesStorageContainsFruit(FruitModel fruitModel, String operationName) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        if (!storageDao.containsKey(fruitModel.getName())) {
            throw new RuntimeException("Operation " + operationName
                    + "\\n There is no such fruit " + fruitModel.getName());
        }
        return true;
    }
}
