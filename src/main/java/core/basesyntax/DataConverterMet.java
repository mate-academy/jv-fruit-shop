package core.basesyntax;

import java.util.List;

public interface DataConverterMet {
    List<FruitTransaction> convertToTransaction(List<String> readedFruits);
}
