package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileToTransactionConverter {
    List<FruitTransaction> convert(List<String> lines);
}
