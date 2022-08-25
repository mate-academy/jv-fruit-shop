package core.basesyntax.service;

import core.basesyntax.model.FruitMovement;
import java.util.List;

public interface Parser {
    List<FruitMovement> parse(List<String[]> input);
}
