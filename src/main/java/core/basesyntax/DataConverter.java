package core.basesyntax;

import java.util.List;

public interface DataConverter {
    java.util.List<FruitTransaction> convertToTransaction(List<String> lines);
}
