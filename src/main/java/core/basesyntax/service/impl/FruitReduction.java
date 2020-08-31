package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitDto;
import core.basesyntax.service.FruitOperation;
import java.util.List;
import java.util.stream.Collectors;

public class FruitReduction implements FruitOperation {
    @Override
    public void apply(FruitDto fruitDto) {
        List<Fruit> allFruitsByName = Storage.fruits.stream()
                .filter(fruitName -> fruitName.getName().equals(fruitDto.getFruit()))
                .collect(Collectors.toList());
        if (allFruitsByName.size() < fruitDto.getQuantity() || fruitDto.getQuantity() <= 0) {
            throw new RuntimeException("The report is wrong. It is impossible to buy "
                    + fruitDto.getQuantity() + fruitDto.getFruit() + "s.");
        }
        List<Fruit> fruitsToRemove = allFruitsByName.subList(0, fruitDto.getQuantity());
        Storage.fruits.removeAll(fruitsToRemove);
    }
}
