package core.basesyntax;

import java.util.List;

public class Buy extends Operation {
    private AvailableFruitPackages availableFruitPackages
            = new AvailableFruitPackages();
    private AvailableAmountOfFruits availableAmountOfFruits
            = new AvailableAmountOfFruits();

    @Override
    public void apply(FruitPackage fruitPackage, Storage storage) {
        if (storage.getFruitPackages().size() == 0) {
            throw new RuntimeException("We have nothing to sell you");
        }
        List<FruitPackage> availableFruitsPackages = availableFruitPackages
                .toGetAvailableFruitPackages(fruitPackage, storage);
        if (availableFruitsPackages.size() == 0) {
            throw new IllegalArgumentException("We don't have such type of fresh fruits");
        }
        int totalAmount = fruitPackage.getAmount();
        int availableAmountOfFruit = availableAmountOfFruits
                .toGetAvailableAmountOfFruits(availableFruitsPackages);
        if (availableAmountOfFruit < totalAmount) {
            throw new IllegalArgumentException("We don't have so much fresh fruits of this type");
        }
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
