package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface WriterService {
    void writeFile(List<Transaction> list);
}
