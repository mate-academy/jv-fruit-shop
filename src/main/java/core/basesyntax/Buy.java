package core.basesyntax;

import java.util.List;

public class Buy extends Operation {
    private AvailableFruitPackages availableFruitPackages
            = new AvailableFruitPackages();
    private CheckingResourcesOfStorage checkingResourcesOfStorage
            = new CheckingResourcesOfStorage();
    private AvailableAmountOfFruits availableAmountOfFruits
            = new AvailableAmountOfFruits();

    @Override
    public void apply(FruitPackage fruitPackage, Storage storage) {
        List<FruitPackage> availableFruitsPackages = availableFruitPackages
                .getAvailableFruitPackages(fruitPackage, storage);
        int amountOfAvailableFruits = availableAmountOfFruits
                .toGetAvailableAmountOfFruits(availableFruitsPackages);
        checkingResourcesOfStorage.checkResourcesOfStorage(fruitPackage,
                storage, availableFruitsPackages, amountOfAvailableFruits);
        int totalAmount = fruitPackage.getAmount();
        FruitPackage firstFruitPackage;
        while (totalAmount > 0 && availableFruitsPackages.size() > 0) {
            firstFruitPackage = availableFruitsPackages.get(0);
            if (totalAmount >= firstFruitPackage.getAmount()) {
                availableFruitsPackages.remove(firstFruitPackage);
                storage.getFruitPackages().remove(firstFruitPackage);
                totalAmount = totalAmount - firstFruitPackage.getAmount();
            } else {
                storage.getFruitPackages()
                        .get(storage.getFruitPackages().indexOf(firstFruitPackage))
                        .setAmount(firstFruitPackage.getAmount() - totalAmount);
                totalAmount = 0;
            }
        }
    }
}
