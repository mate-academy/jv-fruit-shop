package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypesOfFruitsInStorage {
    public List<String> getTypesOfFruits(Storage storage) {
        if (storage.getFruitPackages().size() == 0) {
            throw new RuntimeException("We have nothing");
        }
        List<String> typesOfFruits = new ArrayList<>();
        for (FruitPackage position : storage.getFruitPackages()) {
            List<String> temp = typesOfFruits
                    .stream()
                    .filter(unit -> unit.equals(position.getType()))
                    .collect(Collectors.toList());
            if (temp.size() == 0) {
                typesOfFruits.add(position.getType());
            }
        }
        return typesOfFruits;
    }
}
