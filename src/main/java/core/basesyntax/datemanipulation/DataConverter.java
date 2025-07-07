package core.basesyntax.datemanipulation;

import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> list);
}
