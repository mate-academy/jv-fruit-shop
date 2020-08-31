package core.basesyntax;

import java.util.List;

public class CheckingResourcesOfStorage {
    public void checkResourcesOfStorage(FruitPackage fruitPackage,
                                        Storage storage, List<FruitPackage> availableFruitsPackages,
                                        int amountOfAvailableFruits) {
        if (storage.getFruitPackages().size() == 0) {
            throw new RuntimeException("We have nothing to sell you");
        }
        if (availableFruitsPackages.size() == 0) {
            throw new IllegalArgumentException("We don't have such type of fresh fruits");
        }
        if (amountOfAvailableFruits < fruitPackage.getAmount()) {
            throw new IllegalArgumentException("We don't have so much fresh fruits of this type");
        }
    }
}
