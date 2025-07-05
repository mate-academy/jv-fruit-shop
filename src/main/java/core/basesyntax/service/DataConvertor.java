package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConvertor {
    List<FruitTransaction> dataConvert(List<String> allLines);
}
