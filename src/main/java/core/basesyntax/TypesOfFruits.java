package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypesOfFruits {
    public List<String> toGetTypes(Storage storage) {
        if (storage.getFruits().size() == 0) {
            throw new RuntimeException("We have nothing");
        }
        List<String> typesOfFruits = new ArrayList<>();
        for (Fruit position : storage.getFruits()) {
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
