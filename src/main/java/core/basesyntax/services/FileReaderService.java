package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileReaderService {
    List<String> read(String fileName);

    List<FruitTransaction> parseTransactions(List<String> lines);
}
