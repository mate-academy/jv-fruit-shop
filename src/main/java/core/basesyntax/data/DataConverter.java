package core.basesyntax.data;

import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> readReport);
}
