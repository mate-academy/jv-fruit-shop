package core.basesyntax;

import java.util.List;

public class Buy extends Operation {
    @Override
    public void toDo(FruitPackage fruitPackage, Storage storage) {
        if (storage.getFruitPackages().size() == 0) {
            throw new RuntimeException("We have nothing to sell you");
        }
        AvailableFruitPackages availableFruitPackages = new AvailableFruitPackages();
        List<FruitPackage> availableFruitsPackages = availableFruitPackages
                .toGetAvailableFruitPackages(fruitPackage, storage);
        if (availableFruitsPackages.size() == 0) {
            throw new IllegalArgumentException("We don't have such type of fresh fruits");
        }
        int totalAmount = fruitPackage.getAmount();
        AvailableAmountOfFruits availableAmountOfFruits
                = new AvailableAmountOfFruits();
        int availableAmountOfFruit = availableAmountOfFruits
                .toGetAvailableAmountOfFruits(availableFruitsPackages);
        if (availableAmountOfFruit < totalAmount) {
            throw new IllegalArgumentException("We don't have so much fresh fruits of this type");
        }
        FruitPackage firstFruitPackage = availableFruitsPackages.get(0);
        while (totalAmount > 0) {
            if (totalAmount > firstFruitPackage.getAmount()) {
                availableFruitsPackages.remove(firstFruitPackage);
                storage.getFruitPackages().remove(firstFruitPackage);
                totalAmount = totalAmount - firstFruitPackage.getAmount();
                firstFruitPackage = availableFruitsPackages.get(0);
            } else if (totalAmount == firstFruitPackage.getAmount()) {
                storage.getFruitPackages().remove(firstFruitPackage);
                totalAmount = 0;
            } else {
                storage.getFruitPackages()
                        .get(storage.getFruitPackages().indexOf(firstFruitPackage))
                        .setAmount(firstFruitPackage.getAmount() - totalAmount);
                totalAmount = 0;
            }
        }
    }
}
