package core.basesyntax.servises;

import core.basesyntax.models.FruitTransition;
import java.util.List;

public interface ParselToTransition {
    List<FruitTransition> parseToFruit(List<String> list);
}
