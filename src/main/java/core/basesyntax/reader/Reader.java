package core.basesyntax.reader;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface Reader {
    List<Transaction> read(String filePath);
}
