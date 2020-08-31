package core.basesyntax;

import java.util.List;

public class AvailableAmountOfFruits {
    public int toGetAvailableAmountOfFruits(List<FruitPackage> availableFruitsPackages) {
        return availableFruitsPackages
                .stream()
                .mapToInt(FruitPackage::getAmount)
                .sum();
    }
}
