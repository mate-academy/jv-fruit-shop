package core.basesyntax;

import java.util.List;

public interface DataConverter {
    public List<FruitTransaction> convertToTransaction(List<String> data);
}
