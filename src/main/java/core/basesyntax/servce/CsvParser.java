package core.basesyntax.servce;

import core.basesyntax.model.FruitMovement;
import java.util.List;

public interface CsvParser {
    List<FruitMovement> parse(List<String[]> input);
}
