package core.basesyntax.fruitshop;

import core.basesyntax.fruit.dto.FruitDto;

public class FruitCheckerImpl implements FruitChecker {
    @Override
    public boolean checkFruits(String[] line) {
        return FruitDto.Fruits.APPLE.name().equalsIgnoreCase(line[1])
                || FruitDto.Fruits.BANANA.name().equalsIgnoreCase(line[1]);
    }
}
