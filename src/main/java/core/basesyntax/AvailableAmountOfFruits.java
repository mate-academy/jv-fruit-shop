package core.basesyntax;

import java.util.List;

public class AvailableAmountOfFruits {
    public int toGetAvailableAmountOfFruits(List<FruitPackage> availableFruitPackages) {
        return availableFruitPackages
                .stream()
                .mapToInt(FruitPackage::getAmount)
                .sum();
    }
}
