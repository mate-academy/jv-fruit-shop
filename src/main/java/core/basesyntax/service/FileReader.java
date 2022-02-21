package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface FileReader {
    List<Transaction> read(String file);
}
