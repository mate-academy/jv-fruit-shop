package core.basesyntax.data;

import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convert(List<String> readReport);
}
