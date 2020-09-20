package core.storage;

import core.exceptions.NoFruitsEnoughException;

public class FruitOperationsImpl implements FruitOperations{
    StorageService storageService = new StorageService();
    @Override
    public boolean supply(FruitPackageDTO fruitPackageDTO, int quantity) {
        storageService.addToStorage(fruitPackageDTO, quantity);
        return true;
    }

    @Override
    public boolean buy(FruitPackageDTO fruitPackageDTO, int quantity) {
        storageService.removeFromStorage(fruitPackageDTO, quantity);
        return true;
    }

    @Override
    public boolean refund(FruitPackageDTO fruitPackageDTO, int quantity) {
        storageService.addToStorage(fruitPackageDTO, quantity);
        return true;
    }

    public void apply(FruitPackageDTO fruitPackageDTO, int quantity, String operator) throws NoSuchMethodException {
        switch (operator) {
            case "s": {
                supply(fruitPackageDTO, quantity);
                break;
            }
            case "r": {
                refund(fruitPackageDTO, quantity);
                break;
            }
            case "b": {
                buy(fruitPackageDTO, quantity);
                break;
            }
            default: {
                throw new NoSuchMethodException("Operator \"" + operator + "\" is not defined");
            }
        }
    }
}
