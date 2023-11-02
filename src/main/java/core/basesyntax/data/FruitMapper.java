package core.basesyntax.data;

import java.util.List;

public interface FruitMapper {
    List<FruitTransaction> mapData(List<String> lines);
}
