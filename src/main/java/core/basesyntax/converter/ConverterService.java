package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConverterService {
    List<FruitTransaction> convertStringToTransaction(List<String> lines);
}
