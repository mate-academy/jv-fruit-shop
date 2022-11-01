package core.basesyntax.service;

import core.basesyntax.model.FruitTransition;
import java.util.List;

public interface TransitionParser {
    List<FruitTransition> parseTransition(List<String> dataFromFile);
}
