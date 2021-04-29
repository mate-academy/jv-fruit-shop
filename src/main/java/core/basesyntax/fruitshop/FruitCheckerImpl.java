package core.basesyntax.fruitshop;

import core.basesyntax.fruit.dto.FruitDto;
import java.util.Arrays;

public class FruitCheckerImpl implements FruitChecker {
    @Override
    public boolean checkFruits(String[] line) {
        return Arrays.stream(FruitDto.Fruits.values()).anyMatch(fruit
                -> fruit.name().equalsIgnoreCase(line[1]));
    }
}
