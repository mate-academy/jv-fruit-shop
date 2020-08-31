package core.basesyntax;

import java.util.List;
import java.util.stream.Collectors;

public class AvailableFruitPackages {
    public List<FruitPackage> getAvailableFruitPackages(FruitPackage fruitPackage,
                                                        Storage storage) {
        List<FruitPackage> availableFruitsPackages = storage.getFruitPackages()
                .stream()
                .filter(position -> position.getType().equals(fruitPackage.getType())
                        && (position.getDate().isAfter(fruitPackage.getDate())
                        || position.getDate().isEqual(fruitPackage.getDate())))
                .collect(Collectors.toList());
        return availableFruitsPackages;
    }
}
