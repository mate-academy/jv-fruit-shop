package core.basesyntax;

import java.util.List;

public interface FruitMapper {
    List<FruitTransaction> convertData(List<String> dataFromFile);
}
