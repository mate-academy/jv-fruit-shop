package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FormatTransformer {
    List<FruitTransaction> formatData(List<String> data);

}
