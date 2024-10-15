package core.basesyntax;

import java.util.List;

public interface DataConverter {

    List<FruitTransaction> convertToTransaction(List<String> inputData);
}
